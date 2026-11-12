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

    def summary(self) -> str:
        return (
            "=== Execution Summary ===\n"
            f"Total runs: {self.total}\n"
            f"Successes: {len(self.successes)}\n"
            f"Failures:  {len(self.failures)}"
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
