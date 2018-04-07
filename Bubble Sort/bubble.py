def sort(A):
	for i in range(len(A)-1):
		for j in range(len(A)-1-i):
			if(A[j] > A[j+1]): #in ascending order. replace > with < for descending
				A[j], A[j+1] = A[j+1], A[j]


n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A)
for x in A:
	print(x),