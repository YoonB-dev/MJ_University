#heap
class MyHeap:   
    def __init__(self):
        self.heap = []
        self.heap.append(None)
    
    def myInsert(self,data):
        self.heap.append(data)
    
    def compareWithParent(self,i):
        while i//2 > 0:
            if self.heap[i] > self.heap[i//2]:
                self.heap[i], self.heap[i//2] = self.heap[i//2], self.heap[i]
            i = i//2


heap = MyHeap()
heap.myInsert(10)