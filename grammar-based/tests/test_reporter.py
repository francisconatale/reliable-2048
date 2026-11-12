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
