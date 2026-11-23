"""Prompts (en inglés: los modelos abiertos siguen mejor las instrucciones así)."""

SYSTEM = (
    "You are an expert Java engineer helping a developer refine a test oracle: an assertion (a Java boolean "
    "expression) that must hold after a static method runs. You never decide for the developer: you produce "
    "evidence (tests, mutants, explanations). Always answer with a single JSON object and no extra prose."
)

CONVENTIONS = """Conventions for assertions and tests:
- The assertion is a single Java boolean EXPRESSION (not a statement block). It can use the method parameters (their
  values AFTER the call), `result` (the returned value, absent for void methods) and `old_<param>` (a deep copy of each
  parameter taken BEFORE the call). Do not declare lambdas or variables whose names clash with the parameters.
- In assertions you may call ONLY the JDK and the static helper methods listed below; do not invent helper methods.
- The precondition is a Java boolean expression over the parameters; only inputs satisfying it are valid.
- A test is a list of Java expressions, one per parameter, in order, e.g. ["new int[]{2, 2, 0, 4}"] or ["5", "\\"abc\\""].
  Expressions must be self-contained and must compile in Java 11 (java.util.* is imported)."""


def header(spec, assertion):
    params = ", ".join(f"{t} {n}" for t, n in spec.params)
    desc = f"\nInformal description: {spec.description}" if spec.description else ""
    helpers = "\n".join(f"- {h}" for h in spec.helpers) or "- (none)"
    return (f"{CONVENTIONS}\n\nStatic helpers available in the class:\n{helpers}\n\n"
            f"Method under test (class {spec.class_name}):\n```java\n{spec.method_text}\n```\n"
            f"Signature: {spec.ret} {spec.method}({params}){desc}\n"
            f"Precondition: {spec.pre}\nAssertion under analysis: {assertion}\n")


def fp_tests(spec, assertion, n, attempts):
    prev = ""
    if attempts:
        rows = "\n".join(f"- args={a['args']} -> result={a['result']} (assertion held)" for a in attempts[-12:])
        prev = ("\nThese inputs were already tried and the assertion HELD, so do not repeat them; "
                f"look for different kinds of inputs:\n{rows}\n")
    return (header(spec, assertion) +
            f"\nTask: the assertion may be a FALSE POSITIVE (too strong: it fails for valid inputs although the "
            f"program behaves correctly). Reason about the code and propose up to {n} valid inputs (they satisfy the "
            f"precondition) that you believe make the assertion evaluate to false.{prev}\n"
            'Answer JSON: {"reasoning": "...", "tests": [{"args": ["<java expr>", ...], "why": "..."}]}')


def fp_explain(spec, assertion, cases):
    rows = "\n".join(f"- args={c['args']} -> result={c['result']}, state after call={c['post']}" for c in cases[:8])
    return (header(spec, assertion) +
            f"\nThe following valid inputs make the assertion FAIL when the program is executed:\n{rows}\n\n"
            "Task: explain to the developer why. Decide whether, for these inputs, the program's behavior looks "
            "correct (so the assertion is too strong) or looks like a bug in the program, or whether it is unclear. "
            "If the assertion looks too strong, suggest a weaker assertion that still rejects wrong behavior.\n"
            'Answer JSON: {"verdict": "assertion_too_strong|program_bug|unclear", "explanation": "...", '
            '"suggested_assertion": "<java boolean expression or empty string>"}')


def fn_mutants(spec, assertion, k):
    return (header(spec, assertion) +
            f"\nTask: the assertion may be a FALSE NEGATIVE (too weak: it also holds for wrong behavior). Write {k} "
            "mutants of the method: each one a subtle, plausible fault that makes the program behave incorrectly with "
            "respect to its intended behavior (avoid semantically equivalent mutants). Each mutant must be the COMPLETE "
            "replacement of the method, with exactly the same signature, and it may only use the class's existing members.\n"
            'Answer JSON: {"mutants": [{"description": "...", "code": "<complete method source>"}]}')


def fn_tests(spec, assertion, n):
    return (header(spec, assertion) +
            f"\nTask: propose {n} diverse valid inputs (satisfying the precondition) that exercise the method well: "
            "typical cases, boundaries, empty or minimal cases, repeated values, and inputs likely to reveal faults.\n"
            'Answer JSON: {"tests": [{"args": ["<java expr>", ...], "why": "..."}]}')


def fn_distinguish(spec, assertion, mutant, n):
    return (header(spec, assertion) +
            f"\nMutant (mutated version of the method):\n```java\n{mutant['code']}\n```\n"
            f"Description of the change: {mutant['description']}\n"
            f"Task: propose up to {n} valid inputs on which the mutant returns a different result (or leaves the "
            "parameters in a different state) than the original method.\n"
            'Answer JSON: {"tests": [{"args": ["<java expr>", ...], "why": "..."}]}')


def fn_assertion(spec, assertion, survivors):
    rows = []
    for s in survivors[:8]:
        w = s.get("witness")
        rows.append(f"- mutant: {s['description']}\n  distinguishing input args={w['args']} -> original result={w['orig_result']}, "
                    f"mutant result={w['mut_result']}" if w else f"- mutant: {s['description']} (no distinguishing input found yet)")
    return (header(spec, assertion) +
            "\nThese mutants SURVIVE: the assertion does not fail on them although their behavior differs from the original:\n"
            + "\n".join(rows) +
            "\n\nTask: help the developer strengthen the assertion. Propose a stronger assertion (a single Java boolean "
            "EXPRESSION using the conventions above, calling only the JDK and the listed helpers) that keeps holding for the "
            "ORIGINAL method on every valid input but fails on these mutants. Explain what each added condition captures. "
            "If a new helper would be needed, describe it in the explanation instead of using it in the assertion.\n"
            'Answer JSON: {"assertion": "<java boolean expression>", "explanation": "..."}')
