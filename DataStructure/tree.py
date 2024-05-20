class treeNode:
  def __init__(self,data):
    self.data = data
    self.left = None
    self.right = None

def inorder(n):
    if n == None:
      return
    inorder(n.left)
    print(n.data)
    inorder(n.right)

def postorder(n):
  if n==None:
    return
  postorder(n.left)
  postorder(n.right)
  print(n.data)

def preorder(n):
  if n==None:
    return
  print(n.data)
  preorder(n.left)
  preorder(n.right)

n1 = treeNode(1)
n2 = treeNode(2)
n3 = treeNode(3)
n4 = treeNode(4)
n5 = treeNode(5)
n6 = treeNode(6)
n7 = treeNode(7)
n8 = treeNode(8)

n1.left = n2
n1.right = n3

n2.left = n4

n3.left = n5
n3.right = n6

n5.left = n7
n5.right = n8

#inorder(n1)
postorder(n1)
#preorder(n1)