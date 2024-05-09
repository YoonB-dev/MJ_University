#BubbleSort-----------------
def BubbleSort(a):
  n = len(a)
  swapped = False
  for i in range(n-1):
    for j in range(0,n-1-i):
      if(a[j]>a[j+1]):
        a[j],a[j+1]=a[j+1],a[j]

n=[6,4,2,1,22,9,17]
BubbleSort(n)
print(n)

#SelectSort-----------------
def SelectSort(a):
  n = len(a)
  for i in range(n-1):
    min = i
    for j in range(i+1,n):
      if(a[j]<a[min]):
        min = j
    a[i],a[min] = a[min],a[i]

n=[99,34,55,7,82,21,9,10,3,46]
SelectSort(n)
print(n)

#InsertionSort-------------------
def InsertionSort(a):
  n = len(a)
  for i in range(1,n):
    temp = a[i]
    j = i-1
    while j>=0 and temp < a[j]:
      a[j+1] = a[j]
      j-=1
    a[j+1] = temp


n=[99,34,55,7,82,21,9,10,3,46]
InsertionSort(n)
print(n)

#QuickSort---------------------------
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]  # 중앙 값을 기준점으로 선택
    left = [x for x in arr if x < pivot]  # 기준점보다 작은 값을 가진 요소들
    middle = [x for x in arr if x == pivot]  # 기준점과 같은 값을 가진 요소들
    right = [x for x in arr if x > pivot]  # 기준점보다 큰 값을 가진 요소들
    return quicksort(left) + middle + quicksort(right)

array = [99,34,55,7,82,21,9,10,3,46]
sorted_array = quicksort(array)
print(sorted_array)

