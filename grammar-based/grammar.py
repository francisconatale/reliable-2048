CELL_VALUES = [0] + [2 ** i for i in range(1, 12)]

GRAMMAR = {
    "<input>": ["<size> <board(size)>"],

    "<size>": {
        "generator": "integer",
        "min": 1,
        "max": 5000
    },

    "<cell>": [str(value) for value in CELL_VALUES],

    "<board(size)>": {
        "generator": "repeat",
        "element": "<cell>",
        "count": "size * size"
    }
}

START_SYMBOL = "<input>"