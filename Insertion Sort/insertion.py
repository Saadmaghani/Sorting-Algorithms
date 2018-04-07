def sort(A):
	for i in range(1,len(A)):
		j=i;
		while(j>0 and  A[j] < A[j-1]): #in ascending order. replace < with > for descending
			A[j], A[j-1] = A[j-1], A[j]
			j-=1

n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A)
for x in A:
	print(x),