# BST

class treeNode:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

def searchTree(data):
    global root
    current = root
    if current == None:
        print("not found")
        return True
    
    while True:
        if data == current.data:
            print("find"+str(data))
            return True
        else:
            if data < current.data:
                if current.left == None:
                    print("not found")
                    return False
                current = current.left
            else:
                if current.right == None:
                    print("not found")
                    return False
                current = current.right

def insertTree(data):
    global root
    
    if searchTree(data):
        print("Already exist " + str(data))
        return
    
    n = treeNode(data)
    if root == None:
        root = n
        return
    
    current = root
    
    while True:
        if data< current.data:
            if current.left == None:
                current.left = n
                break
            current = current.left
        else:
            if current.right == None:
                current.right = n
                break
            current = current.right

def inorder(n):
    if n == None:
        return
    inorder(n.left)
    print(n.data)
    inorder(n.right)

n1 = treeNode(15)
n2 = treeNode(11)
n3 = treeNode(70)
n4 = treeNode(5)
n1.left = n2
n1.right = n3
n2.left = n4
root = n1

insertTree(13)

inorder(root)

#searchTree(60)
