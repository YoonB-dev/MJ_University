#Heap
from queue import PriorityQueue

class Heap:
    def __init__(self):
        self.heap = []
        self.heap.append(None)


Q1 = PriorityQueue()

Q1.put(10)
Q1.put(1)
Q1.put(5)
Q1.put(3)

Q2 = PriorityQueue()
Q2.put((5,'Lee'))
Q2.put((10,'Yoon'))

print(Q1.get())
print(Q1.get())
print(Q1.get())
print(Q2.get())
print(Q2.get()[1])

