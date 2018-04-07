def sort(A):
	for i in range(len(A)-1):
		minInd = i
		for j in range(i+1, len(A)):
			if(A[j] < A[minInd]): #in ascending order. replace > with < for descending
				minInd=j
		A[minInd], A[i] = A[i], A[minInd]

n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A)
for x in A:
	print(x),