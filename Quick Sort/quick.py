def partition(A,beg,end):
	v = end-1
	pivot = A[v]
	i=beg-1
	for j in range(beg, end):
		if(j==v):
			A[i+1],A[v]=A[v],A[i+1]
		else:
			newVal = A[j]
			if newVal <= pivot:
				A[i+1], A[j] = A[j], A[i+1]
				i+=1
	return 	i+1 #index of pivot

def sort(A,beg,end):
	if(beg+1<end):
		v = partition(A,beg,end)
		sort(A,beg,v)
		sort(A,v+1,end)

n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A,0,n)
for x in A:
	print(x),