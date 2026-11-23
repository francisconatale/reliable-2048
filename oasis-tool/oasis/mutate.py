"""Mutantes por operadores sencillos (complemento determinista a los mutantes propuestos por el LLM)."""
import random
import re

from .javarun import method_span

# (patrón sobre el texto enmascarado, reemplazo, descripción)
OPS = [
    (r"<=", "<", "<= -> <"), (r"(?<![<=!>-])<(?![<=])", "<=", "< -> <="),
    (r">=", ">", ">= -> >"), (r"(?<![<=!>-])>(?![>=])", ">=", "> -> >="),
    (r"==", "!=", "== -> !="), (r"!=", "==", "!= -> =="),
    (r"&&", "||", "&& -> ||"), (r"\|\|", "&&", "|| -> &&"),
    (r"(?<=[\w\)\]])\s*\+(?![+=])", " -", "+ -> -"),
    (r"(?<=[\w\)\]])\s*-(?![-=>])", " +", "- -> +"),
    (r"\*(?![=/])", "/", "* -> /"), (r"(?<![*/])/(?![=/*])", "*", "/ -> *"),
    (r"\+\+", "--", "++ -> --"), (r"--", "++", "-- -> ++"),
]


def _mask(src):
    """Reemplaza por espacios el contenido de comentarios, cadenas y caracteres."""
    out = list(src)
    i, n = 0, len(src)
    while i < n:
        if src.startswith("//", i):
            j = src.find("\n", i)
            j = n if j < 0 else j
        elif src.startswith("/*", i):
            j = src.find("*/", i) + 2
        elif src[i] in "\"'":
            q, j = src[i], i + 1
            while j < n and src[j] != q:
                j += 2 if src[j] == "\\" else 1
            j += 1
        else:
            i += 1
            continue
        for k in range(i, min(j, n)):
            if out[k] != "\n":
                out[k] = " "
        i = j
    return "".join(out)


def operator_mutants(source, method, max_mutants=20, seed=0):
    """Devuelve [{description, code}] donde `code` es el método completo mutado (un cambio por mutante)."""
    s, e = method_span(source, method)
    text = source[s:e]
    masked = _mask(text)
    brace = masked.find("{")
    cands = []
    for pat, rep, desc in OPS:
        for m in re.finditer(pat, masked):
            if m.start() < brace:
                continue
            cands.append((m.start(), m.end(), rep, desc))
    for m in re.finditer(r"(?<![\w.])\d+(?![\w.])", masked):
        if m.start() < brace:
            continue
        v = int(m.group())
        for nv in {v + 1, max(v - 1, 0)} - {v}:
            cands.append((m.start(), m.end(), str(nv), f"constante {v} -> {nv}"))
    random.Random(seed).shuffle(cands)
    out, seen = [], {text}
    for a, b, rep, desc in cands:
        code = text[:a] + rep + text[b:]
        if code in seen:
            continue
        seen.add(code)
        line = text.count("\n", 0, a) + 1
        out.append({"description": f"[operador] {desc} (línea {line} del método)", "code": code})
        if len(out) >= max_mutants:
            break
    return out
