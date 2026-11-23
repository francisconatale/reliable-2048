"""Falsos positivos: busca entradas válidas que violan la aserción (aserción demasiado fuerte)."""
from . import prompts
from .javarun import compile_and_run, gen_runner, validate_tests
from .llm import ask_json


def parse_tests(obj, spec):
    items = obj.get("tests", []) if isinstance(obj, dict) else obj
    out = []
    for it in items or []:
        args = it.get("args") if isinstance(it, dict) else it
        if isinstance(args, list) and len(args) == len(spec.params) and all(isinstance(a, (str, int, float, bool)) for a in args):
            out.append([str(a) for a in args])
    return out


def run_tests(spec, tests, assertion=None):
    """Ejecuta el programa original. Devuelve lista de dicts {args, status, result, post, detail}."""
    if not tests:
        return []
    runner, _ = gen_runner(spec, tests, assertion)
    r = compile_and_run(spec, spec.source, runner)
    if not r.compiled:
        raise RuntimeError("no compila el arnés:\n" + r.compile_error[:1500])
    rows = []
    for i, args in enumerate(tests):
        o = r.outcomes.get(i)
        rows.append({"args": args, "status": o.status if o else "MISSING",
                     "result": o.result if o else "", "post": o.post if o else "", "detail": o.detail if o else ""})
    return rows


def run_fp(spec, llm, assertion=None, rounds=3, n_tests=8, stop_after=3):
    assertion = assertion or spec.assertion
    log = {"mode": "fp", "assertion": assertion, "rounds": [], "violations": [], "crashes": [],
           "held": [], "rejected_tests": [], "explanation": None, "suggestion_check": None}
    seen = set()
    for r in range(rounds):
        obj = ask_json(llm, "fp_tests", prompts.SYSTEM, prompts.fp_tests(spec, assertion, n_tests, log["held"]))
        tests = [t for t in parse_tests(obj, spec) if tuple(t) not in seen]
        seen.update(tuple(t) for t in tests)
        tests, rej = validate_tests(spec, tests, assertion)
        log["rejected_tests"].extend(rej)
        rows = run_tests(spec, tests, assertion)
        log["rounds"].append({"reasoning": obj.get("reasoning", "") if isinstance(obj, dict) else "",
                              "proposed": len(tests) + len(rej), "valid": len(tests)})
        for row in rows:
            if row["status"] == "FAIL":
                log["violations"].append(row)
            elif row["status"] in ("EXC", "TIMEOUT"):
                log["crashes"].append(row)
            elif row["status"] == "PASS":
                log["held"].append(row)
        if len(log["violations"]) >= stop_after:
            break
    if log["violations"]:
        exp = ask_json(llm, "fp_explain", prompts.SYSTEM, prompts.fp_explain(spec, assertion, log["violations"]))
        log["explanation"] = exp if isinstance(exp, dict) else {"explanation": str(exp)}
        sug = (log["explanation"].get("suggested_assertion") or "").strip()
        if sug:
            log["suggestion_check"] = check_assertion(spec, sug, log["violations"] + log["held"])
    return log


def check_assertion(spec, candidate, rows):
    """Evalúa una aserción candidata sobre las entradas ya probadas (con el programa original)."""
    tests = [r["args"] for r in rows]
    out = {"assertion": candidate, "compiles": True, "violated_on": [], "checked": 0}
    try:
        valid, _ = validate_tests(spec, tests, candidate)
        res = run_tests(spec, valid, candidate)
    except RuntimeError as e:
        out["compiles"] = False
        out["error"] = str(e)[:300]
        return out
    out["checked"] = len(res)
    out["violated_on"] = [r for r in res if r["status"] == "FAIL"]
    return out
