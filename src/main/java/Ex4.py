import numpy as np


def write_files():
    with open("../resources/ex4/input4") as f:
        newFile = ""
        counter = 0
        for line in f:
            if line != "\n":
                newFile += line
                continue
            counter += 1
            with open(f"../resources/ex4/mat{counter}", "w") as mat_file:
                mat_file.write(newFile)
            newFile = ""


def get_matrices():
    res = []
    for i in range(1, 101):
        res.append(np.loadtxt(f"../resources/ex4/mat{i}"))

    return res


def get_numbers():
    with open("../resources/ex4/numbers") as f:
        for l in f:
            return [int(n) for n in l.split(",")]


matrices = get_matrices()
print(get_numbers())
