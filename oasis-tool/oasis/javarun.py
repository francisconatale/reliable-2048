"""Compilación y ejecución de Java: especificación, extracción de métodos y arnés que evalúa la aserción."""
import json
import os
import re
import shutil
import subprocess
import tempfile
from concurrent.futures import ThreadPoolExecutor
from dataclasses import dataclass, field

TEST_TIMEOUT_MS = 3000


@dataclass
class Spec:
    name: str
    source: str            # texto completo del .java
    class_name: str
    package: str
    method: str
    ret: str
    params: list           # [(tipo, nombre)]
    pre: str               # expresión Java booleana ("true" si no hay)
    assertion: str         # expresión Java booleana sobre parámetros, `result` y `old_<param>`
    description: str = ""

    @property
    def qualified(self):
        return f"{self.package}.{self.class_name}" if self.package else self.class_name

    @property
    def method_text(self):
        s, e = method_span(self.source, self.method)
        return self.source[s:e]

    @property
    def helpers(self):
        """Firmas de los demás métodos estáticos de la clase (se pueden usar en aserciones)."""
        out = []
        for m in re.finditer(r"static\s+(?:final\s+)?([\w<>\[\],.?]+)\s+(\w+)\s*\(([^)]*)\)\s*(?:throws[^{]*)?\{", self.source):
            if m.group(2) != self.method:
                out.append(f"{self.class_name}.{m.group(2)}({m.group(3).strip()}) -> {m.group(1)}")
        return out


def split_top_level(s, sep=","):
    out, depth, cur = [], 0, ""
    for ch in s:
        if ch in "<([":
            depth += 1
        elif ch in ">)]":
            depth -= 1
        if ch == sep and depth == 0:
            out.append(cur)
            cur = ""
        else:
            cur += ch
    if cur.strip():
        out.append(cur)
    return [p.strip() for p in out]


def _sig_regex(method):
    return re.compile(r"(?:public\s+|private\s+|protected\s+)?static\s+(?:final\s+)?([\w<>\[\],.\s?]+?)\s+"
                      + re.escape(method) + r"\s*\(([^)]*)\)\s*(?:throws[^{]*)?\{")


def method_span(source, method):
    """(inicio, fin) del método estático `method`, incluyendo su llave de cierre."""
    m = _sig_regex(method).search(source)
    if not m:
        raise ValueError(f"no se encontró el método estático '{method}'")
    i = m.end()          # justo después de '{'
    depth, n = 1, len(source)
    while i < n and depth:
        c = source[i]
        if source.startswith("//", i):
            i = source.find("\n", i)
            i = n if i < 0 else i
            continue
        if source.startswith("/*", i):
            i = source.find("*/", i) + 2
            continue
        if c in "\"'":
            q = c
            i += 1
            while i < n and source[i] != q:
                i += 2 if source[i] == "\\" else 1
        elif c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
        i += 1
    return m.start(), i


def replace_method(source, method, new_text):
    s, e = method_span(source, method)
    return source[:s] + new_text.strip() + source[e:]


def load_spec(path):
    with open(path, encoding="utf-8") as f:
        cfg = json.load(f)
    base = os.path.dirname(os.path.abspath(path))
    with open(os.path.join(base, cfg["source"]), encoding="utf-8") as f:
        source = f.read()
    cls = re.search(r"\bclass\s+(\w+)", source).group(1)
    pkg = re.search(r"^\s*package\s+([\w.]+)\s*;", source, re.M)
    m = _sig_regex(cfg["method"]).search(source)
    if not m:
        raise ValueError(f"no se encontró el método estático '{cfg['method']}' en {cfg['source']}")
    params = []
    for p in split_top_level(m.group(2)):
        p = re.sub(r"\bfinal\s+", "", p)
        t, n = p.rsplit(None, 1)
        params.append((t.strip(), n.strip()))
    return Spec(name=cfg.get("name", cfg["method"]), source=source, class_name=cls,
                package=pkg.group(1) if pkg else "", method=cfg["method"], ret=m.group(1).strip(),
                params=params, pre=cfg.get("pre", "true") or "true", assertion=cfg["assertion"],
                description=cfg.get("description", ""))


# ---------------------------------------------------------------- arnés

RUNNER_HEAD = r"""
import java.util.*;

public class OasisRunner {
    static String show(Object o) {
        if (o == null) return "null";
        if (o.getClass().isArray()) {
            int n = java.lang.reflect.Array.getLength(o);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(", ");
                sb.append(show(java.lang.reflect.Array.get(o, i)));
            }
            return sb.append("]").toString();
        }
        return String.valueOf(o).replace("\t", " ").replace("\n", " ");
    }
    static Object copy(Object o) {
        if (o == null || !o.getClass().isArray()) return o;
        int n = java.lang.reflect.Array.getLength(o);
        Object c = java.lang.reflect.Array.newInstance(o.getClass().getComponentType(), n);
        for (int i = 0; i < n; i++) java.lang.reflect.Array.set(c, i, copy(java.lang.reflect.Array.get(o, i)));
        return c;
    }
    interface Body { String run() throws Throwable; }
    static String err(String tag, Throwable e) {
        return tag + "\t" + e.getClass().getName() + ": " + String.valueOf(e.getMessage()).replace("\n", " ") + "\t";
    }
    static void exec(int idx, Body b) {
        final String[] out = new String[1];
        Thread t = new Thread(() -> {
            try { out[0] = b.run(); } catch (Throwable e) { out[0] = err("EXC", e); }
        });
        t.setDaemon(true);
        t.start();
        try { t.join(%TIMEOUT%); } catch (InterruptedException e) { }
        System.out.println("T" + idx + "\t" + (t.isAlive() ? "TIMEOUT\t\t" : out[0]));
        System.out.flush();
    }
    public static void main(String[] args) {
"""

RUNNER_TAIL = """
        System.out.flush();
        Runtime.getRuntime().halt(0);
    }
}
"""


def _is_ref(t):
    return not re.fullmatch(r"(int|long|short|byte|char|boolean|float|double)", t)


def gen_runner(spec, tests, assertion=None):
    """Genera OasisRunner.java. Devuelve (texto, {idx_test: (linea_ini, linea_fin)})."""
    assertion = spec.assertion if assertion is None else assertion
    q = spec.qualified
    head = RUNNER_HEAD.replace("%TIMEOUT%", str(TEST_TIMEOUT_MS))
    lines = head.split("\n")
    ranges = {}
    for i, args in enumerate(tests):
        start = len(lines) + 1
        body = []
        for (t, n), expr in zip(spec.params, args):
            body.append(f"            {t} {n} = ({expr});")
        for t, n in spec.params:
            body.append(f"            {t} old_{n} = " + (f"({t}) copy({n});" if _is_ref(t) else f"{n};"))
        call_args = ", ".join(n for _, n in spec.params)
        post = " + \" ; \" + ".join(f"show({n})" for _, n in spec.params) or '""'
        body.append("            try { if (!(" + spec.pre + ")) return \"SKIP\\t\\t\"; }"
                    " catch (Throwable e) { return \"SKIP\\t\\t\"; }")
        if spec.ret == "void":
            body.append(f"            try {{ {q}.{spec.method}({call_args}); }} catch (Throwable e) {{ return err(\"EXC\", e); }}")
            res_show = '"void"'
            body.append("            boolean ok;")
        else:
            body.append(f"            {spec.ret} result;")
            body.append(f"            try {{ result = {q}.{spec.method}({call_args}); }} catch (Throwable e) {{ return err(\"EXC\", e); }}")
            res_show = "show(result)"
            body.append("            boolean ok;")
        body.append("            try { ok = (" + assertion + "); }"
                    " catch (Throwable e) { return err(\"ASSERT_ERR\", e) + " + res_show + " + \"\\t\" + " + post + "; }")
        body.append("            return (ok ? \"PASS\" : \"FAIL\") + \"\\t\" + " + res_show + " + \"\\t\" + " + post + ";")
        lines.append(f"        exec({i}, () -> {{")
        lines.extend(body)
        lines.append("        });")
        ranges[i] = (start, len(lines))
    lines.extend(RUNNER_TAIL.split("\n"))
    return "\n".join(lines), ranges


@dataclass
class Outcome:
    status: str            # PASS FAIL SKIP EXC TIMEOUT ASSERT_ERR
    result: str = ""
    post: str = ""
    detail: str = ""


@dataclass
class RunResult:
    compiled: bool
    compile_error: str = ""
    outcomes: dict = field(default_factory=dict)   # idx -> Outcome


def _write(path, text):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        f.write(text)


def compile_and_run(spec, subject_src, runner_src, timeout=90):
    d = tempfile.mkdtemp(prefix="oasis_")
    try:
        sub = os.path.join(d, *(spec.package.split(".") if spec.package else []), spec.class_name + ".java")
        _write(sub, subject_src)
        _write(os.path.join(d, "OasisRunner.java"), runner_src)
        out = os.path.join(d, "out")
        os.makedirs(out)
        c = subprocess.run(["javac", "-nowarn", "-encoding", "UTF-8", "-d", out, sub,
                            os.path.join(d, "OasisRunner.java")],
                           capture_output=True, text=True, timeout=120)
        if c.returncode != 0:
            return RunResult(False, c.stderr.replace(d + os.sep, ""))
        try:
            r = subprocess.run(["java", "-cp", out, "OasisRunner"], capture_output=True, text=True, timeout=timeout)
            stdout = r.stdout
        except subprocess.TimeoutExpired as e:
            stdout = (e.stdout or b"").decode(errors="replace") if isinstance(e.stdout, bytes) else (e.stdout or "")
        outcomes = {}
        for ln in stdout.split("\n"):
            m = re.match(r"T(\d+)\t(.*)$", ln)
            if not m:
                continue
            parts = m.group(2).split("\t")
            parts += [""] * (4 - len(parts))
            st = parts[0]
            if st in ("EXC", "ASSERT_ERR"):
                # EXC\t<detalle>\t ;  ASSERT_ERR\t<detalle>\t<resultado>\t<post>
                outcomes[int(m.group(1))] = Outcome(st, parts[2], parts[3], parts[1])
            else:
                outcomes[int(m.group(1))] = Outcome(st, parts[1], parts[2])
        return RunResult(True, "", outcomes)
    finally:
        shutil.rmtree(d, ignore_errors=True)


def compile_only(spec, runner_src):
    """Compila el sujeto original con el arnés; devuelve None si compila, o el mensaje de error."""
    d = tempfile.mkdtemp(prefix="oasis_c_")
    try:
        sub = os.path.join(d, *(spec.package.split(".") if spec.package else []), spec.class_name + ".java")
        _write(sub, spec.source)
        _write(os.path.join(d, "OasisRunner.java"), runner_src)
        out = os.path.join(d, "out")
        os.makedirs(out)
        c = subprocess.run(["javac", "-nowarn", "-encoding", "UTF-8", "-d", out, sub,
                            os.path.join(d, "OasisRunner.java")], capture_output=True, text=True, timeout=120)
        return None if c.returncode == 0 else c.stderr.replace(d + os.sep, "")
    finally:
        shutil.rmtree(d, ignore_errors=True)


def _default_expr(t):
    if t == "boolean":
        return "false"
    if t == "char":
        return "(char) 0"
    if re.fullmatch(r"(int|long|short|byte|float|double)", t):
        return "0"
    return "null"


_COMPILED_OK = set()


def check_assertion_compiles(spec, assertion=None):
    """Comprueba que la precondición y la aserción compilan, con una entrada ficticia (valores por defecto).

    Es necesario porque un error en la aserción aparece en TODAS las pruebas: sin esta comprobación se
    confundiría con "todas las pruebas son inválidas" y se descartarían en silencio.
    """
    assertion = spec.assertion if assertion is None else assertion
    key = (spec.qualified, spec.method, spec.pre, assertion)
    if key in _COMPILED_OK:
        return
    runner, _ = gen_runner(spec, [[_default_expr(t) for t, _ in spec.params]], assertion)
    err = compile_only(spec, runner)
    if err is not None:
        raise RuntimeError("la aserción o la precondición no compilan:\n" + err[:1500])
    _COMPILED_OK.add(key)


def validate_tests(spec, tests, assertion=None):
    """Descarta las pruebas cuyos argumentos no compilan. Devuelve (tests_válidos, rechazadas).

    Lanza RuntimeError si la aserción o la precondición no compilan.
    """
    check_assertion_compiles(spec, assertion)
    tests = [list(t) for t in tests]
    rejected = []
    for _ in range(6):
        if not tests:
            break
        runner, ranges = gen_runner(spec, tests, assertion)
        c = compile_only(spec, runner)
        if c is None:
            return tests, rejected
        bad = set()
        for m in re.finditer(r"OasisRunner\.java:(\d+): error", c):
            ln = int(m.group(1))
            for i, (a, b) in ranges.items():
                if a <= ln <= b:
                    bad.add(i)
        if not bad:
            raise RuntimeError("no compila el arnés:\n" + c[:1500])
        rejected.extend(tests[i] for i in sorted(bad))
        tests = [t for i, t in enumerate(tests) if i not in bad]
    return tests, rejected


def run_variants(spec, variants, tests, assertion=None, workers=4):
    """Ejecuta {etiqueta: código_fuente} con las mismas pruebas. Devuelve {etiqueta: RunResult}."""
    runner, _ = gen_runner(spec, tests, assertion)
    with ThreadPoolExecutor(max_workers=workers) as ex:
        futs = {k: ex.submit(compile_and_run, spec, src, runner) for k, src in variants.items()}
        return {k: f.result() for k, f in futs.items()}
