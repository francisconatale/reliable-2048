import argparse
import json
import sys

from .fn import run_fn
from .fp import run_fp
from .javarun import load_spec
from .llm import CachedLLM, LLMError, OpenAICompatLLM, PROVIDERS, ReplayLLM
from .report import full_report


def main(argv=None):
    ap = argparse.ArgumentParser(prog="oasis", description="Refinamiento de aserciones con LLM (OASIs simplificado)")
    ap.add_argument("mode", choices=["fp", "fn", "both"],
                    help="fp: buscar tests que violan la aserción; fn: buscar mutantes que la aserción no mata")
    ap.add_argument("--spec", required=True, help="spec.json del caso (fuente, método, precondición, aserción)")
    ap.add_argument("--assertion", help="reemplaza la aserción del spec (para probar un refinamiento)")
    ap.add_argument("--provider", default="openrouter", choices=sorted(PROVIDERS))
    ap.add_argument("--model", help="modelo (por defecto, el del proveedor o la variable OASIS_MODEL)")
    ap.add_argument("--replay", help="respuestas guionadas (JSON) en lugar de llamar a un LLM; solo para probar sin red")
    ap.add_argument("--cache", default=".oasis_cache", help="directorio donde se guardan las respuestas del LLM (vacío = sin caché)")
    ap.add_argument("--temperature", type=float, default=0.4)
    ap.add_argument("--rounds", type=int, default=2)
    ap.add_argument("--tests", type=int, default=10, help="entradas pedidas por ronda")
    ap.add_argument("--mutants", type=int, default=10, help="mutantes pedidos al LLM")
    ap.add_argument("--no-operators", action="store_true", help="no agregar mutantes por operadores")
    ap.add_argument("--out", help="archivo Markdown de salida")
    ap.add_argument("--json", help="archivo JSON con el detalle")
    a = ap.parse_args(argv)

    spec = load_spec(a.spec)
    if a.assertion:
        spec.assertion = a.assertion
    try:
        llm = ReplayLLM(a.replay) if a.replay else OpenAICompatLLM(a.provider, a.model, temperature=a.temperature)
        if a.cache and not a.replay:
            llm = CachedLLM(llm, a.cache)
        fp = run_fp(spec, llm, rounds=max(a.rounds, 1), n_tests=a.tests) if a.mode in ("fp", "both") else None
        fn = (run_fn(spec, llm, n_mutants=a.mutants, n_tests=a.tests, rounds=a.rounds,
                     use_operators=not a.no_operators) if a.mode in ("fn", "both") else None)
    except LLMError as e:
        print(f"error: {e}", file=sys.stderr)
        return 2
    except RuntimeError as e:          # la aserción o la precondición del spec no compilan
        print(f"error: {e}", file=sys.stderr)
        return 3
    text = full_report(spec, llm.name, fp, fn)
    print(text)
    if a.out:
        with open(a.out, "w", encoding="utf-8") as f:
            f.write(text + "\n")
    if a.json:
        with open(a.json, "w", encoding="utf-8") as f:
            json.dump({"model": llm.name, "spec": a.spec, "fp": fp, "fn": fn}, f, ensure_ascii=False, indent=1)
    return 0


if __name__ == "__main__":
    sys.exit(main())
