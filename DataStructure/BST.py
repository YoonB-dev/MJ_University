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


def deleteTree(data):
    global root
    if searchTree(data)==False:
        print("No exist" + str(data))
        return
    parent = None
    current = root
    while True:
        if current.data == data:
            if current.left == None and current.right == None:
                if parent.left == current:
                    parent.left = None
                else:
                    parent.right = None
                del(current)
            else:
                if current.left!=None and current.right==None:
                    if parent.left == current:
                        parent.left = current.left
                    else:
                        parent.right = current.left
                    del(current)
                else:
                    if current.left ==None and current.right!=None:
                        if parent.left == current:
                            parent.left = current.right
                        else:
                            parent.right = current.right
                        del(current)
            break
        else:
            parent = current
            if current.data > data:
                current = current.left
            else :
                current= current.right
                


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
deleteTree(70)
inorder(root)

#searchTree(60)
