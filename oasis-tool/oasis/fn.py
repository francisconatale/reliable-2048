"""Falsos negativos: genera mutantes que la aserción no mata (aserción demasiado débil)."""
from . import prompts
from .fp import parse_tests
from .javarun import replace_method, run_variants, validate_tests
from .llm import ask_json
from .mutate import operator_mutants

ORIG = "__original__"


def _classify(orig, mut, tests):
    """Compara un mutante con el original. Devuelve (clase, índice_testigo | None).

    Clases: invalid (no compila), killed (la aserción falla), survived (la aserción se cumple pero el
    resultado difiere), crashed (lanza excepción o cuelga donde el original no: lo detecta cualquier prueba,
    no es un problema de la aserción) y equivalent_so_far (igual al original en todas las entradas).
    """
    if not mut.compiled:
        return "invalid", None
    killed = witness = crash = None
    for i in range(len(tests)):
        o, m = orig.outcomes.get(i), mut.outcomes.get(i)
        if o is None or o.status != "PASS" or m is None:
            continue            # entrada que el original no maneja bien (SKIP/EXC/FAIL): no sirve de referencia
        if m.status in ("FAIL", "ASSERT_ERR"):
            killed = i if killed is None else killed
        elif m.status in ("EXC", "TIMEOUT"):
            crash = i if crash is None else crash
        elif witness is None and (m.result, m.post) != (o.result, o.post):
            witness = i
    if killed is not None:
        return "killed", killed
    if witness is not None:
        return "survived", witness
    if crash is not None:
        return "crashed", crash
    return "equivalent_so_far", None


def run_fn(spec, llm, assertion=None, n_mutants=10, n_tests=10, rounds=2, use_operators=True,
           max_operator_mutants=12, max_distinguish=8, seed=0):
    assertion = assertion or spec.assertion
    log = {"mode": "fn", "assertion": assertion, "mutants": [], "tests": 0, "rejected_tests": [],
           "invalid_mutants": 0, "suggestion": None, "suggestion_check": None}

    # 1) mutantes: LLM + operadores
    muts = []
    obj = ask_json(llm, "fn_mutants", prompts.SYSTEM, prompts.fn_mutants(spec, assertion, n_mutants))
    for m in (obj.get("mutants", []) if isinstance(obj, dict) else obj):
        if isinstance(m, dict) and isinstance(m.get("code"), str):
            muts.append({"description": "[LLM] " + str(m.get("description", "")), "code": m["code"], "origin": "llm"})
    if use_operators:
        for m in operator_mutants(spec.source, spec.method, max_operator_mutants, seed):
            muts.append({**m, "origin": "operator"})
    uniq, seen = [], {spec.method_text.strip()}
    for m in muts:
        key = m["code"].strip()
        if key not in seen:
            seen.add(key)
            uniq.append(m)
    muts = uniq
    for i, m in enumerate(muts):
        m["id"] = f"M{i + 1}"
        try:
            m["source"] = replace_method(spec.source, spec.method, m["code"])
        except ValueError:
            m["source"] = None

    # 2) pruebas
    obj = ask_json(llm, "fn_tests", prompts.SYSTEM, prompts.fn_tests(spec, assertion, n_tests))
    tests = parse_tests(obj, spec)

    def evaluate(tests, targets):
        tests, rej = validate_tests(spec, tests, assertion)
        log["rejected_tests"].extend(rej)
        variants = {ORIG: spec.source}
        variants.update({m["id"]: m["source"] for m in targets if m["source"]})
        res = run_variants(spec, variants, tests, assertion)
        for m in targets:
            if not m["source"]:
                m["cls"], m["witness_idx"] = "invalid", None
                continue
            cls, idx = _classify(res[ORIG], res[m["id"]], tests)
            m["cls"], m["witness_idx"] = cls, idx
            if cls in ("killed", "survived", "crashed") and idx is not None:
                o, mm = res[ORIG].outcomes[idx], res[m["id"]].outcomes[idx]
                m["witness"] = {"args": tests[idx], "orig_result": o.result, "orig_post": o.post,
                                "mut_result": mm.result if mm.status in ("PASS", "FAIL") else f"{mm.status} {mm.detail}",
                                "mut_post": mm.post, "status": mm.status}
            m.pop("witness_idx", None)
        return tests, res

    tests, res = evaluate(tests, muts)

    # 3) rondas de refinamiento: pedir entradas que distingan a los mutantes que sobreviven sin testigo
    for _ in range(rounds):
        pending = [m for m in muts if m["cls"] == "equivalent_so_far"][:max_distinguish]
        if not pending:
            break
        extra = []
        for m in pending:
            try:
                o = ask_json(llm, "fn_distinguish", prompts.SYSTEM, prompts.fn_distinguish(spec, assertion, m, 4))
                extra += parse_tests(o, spec)
            except Exception:
                continue
        known = {tuple(t) for t in tests}
        extra = [t for t in extra if tuple(t) not in known]
        if not extra:
            break
        tests, res = evaluate(tests + extra, pending)
    log["tests"] = len(tests)

    for m in muts:
        log["mutants"].append({k: m.get(k) for k in ("id", "description", "origin", "cls", "code", "witness")})
    log["invalid_mutants"] = sum(1 for m in muts if m["cls"] == "invalid")

    # 4) feedback: aserción más fuerte sugerida (se valida con el original; la decisión es del usuario)
    surv = [m for m in muts if m["cls"] == "survived"]
    if surv:
        sug = ask_json(llm, "fn_assertion", prompts.SYSTEM, prompts.fn_assertion(spec, assertion, surv))
        cand = (sug.get("assertion") or "").strip() if isinstance(sug, dict) else ""
        log["suggestion"] = sug if isinstance(sug, dict) else {"explanation": str(sug)}
        if cand:
            log["suggestion_check"] = check_suggestion(spec, cand, tests, muts)
    return log


def check_suggestion(spec, cand, tests, muts):
    """Valida la aserción sugerida: debe compilar, cumplirse en el original y matar mutantes."""
    out = {"assertion": cand, "compiles": True, "violated_by_original_on": [], "now_killed": [], "still_surviving": []}
    try:
        valid, _ = validate_tests(spec, tests, cand)      # lanza RuntimeError si la aserción no compila
        variants = {ORIG: spec.source}
        variants.update({m["id"]: m["source"] for m in muts if m["source"] and m["cls"] in ("survived", "equivalent_so_far")})
        res = run_variants(spec, variants, valid, cand)
    except RuntimeError as e:
        out["compiles"] = False
        out["error"] = str(e)[:400]
        return out
    for i, a in enumerate(valid):
        o = res[ORIG].outcomes.get(i)
        if o and o.status == "FAIL":
            out["violated_by_original_on"].append({"args": a, "result": o.result})
    for m in muts:
        if m["id"] not in res:
            continue
        k = any(o.status == "FAIL" for o in res[m["id"]].outcomes.values())
        (out["now_killed"] if k else out["still_surviving"]).append(m["id"])
    return out
