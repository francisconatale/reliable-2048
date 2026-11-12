import sys

from generator import GrammarGenerator
from grammar import GRAMMAR, START_SYMBOL


def main(n):
    generator = GrammarGenerator(GRAMMAR)

    for i in range(n):
        result = generator.generate(START_SYMBOL)
        print(result)


if __name__ == "__main__":
    n = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    main(n)