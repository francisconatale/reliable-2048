import random

def delete():
    print("delete mutation was applied")

def modify():
    print("modify mutation was applied")

def add():
    print("add mutation was applied")

def none():
    print("none mutation was applied")

mutations = [ none, delete, modify, add ]

class Mutator:
    def mutate(self, size, board):
        count_mutations_to_apply = random.randint(0,3)
        for i in range(count_mutations_to_apply):
            mutations[i]()
        
