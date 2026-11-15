import random

from grammar import CELL_VALUES

MAX = 100


def delete(size: int, board: list[int]) -> list[int]:
    if not board:
        return board
    cells_to_delete = min(len(board), random.randint(0, min(size, MAX) if size > 0 else MAX))
    if cells_to_delete > 0:
        indices = sorted(random.sample(range(len(board)), cells_to_delete), reverse=True)
        for idx in indices:
            board.pop(idx)
    print(f"delete mutation was applied -> {cells_to_delete}")
    return board


def modify(size: int, board: list[int]) -> list[int]:
    if not board:
        return board
    cells_to_modify = min(len(board), random.randint(0, min(size, MAX) if size > 0 else MAX))
    if cells_to_modify > 0:
        indices = random.sample(range(len(board)), cells_to_modify)
        for idx in indices:
            board[idx] += random.randint(0,MAX)
    print(f"modify mutation was applied -> {cells_to_modify}")
    return board


def add(size: int, board: list[int]) -> list[int]:
    cells_to_add = random.randint(0, MAX)
    for _ in range(cells_to_add):
        idx = random.randint(0, len(board))
        board.insert(idx, random.choice(CELL_VALUES))
    print(f"add mutation was applied -> {cells_to_add}")
    return board


def none(size: int, board: list[int]) -> list[int]:
    print("none mutation was applied")
    return board


mutations = [none, delete, modify, add]


class Mutator:
    def mutate(self, size: int | str, board: list[int]) -> list[int]:
        mutated_board = list(board)
        count_mutations_to_apply = random.randint(0, 3)
        for _ in range(count_mutations_to_apply):
            mutation = random.choice(mutations)
            mutated_board = mutation(int(size), mutated_board)
        return mutated_board
