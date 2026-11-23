"""Pruebas de la herramienta. Usan ReplayLLM (respuestas guionadas), por lo que no necesitan red ni API key."""
import json
import os
import sys
import tempfile
import threading
import unittest
from http.server import BaseHTTPRequestHandler, HTTPServer

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
sys.path.insert(0, ROOT)

from oasis.fn import check_suggestion, run_fn    # noqa: E402
from oasis.fp import check_assertion, run_fp, run_tests    # noqa: E402
from oasis.javarun import load_spec, replace_method, split_top_level, validate_tests    # noqa: E402
from oasis.llm import CachedLLM, LLMError, OpenAICompatLLM, ReplayLLM, ask_json, extract_json    # noqa: E402
from oasis.mutate import operator_mutants        # noqa: E402

SLIDE = os.path.join(ROOT, "cases", "slide_left", "spec.json")
SCORE = os.path.join(ROOT, "cases", "score_cap", "spec.json")

# Aserciones que sugirió un modelo real en una corrida y que NO compilan (regresión de un defecto de la herramienta)
LAMBDA_SHADOWS_PARAM = ("Arrays.equals(result, ((java.util.function.Function<int[], int[]>) row -> row).apply(old_row))")
UNKNOWN_HELPER = "Arrays.equals(Subject.correctMergedNonZero(old_row), result)"


class TestUtils(unittest.TestCase):
    def test_extract_json(self):
        self.assertEqual(extract_json('```json\n{"a": [1, 2]}\n```'), {"a": [1, 2]})
        self.assertEqual(extract_json('Claro: {"x": 1} fin'), {"x": 1})
        with self.assertRaises(ValueError):
            extract_json("sin json")

    def test_split_params(self):
        self.assertEqual(split_top_level("Map<String, Integer> m, int[] a"), ["Map<String, Integer> m", "int[] a"])

    def test_spec_and_method_span(self):
        spec = load_spec(SLIDE)
        self.assertEqual(spec.ret, "int[]")
        self.assertEqual(spec.params, [("int[]", "row")])
        text = spec.method_text
        self.assertTrue(text.startswith("static int[] slideLeft") and text.rstrip().endswith("}"))
        new = replace_method(spec.source, "slideLeft", "static int[] slideLeft(int[] row) { return row; }")
        self.assertIn("return row; }", new)
        self.assertIn("static boolean compacted", new)    # lo demás queda intacto

    def test_helpers_are_listed(self):
        spec = load_spec(SLIDE)
        self.assertIn("Subject.compacted(int[] r) -> boolean", spec.helpers)
        self.assertFalse([h for h in spec.helpers if "slideLeft" in h])

    def test_operator_mutants_differ(self):
        spec = load_spec(SLIDE)
        ms = operator_mutants(spec.source, "slideLeft", 30)
        self.assertGreater(len(ms), 10)
        self.assertEqual(len({m["code"] for m in ms}), len(ms))
        self.assertNotIn(spec.method_text, [m["code"] for m in ms])

    def test_replay_and_cache(self):
        with tempfile.TemporaryDirectory() as d:
            p = os.path.join(d, "s.json")
            with open(p, "w") as f:
                json.dump({"t": ['{"a": 1}', {"a": 2}]}, f)
            llm = CachedLLM(ReplayLLM(p), os.path.join(d, "c"))
            self.assertEqual(ask_json(llm, "t", "s", "u1"), {"a": 1})
            self.assertEqual(ask_json(llm, "t", "s", "u2"), {"a": 2})
            self.assertEqual(ask_json(llm, "t", "s", "u1"), {"a": 1})      # desde la caché
            with self.assertRaises(LLMError):
                ReplayLLM(p).chat("otra", "s", "u")


class TestHttpClient(unittest.TestCase):
    """El cliente real contra un servidor local que imita /chat/completions (no hay llamada a un LLM)."""

    def test_chat_completions_request_and_response(self):
        seen = {}

        class H(BaseHTTPRequestHandler):
            calls = 0

            def do_POST(self):
                H.calls += 1
                body = json.loads(self.rfile.read(int(self.headers["Content-Length"])))
                seen.update(path=self.path, auth=self.headers["Authorization"], body=body)
                if H.calls == 1:                      # primer intento: error transitorio, debe reintentar
                    self.send_response(503)
                    self.end_headers()
                    return
                out = json.dumps({"choices": [{"message": {"content": '{"ok": true}'}}]}).encode()
                self.send_response(200)
                self.send_header("Content-Length", str(len(out)))
                self.end_headers()
                self.wfile.write(out)

            def log_message(self, *a):
                pass

        srv = HTTPServer(("127.0.0.1", 0), H)
        threading.Thread(target=srv.serve_forever, daemon=True).start()
        os.environ["no_proxy"] = os.environ["NO_PROXY"] = "127.0.0.1"
        llm = OpenAICompatLLM("openrouter", model="m/x", api_key="k123", base_url=f"http://127.0.0.1:{srv.server_port}/v1")
        self.assertEqual(ask_json(llm, "t", "sys", "user"), {"ok": True})
        srv.shutdown()
        srv.server_close()
        self.assertEqual(seen["path"], "/v1/chat/completions")
        self.assertEqual(seen["auth"], "Bearer k123")
        self.assertEqual(seen["body"]["model"], "m/x")
        self.assertEqual([m["role"] for m in seen["body"]["messages"]], ["system", "user"])

    def test_missing_key(self):
        os.environ.pop("NVIDIA_API_KEY", None)
        with self.assertRaises(LLMError):
            OpenAICompatLLM("nvidia")


class TestJava(unittest.TestCase):
    def test_runner_statuses(self):
        spec = load_spec(SLIDE)
        rows = run_tests(spec, [["new int[]{2, 2, 0, 4}"], ["new int[]{3, 3}"], ["null"]])
        self.assertEqual(rows[0]["status"], "PASS")
        self.assertEqual(rows[0]["result"], "[4, 4, 0, 0]")
        self.assertEqual(rows[1]["status"], "SKIP")        # precondición no se cumple
        self.assertEqual(rows[2]["status"], "SKIP")
        rows = run_tests(spec, [["new int[]{2, 2}"]], assertion="result[0] == 99")
        self.assertEqual(rows[0]["status"], "FAIL")
        self.assertEqual(rows[0]["post"], "[2, 2]")

    def test_invalid_test_args_are_rejected_not_fatal(self):
        spec = load_spec(SCORE)
        ok, bad = validate_tests(spec, [["new int[]{2, 2}"], ["esto no compila"], ["new int[]{4, 4}"]])
        self.assertEqual(len(ok), 2)
        self.assertEqual(bad, [["esto no compila"]])

    def test_all_test_args_invalid_is_not_an_assertion_error(self):
        spec = load_spec(SCORE)
        ok, bad = validate_tests(spec, [["basura 1"], ["basura 2"], ["basura 3"]])
        self.assertEqual((ok, len(bad)), ([], 3))

    def test_uncompilable_assertion_is_an_error_not_silent(self):
        """Regresión: una aserción que no compila rompe TODAS las pruebas; antes se descartaban todas en silencio
        y la comprobación informaba 'se cumple' y 'ninguno muere'."""
        spec = load_spec(SLIDE)
        for bad in (LAMBDA_SHADOWS_PARAM, UNKNOWN_HELPER):
            with self.assertRaises(RuntimeError) as cm:
                validate_tests(spec, [["new int[]{2, 2}"], ["new int[]{4}"]], bad)
            self.assertIn("no compilan", str(cm.exception))
            c = check_assertion(spec, bad, [{"args": ["new int[]{2, 2}"]}, {"args": ["new int[]{4}"]}])
            self.assertFalse(c["compiles"])
            c = check_suggestion(spec, bad, [["new int[]{2, 2}"], ["new int[]{4}"]], [])
            self.assertFalse(c["compiles"])


class TestPipelines(unittest.TestCase):
    def test_fp_finds_violations(self):
        spec = load_spec(SCORE)
        log = run_fp(spec, ReplayLLM(os.path.join(ROOT, "fixtures", "score_cap.replay.json")))
        results = {tuple(v["args"]): v["result"] for v in log["violations"]}
        self.assertEqual(results[("new int[]{2048, 2048}",)], "4096")
        self.assertEqual(len(log["rounds"]), 2)                 # la ronda 1 no violó, la 2 sí
        self.assertEqual(log["suggestion_check"]["violated_on"], [])

    def test_fp_refined_assertion_has_no_violations(self):
        spec = load_spec(SCORE)
        log = run_fp(spec, ReplayLLM(os.path.join(ROOT, "fixtures", "score_cap.replay.json")),
                     assertion="result % 4 == 0 && result >= 0", rounds=2)
        self.assertEqual(log["violations"], [])

    def test_fn_weak_vs_strong(self):
        spec = load_spec(SLIDE)
        script = os.path.join(ROOT, "fixtures", "slide_left.replay.json")
        weak = run_fn(spec, ReplayLLM(script), use_operators=False)
        cls = {m["id"]: m["cls"] for m in weak["mutants"]}
        self.assertEqual(sum(c == "killed" for c in cls.values()), 0)
        self.assertEqual(cls["M5"], "survived")                 # `return row` pasa result.length == row.length
        self.assertEqual(cls["M6"], "equivalent_so_far")        # equivalente bajo la precondición
        self.assertTrue(weak["suggestion_check"]["compiles"])
        self.assertEqual(weak["suggestion_check"]["violated_by_original_on"], [])
        strong = ("result.length == row.length && Arrays.stream(result).sum() == Arrays.stream(old_row).sum() "
                  "&& Subject.compacted(result) && (Subject.nonzero(result) < Subject.nonzero(old_row) "
                  "|| !Subject.hasMergeablePair(old_row))")
        better = run_fn(spec, ReplayLLM(script), assertion=strong, use_operators=False)
        cls2 = {m["id"]: m["cls"] for m in better["mutants"]}
        self.assertEqual(cls2["M1"], "killed")
        self.assertFalse([k for k, v in cls2.items() if v == "survived"])


if __name__ == "__main__":
    unittest.main(verbosity=2)
