from dataclasses import dataclass


@dataclass
class ExecutionResult:
    index: int
    size: str
    board: str
    success: bool
    returncode: int
    stdout: str = ""
    stderr: str = ""
    error_message: str | None = None
    duration: float = 0.0
    timed_out: bool = False


class ExecutionReporter:
    def __init__(self) -> None:
        self.results: list[ExecutionResult] = []

    def record(self, result: ExecutionResult) -> None:
        self.results.append(result)

    @property
    def total(self) -> int:
        return len(self.results)

    @property
    def successes(self) -> list[ExecutionResult]:
        return [r for r in self.results if r.success]

    @property
    def failures(self) -> list[ExecutionResult]:
        return [r for r in self.results if not r.success]

    @property
    def timeouts(self) -> list[ExecutionResult]:
        return [r for r in self.results if r.timed_out]

    @property
    def non_timeout_runs(self) -> list[ExecutionResult]:
        return [r for r in self.results if not r.timed_out]

    @property
    def fastest_run(self) -> ExecutionResult | None:
        runs = self.non_timeout_runs or self.results
        if not runs:
            return None
        return min(runs, key=lambda r: r.duration)

    @property
    def slowest_run(self) -> ExecutionResult | None:
        runs = self.non_timeout_runs
        if not runs:
            return None
        return max(runs, key=lambda r: r.duration)

    @property
    def slowest_non_timeout_run(self) -> ExecutionResult | None:
        return self.slowest_run

    def summary(self) -> str:
        fastest = self.fastest_run
        slowest = self.slowest_run

        fastest_str = (
            f"{fastest.duration:.4f}s (Run #{fastest.index})"
            if fastest is not None
            else "N/A"
        )
        slowest_str = (
            f"{slowest.duration:.4f}s (Run #{slowest.index})"
            if slowest is not None
            else "N/A"
        )

        return (
            "=== Execution Summary ===\n"
            f"Total runs: {self.total}\n"
            f"Successes: {len(self.successes)}\n"
            f"Failures:  {len(self.failures)}\n"
            f"Timeouts:  {len(self.timeouts)}\n"
            f"Fastest run: {fastest_str}\n"
            f"Slowest (non-timeout) run: {slowest_str}"
        )

    def dump_errors(self) -> str:
        if not self.failures:
            return "No errors recorded."

        lines = ["=== Error Log Dump ==="]
        for failure in self.failures:
            lines.append(f"--- Run #{failure.index} ---")
            lines.append(f"Size: {failure.size}")
            lines.append(f"Board: {failure.board}")
            lines.append(f"Exit code: {failure.returncode}")
            if failure.timed_out:
                lines.append(f"Timed out: Yes ({failure.duration:.2f}s)")
            elif failure.duration > 0:
                lines.append(f"Duration: {failure.duration:.4f}s")
            if failure.error_message:
                lines.append(f"Error: {failure.error_message}")
            if failure.stderr:
                lines.append(f"Stderr:\n{failure.stderr.strip()}")
            if failure.stdout:
                lines.append(f"Stdout:\n{failure.stdout.strip()}")
        return "\n".join(lines)

    def dump_report(self) -> str:
        report = [self.summary()]
        if self.failures:
            report.append("")
            report.append(self.dump_errors())
        return "\n".join(report)
