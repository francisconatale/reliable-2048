import subprocess
from unittest.mock import MagicMock

import main as main_module
from reporter import ExecutionReporter, ExecutionResult


def test_reporter_empty():
    reporter = ExecutionReporter()
    assert reporter.total == 0
    assert len(reporter.successes) == 0
    assert len(reporter.failures) == 0
    assert "Total runs: 0" in reporter.summary()
    assert reporter.dump_errors() == "No errors recorded."


def test_reporter_records_success_and_failure():
    reporter = ExecutionReporter()
    reporter.record(
        ExecutionResult(
            index=1,
            size="2",
            board="0,2,2,0",
            success=True,
            returncode=0,
            stdout="OK",
        )
    )
    reporter.record(
        ExecutionResult(
            index=2,
            size="2",
            board="invalid",
            success=False,
            returncode=1,
            stderr="NumberFormatException",
        )
    )

    assert reporter.total == 2
    assert len(reporter.successes) == 1
    assert len(reporter.failures) == 1

    summary = reporter.summary()
    assert "Total runs: 2" in summary
    assert "Successes: 1" in summary
    assert "Failures:  1" in summary

    errors = reporter.dump_errors()
    assert "Run #2" in errors
    assert "Exit code: 1" in errors
    assert "NumberFormatException" in errors

    report = reporter.dump_report()
    assert "=== Execution Summary ===" in report
    assert "=== Error Log Dump ===" in report


def test_main_with_mocked_subprocess(monkeypatch):
    mock_run = MagicMock()
    mock_run.side_effect = [
        subprocess.CompletedProcess(args=[], returncode=0, stdout="OK", stderr=""),
        subprocess.CompletedProcess(args=[], returncode=1, stdout="", stderr="Error on board"),
    ]
    monkeypatch.setattr(main_module, "run_java", mock_run)

    reporter = main_module.main(2, verbose=False)
    assert reporter.total == 2
    assert len(reporter.successes) == 1
    assert len(reporter.failures) == 1
    assert reporter.failures[0].index == 2
    assert "Error on board" in reporter.dump_errors()


def test_run_java_passes_via_stdin(monkeypatch):
    captured_args = {}

    def mock_subprocess_run(cmd, **kwargs):
        captured_args["cmd"] = cmd
        captured_args["kwargs"] = kwargs
        return subprocess.CompletedProcess(args=cmd, returncode=0, stdout="OK", stderr="")

    monkeypatch.setattr(subprocess, "run", mock_subprocess_run)

    res = main_module.run_java("4", "0,2,0,2")
    assert res.returncode == 0
    assert captured_args["cmd"][-1] == "--stdin"
    assert captured_args["kwargs"]["input"] == "4\n0,2,0,2\nq\n"
    assert captured_args["kwargs"]["text"] is True
    assert captured_args["kwargs"]["timeout"] == 10.0


def test_run_java_custom_timeout(monkeypatch):
    captured_args = {}

    def mock_subprocess_run(cmd, **kwargs):
        captured_args["kwargs"] = kwargs
        return subprocess.CompletedProcess(args=cmd, returncode=0, stdout="OK", stderr="")

    monkeypatch.setattr(subprocess, "run", mock_subprocess_run)

    main_module.run_java("4", "0,2,0,2", timeout=5.0)
    assert captured_args["kwargs"]["timeout"] == 5.0


def test_reporter_metrics_fastest_slowest_and_timeouts():
    reporter = ExecutionReporter()
    r1 = ExecutionResult(
        index=1,
        size="2",
        board="0,2,0,2",
        success=True,
        returncode=0,
        duration=0.5,
    )
    r2 = ExecutionResult(
        index=2,
        size="3",
        board="0,0,0,0,2,0,0,0,2",
        success=True,
        returncode=0,
        duration=0.1,
    )
    r3 = ExecutionResult(
        index=3,
        size="4",
        board="error_board",
        success=False,
        returncode=1,
        duration=2.5,
        stderr="Board parse error",
    )
    r4 = ExecutionResult(
        index=4,
        size="100",
        board="huge_board",
        success=False,
        returncode=-1,
        duration=10.01,
        timed_out=True,
        error_message="Timeout expired after 10.0 seconds",
    )

    for r in (r1, r2, r3, r4):
        reporter.record(r)

    assert reporter.total == 4
    assert len(reporter.successes) == 2
    assert len(reporter.failures) == 2
    assert len(reporter.timeouts) == 1
    assert reporter.timeouts[0].index == 4

    # Fastest run overall / non-timeout is r2 (0.1s)
    assert reporter.fastest_run == r2
    assert reporter.fastest_run.index == 2

    # Slowest non-timeout run is r3 (2.5s), NOT r4 (10.01s timed out)
    assert reporter.slowest_run == r3
    assert reporter.slowest_run.index == 3

    summary = reporter.summary()
    assert "Timeouts:  1" in summary
    assert "Fastest run: 0.1000s (Run #2)" in summary
    assert "Slowest (non-timeout) run: 2.5000s (Run #3)" in summary

    errors = reporter.dump_errors()
    assert "Timed out: Yes (10.01s)" in errors


def test_reporter_all_runs_timed_out():
    reporter = ExecutionReporter()
    r1 = ExecutionResult(
        index=1,
        size="100",
        board="b1",
        success=False,
        returncode=-1,
        duration=10.05,
        timed_out=True,
    )
    reporter.record(r1)

    assert len(reporter.timeouts) == 1
    assert reporter.slowest_run is None
    summary = reporter.summary()
    assert "Slowest (non-timeout) run: N/A" in summary


def test_main_handles_timeout_expired(monkeypatch):
    mock_run = MagicMock()
    mock_run.side_effect = subprocess.TimeoutExpired(
        cmd=["java"], timeout=10.0, output="partial stdout", stderr="partial stderr"
    )
    monkeypatch.setattr(main_module, "run_java", mock_run)

    reporter = main_module.main(1, verbose=False)
    assert reporter.total == 1
    assert len(reporter.failures) == 1
    assert len(reporter.timeouts) == 1
    failure = reporter.failures[0]
    assert failure.timed_out is True
    assert failure.returncode == -1
    assert "Timeout expired after 10.0 seconds" in failure.error_message
    assert failure.stdout == "partial stdout"
    assert failure.stderr == "partial stderr"
