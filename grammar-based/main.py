import subprocess
import sys
from pathlib import Path

from generator import GrammarGenerator
from grammar import GRAMMAR, START_SYMBOL
from reporter import ExecutionReporter, ExecutionResult

CLASSES = Path(__file__).resolve().parent.parent / "target" / "classes"


def run_java(size: str, board: str) -> subprocess.CompletedProcess:
    return subprocess.run(
        [
            "java",
            "-cp",
            str(CLASSES),
            "ar.edu.unrc.game2048.MainCLI",
            size,
            board,
        ],
        input="q\n",
        text=True,
        capture_output=True,
        check=False,
    )


def main(n: int, verbose: bool = True) -> ExecutionReporter:
    generator = GrammarGenerator(GRAMMAR)
    reporter = ExecutionReporter()

    for i in range(1, n + 1):
        generated = generator.generate(START_SYMBOL)
        size, board = generated.split(" ", 1)

        try:
            proc = run_java(size, board)
            is_success = proc.returncode == 0
            reporter.record(
                ExecutionResult(
                    index=i,
                    size=size,
                    board=board,
                    success=is_success,
                    returncode=proc.returncode,
                    stdout=proc.stdout,
                    stderr=proc.stderr,
                )
            )
            status_label = "SUCCESS" if is_success else f"FAILED (exit {proc.returncode})"
        except (subprocess.SubprocessError, OSError) as exc:
            reporter.record(
                ExecutionResult(
                    index=i,
                    size=size,
                    board=board,
                    success=False,
                    returncode=-1,
                    error_message=str(exc),
                )
            )
            status_label = f"FAILED ({exc})"

        if verbose:
            print(f"[{i}/{n}] Size: {size} -> {status_label}", flush=True)

    return reporter


if __name__ == "__main__":
    n = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    reporter = main(n)
    print()
    print(reporter.dump_report())
