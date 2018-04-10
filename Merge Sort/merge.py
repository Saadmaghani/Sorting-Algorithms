def merge(A,s1,end1,end2):
	i=s1
	j=end1
	T=[]
	while(i<end1 and j<end2):
		if(A[i]<A[j]):
			T.append(A[i])
			i+=1
		else:
			T.append(A[j])
			j+=1
	if(i<end1):
		for x in A[i:end1]:
			T.append(x)
	else:
		for x in A[j:end2]:
			T.append(x)

	j=s1
	for i in range(len(T)):
		A[j]=T[i]
		j+=1

def sort(A,s,end):
	if(s+1<end):
		half = (s+end)/2
		sort(A,s,half)
		sort(A,half,end)
		merge(A,s,half,end)

n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A,0,n)
for x in A:
	print(x),