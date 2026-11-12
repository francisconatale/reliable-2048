import pytest

from generator import GrammarGenerator
from grammar import CELL_VALUES, GRAMMAR, START_SYMBOL


def test_grammar_generator_produces_valid_structure():
    generator = GrammarGenerator(GRAMMAR)
    output = generator.generate(START_SYMBOL)

    parts = output.split(" ", 1)
    assert len(parts) == 2, f"Expected '<size> <cells>', got: {output}"

    size_str, board_str = parts
    size = int(size_str)
    assert 1 <= size <= GRAMMAR["<size>"]["max"]

    cells = board_str.split(",")
    assert len(cells) == size * size

    allowed = {str(v) for v in CELL_VALUES}
    for cell in cells:
        assert cell in allowed


def test_grammar_generator_custom_deterministic_rules():
    grammar = {
        "<start>": ["<size> <repeated>"],
        "<size>": {
            "generator": "integer",
            "min": 2,
            "max": 2,
        },
        "<repeated>": {
            "generator": "repeat",
            "element": "<val>",
            "count": "size * size",
        },
        "<val>": ["42"],
    }
    generator = GrammarGenerator(grammar)
    output = generator.generate("<start>")
    assert output == "2 42,42,42,42"


def test_grammar_generator_unknown_rule_raises():
    grammar = {
        "<start>": {
            "generator": "unsupported",
        }
    }
    generator = GrammarGenerator(grammar)
    with pytest.raises(ValueError, match="Unknown generator: unsupported"):
        generator.generate("<start>")
