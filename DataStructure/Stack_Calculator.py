#=========계산기===========
def calculate_postfix(expression):
  stack = []
  for token in expression.split():
    if token.isdigit(): #피연산자일 경우
      stack.append(int(token))
    else: #연산자일 경우
      b = stack.pop()
      a = stack.pop()
      if token == '+':
        stack.append(a+b)
      elif token =='-':
        stack.append(a-b)
      elif token =='*':
        stack.append(a*b)
      elif token=='/':
        stack.append(a/b)
  return stack.pop()
#=======================
def InToPost(e):
  precedence = {'+':1,'-':1,'*':2,'/':2,'(':0}
  stack = []
  postfix = []
  tokens = e.split()

  for token in tokens:
    if token.isalnum():
      postfix.append(token)
    elif token == '(':
      stack.append(token)
    elif token ==')':
      top_token = stack.pop()
      while top_token!='(':
        postfix.append(top_token)
        top_token = stack.pop()
    else:
      while (stack) and (precedence[stack[-1]] >= precedence[token]):
        # 스택이 비어있지 않고, 현재 연산자의 우선순위가 스택의 맨 위 연산자 우선순위보다 낮거나 같은 경우
        postfix.append(stack.pop())  # 스택에서 pop하여 결과 리스트에 추가
      stack.append(token)  # 현재 연산자를 스택에 추가

  while stack:  # 스택에 남아있는 모든 연산자를 결과 리스트에 추가
    postfix.append(stack.pop())
  return ' '.join(postfix)


infix = input("infix:")
print("postfix : ", InToPost(infix))
print(f"계산결과: {calculate_postfix(InToPost(infix))}")