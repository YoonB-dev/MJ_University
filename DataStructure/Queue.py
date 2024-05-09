class Node():
  def __init__(self,data):
    self.data = data
    self.right = None
    self.left = None

FULL = int(input("Queue size: "))
size = 0
front = None #앞쪽
rear = None #뒤쪽

def isEmpty():
  global front
  return front == None

def isFull():
  global size,FULL
  return size>=FULL

def enqueueFront(data):
  global size,front,rear
  if isFull():
    print("Queue is full")
    return
  n = Node(data)
  size+=1
  if(rear == None):
    front = rear = n
  else:
    front.left = n
    n.right = front
    front = n

def enqueueRear(data):
  global size,front,rear
  if isFull():
    print("Queue is full")
    return
  n = Node(data)
  size+=1
  if(rear==None):
    front = rear = n
  else:
    rear.right = n
    n.left = rear
    rear = n

def dequeueFront():
  global size,front,rear
  if(isEmpty()):
    print("Queue is empty")
    return
  size-=1
  if(front.right!=None):
    front.right.left = None
  front = front.right

def dequeueRear():
  global size,front,rear
  if(isEmpty()):
    print("Queue is empty")
    return
  size-=1
  if(rear.left!=None):
    rear.left.right = None
  rear = rear.left
  if(rear==None):
    front = None

def printQueue():
  global size,front,rear
  current = front
  while current!=None:
    print(current.data)
    current = current.right

class CircularQueue:
    def __init__(self, size):
        self.queue = [None] * size
        self.size = size
        self.front = self.rear = -1

    def isFull(self):
        return (self.rear + 1) % self.size == self.front

    def isEmpty(self):
        return self.front == -1

    def enqueue(self, data):
        if self.isFull():
            print("Queue is full")
            return
        elif self.isEmpty():
            self.front = self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.size
        self.queue[self.rear] = data

    def dequeue(self):
        if self.isEmpty():
            print("Queue is empty")
            return
        result = self.queue[self.front]
        if self.front == self.rear: # Queue has only one element
            self.front = self.rear = -1
        else:
            self.front = (self.front + 1) % self.size
        return result

    def printQueue(self):
        if self.isEmpty():
            print("Queue is empty")
        else:
            index = self.front
            while index != self.rear:
                print(self.queue[index], end=" ")
                index = (index + 1) % self.size
            print(self.queue[index])  # Print the last element

class Stack:
    def __init__(self):
        self.stack = []

    def isEmpty(self):
        return len(self.stack) == 0

    def push(self, data):
        self.stack.append(data)

    def pop(self):
        if not self.isEmpty():
            return self.stack.pop()
        return "Stack is empty"

# 변수와 큐, 스택 초기화
p = 5
count = 0  # 가정에 따라 'U' 대신 0으로 초기화
queue = CircularQueue(7)
stack = Stack()

# 큐에 데이터 삽입
for i in range(1, 13, 2):
    queue.enqueue(i)

# 큐의 크기를 얻기 위한 임시 큐
temp_queue = CircularQueue(7)

while not queue.isEmpty():
    e = queue.dequeue()
    if e < p:
        temp_queue.enqueue(e)
    else:
        count += 1
        stack.push(count)
        stack.push(e)

while not temp_queue.isEmpty():
    queue.enqueue(temp_queue.dequeue())

while not stack.isEmpty():
    queue.enqueue(stack.pop())

queue.printQueue()

