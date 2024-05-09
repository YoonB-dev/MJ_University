class Node():
  def __init__(self):
    self.data = None
    self.left = None
    self.right = None

def Myinsert(pos,amount):
  n = Node()
  curr = head
  for i in range(0,pos-1):
    curr = curr.right

  n.right = curr.right
  n.left = curr
  curr.right = n

def Mydelete(pos,head):
  curr = head
  for i in range(0,pos-1):
    curr = curr.right

  curr.right = curr.right.right
  curr.right.left = curr

def Myserch(amount,head):
  i=0
  curr = head
  while curr!=None:
    if curr.data == amount:
      return i
    i+=1
    curr = curr.right

def Myreverse(head):
  curr = head
  prev = None
  while curr!=None:
    next = curr.right
    curr.right = prev
    prve = curr
    curr = next

  return prev

#-----------Main
n0 = Node()
n0.data = "에스파"

n1 = Node()
n1.data = "아이브"

n2 = Node()
n2.data = "뉴진스"

n3 = Node()
n3.data = "잇지"

n0.right = n1
n1.right = n2
n2.right = n3

n1.left = n0
n2.left = n1
n3.left = n2

head = n0
tail = n3

curr = head
curr = Myreverse(head)

while curr!=None:
  print(curr.data)
  curr = curr.right

#Mydelete(2,head)

#curr = tail
#while curr!=None:
#  print(curr.data)
#  curr = curr.left

#Myserch("잇지",head)