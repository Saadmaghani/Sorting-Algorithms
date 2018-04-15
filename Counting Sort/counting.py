def sort(A,offset, m):
	C = [0] * int((m-offset+1))

	for i in range(len(A)):
		C[A[i]-offset]+=1
	for i in range(1, len(C)):
		C[i]+=C[i-1]

	B=[0]*len(A)
	i=len(A)-1
	while(i>=0):
		B[C[A[i]-offset]-1]= A[i]
		C[A[i]-offset]-=1
		i-=1
	return B

n = int(input())
i=0
A=[]
while(i<n):
	A.append(int(input()))
	i+=1

B = sort(A, min(A),max(A))
for x in B:
	print(x),