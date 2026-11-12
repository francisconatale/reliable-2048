from grammar import CELL_VALUES
from mutator import Mutator, add, delete, modify, none


def test_none_mutation():
    board = [2, 4, 8]
    result = none(3, board)
    assert result == [2, 4, 8]


def test_delete_mutation():
    board = [2, 4, 8, 16]
    result = delete(2, list(board))
    assert len(result) <= len(board)
    assert all(x in board for x in result)


def test_delete_empty_board():
    assert delete(4, []) == []


def test_modify_mutation():
    board = [0, 0, 0, 0]
    result = modify(2, list(board))
    assert len(result) == len(board)
    assert all(x in CELL_VALUES for x in result)


def test_add_mutation():
    board = [2, 4]
    result = add(2, list(board))
    assert len(result) >= len(board)
    assert all(x in CELL_VALUES for x in result)


def test_mutator_mutate_returns_list():
    mutator = Mutator()
    board = [2, 4, 8, 16]
    result = mutator.mutate(2, board)
    assert isinstance(result, list)
    # The original board should not be mutated in-place
    assert board == [2, 4, 8, 16]
