import random
import re


class GrammarGenerator:

    def __init__(self, grammar):
        self.grammar = grammar
        self.context = {}

    def generate(self, symbol):
        self.context = {}
        return self.expand(symbol)

    def expand(self, symbol):
        rule = self.grammar[symbol]

        if isinstance(rule, list):
            production = random.choice(rule)
            return self.expand_production(production)

        if rule["generator"] == "integer":
            value = random.randint(rule["min"], rule["max"])

            if symbol == "<size>":
                self.context["size"] = value

            return str(value)

        if rule["generator"] == "repeat":
            count = self.context["size"] ** 2

            return ",".join(
                self.expand(rule["element"])
                for _ in range(count)
            )

        raise ValueError(f"Unknown generator: {rule['generator']}")

    def expand_production(self, production):
        pattern = r"<[^<>]+>"

        return re.sub(
            pattern,
            lambda match: self.expand(match.group()),
            production
        )