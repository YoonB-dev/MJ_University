import random
#find
a = [1,3,5,7,9,11,13,15,17,19]

def find(d):
  for i in range(0,len(a)):
    if a[i]==d:
      print("find")
      return

  print("not found")

find(int(input("찾는 값: ")))

#binSearch
def binSearch(d):
  start = 0
  end = len(a)-1

  while(start<end):
    mid = (start+end)//2
    if a[mid]==d:
      print("find: ",mid)
      return
    else:
      if a[mid]>d:
        end = mid-1
      if a[mid]<=d:
        start = mid+1
  print("not found")

binSearch(int(input("찾는 값을 입력: ")))

#
def findEven(a):
  same=a[0]
  count=0
  max=0
  min=100
  for i in range(0,len(a)):
    if a[i]%2==0:
      print(a[i])
    if max<a[i]:
      max = a[i]
    if min>a[i]:
      min = a[i]
    if i>0 and a[i-1]==a[i]:
      count+=1
      same = a[i]

  print("최대값:",max,"\n최소값:",min,"\n최대값 - 최소값: ",max-min)
  if count!=0:
   print("\n연속적인 값:",same,"/n횟수:",count)
  else:
    print("\n연속적인 값 없음")

data_list = random.sample(range(100),10)
print(data_list)
findEven(data_list)