complete_node = 15

tree = [None,'D','A','F','E','B','R','T','G','Q',None,None,'V',None,'J','L']

def get_right_child(n):
  if tree[n] != None and ((n * 2) + 1) <= complete_node:
    return (2 * n) + 1
  return 0

def get_left_child(n):
  if tree[n] != None and ((n * 2) <= complete_node):
    return 2 * n
  return 0

def preorder(n):
  if n > 0 and tree[n] != None:
    print(tree[n])
    preorder(get_left_child(n))
    preorder(get_right_child(n))

preorder(1)