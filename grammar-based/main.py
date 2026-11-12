import subprocess
import sys
import time
from pathlib import Path

from generator import GrammarGenerator
from mutator import Mutator
from grammar import GRAMMAR, START_SYMBOL
from reporter import ExecutionReporter, ExecutionResult

CLASSES = Path(__file__).resolve().parent.parent / "target" / "classes"
DEFAULT_TIMEOUT: float = 10.0


def run_java(
    size: str, board: str, timeout: float = DEFAULT_TIMEOUT
) -> subprocess.CompletedProcess:
    return subprocess.run(
        [
            "java",
            "-cp",
            str(CLASSES),
            "ar.edu.unrc.game2048.MainCLI",
            "--stdin",
        ],
        input=f"{size}\n{board}\nq\n",
        text=True,
        capture_output=True,
        check=False,
        timeout=timeout,
    )


def main(
    n: int, verbose: bool = True, timeout: float = DEFAULT_TIMEOUT
) -> ExecutionReporter:
    generator = GrammarGenerator(GRAMMAR)
    reporter = ExecutionReporter()
    mutator = Mutator()
    for i in range(1, n + 1):
        generated = generator.generate(START_SYMBOL)
        size, board = generated.split(" ", 1)
        mutator.mutate(size, board)
        start_time = time.perf_counter()
        try:
            proc = run_java(size, board, timeout=timeout)
            duration = time.perf_counter() - start_time
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
                    duration=duration,
                    timed_out=False,
                )
            )
            status_label = (
                "SUCCESS" if is_success else f"FAILED (exit {proc.returncode})"
            )
        except subprocess.TimeoutExpired as exc:
            duration = time.perf_counter() - start_time
            stdout_str = (
                exc.stdout
                if isinstance(exc.stdout, str)
                else (
                    exc.stdout.decode(errors="replace")
                    if isinstance(exc.stdout, bytes)
                    else ""
                )
            )
            stderr_str = (
                exc.stderr
                if isinstance(exc.stderr, str)
                else (
                    exc.stderr.decode(errors="replace")
                    if isinstance(exc.stderr, bytes)
                    else ""
                )
            )
            reporter.record(
                ExecutionResult(
                    index=i,
                    size=size,
                    board=board,
                    success=False,
                    returncode=-1,
                    stdout=stdout_str,
                    stderr=stderr_str,
                    error_message=f"Timeout expired after {timeout} seconds",
                    duration=duration,
                    timed_out=True,
                )
            )
            status_label = f"TIMED OUT (> {timeout}s)"
        except (subprocess.SubprocessError, OSError) as exc:
            duration = time.perf_counter() - start_time
            reporter.record(
                ExecutionResult(
                    index=i,
                    size=size,
                    board=board,
                    success=False,
                    returncode=-1,
                    error_message=str(exc),
                    duration=duration,
                    timed_out=False,
                )
            )
            status_label = f"FAILED ({exc})"

        if verbose:
            print(
                f"[{i}/{n}] Size: {size} -> {status_label} ({duration:.4f}s)",
                flush=True,
            )

    if verbose and reporter.total > 0:
        fastest = reporter.fastest_run
        slowest = reporter.slowest_run
        fastest_msg = (
            f"Run #{fastest.index} ({fastest.duration:.4f}s)" if fastest else "N/A"
        )
        slowest_msg = (
            f"Run #{slowest.index} ({slowest.duration:.4f}s)" if slowest else "N/A"
        )
        print(
            f"\n[Stats] Fastest run: {fastest_msg} | Slowest non-timeout run: {slowest_msg}",
            flush=True,
        )

    return reporter


if __name__ == "__main__":
    n = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    timeout = float(sys.argv[2]) if len(sys.argv) > 2 else DEFAULT_TIMEOUT
    reporter = main(n, timeout=timeout)
    print()
    print(reporter.dump_report())
