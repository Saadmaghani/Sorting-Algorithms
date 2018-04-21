class Heap:
	def __init__(self):
		self.heap=[]

	def onlineInsert(self, x):
		self.heap.append(x)
		i = len(self.heap)-1
		while i>0 and self.heap[i] > self.heap[(i-1)//2]:
			self.heap[i], self.heap[(i-1)//2] = self.heap[(i-1)//2], self.heap[i]
			i = (i-1)//2

	def max(self):
		return self.heap[0]

	def maxHeapify(self, i):
		p = self.heap[i]
		lc = self.heap[2*i+1] if 2*i+1 < len(self.heap) else float("-inf")
		rc = self.heap[2*i+2] if 2*i+2 < len(self.heap) else float("-inf")
		if lc > p and lc >= rc:
			self.heap[i], self.heap[2*i+1] = self.heap[2*i+1], self.heap[i]
			return 2*i+1
		elif rc > p and rc >=lc:
			self.heap[i], self.heap[2*i+2] = self.heap[2*i+2], self.heap[i]
			return 2*i+2
		else:
			return i

	
	def offlineInsert(self, A, mH):
		self.heap.extend(A)
		i = (len(A)-1)//2
		while i>=0:
			j=i
			while i<len(self.heap):
				newJ = mH(j)
				if j==newJ:
					break
				else:
					j=newJ
			i-=1
	
	
	def extractMax(self, max, mH):
		x = max()
		self.heap[0] = self.heap[len(self.heap)-1]
		self.heap.pop()
		i=0
		while i<len(self.heap):
			newI = mH(i)
			if newI==i:
				break
			else:
				i=newI
		return x


def sort(A):
	h = Heap()
	h.offlineInsert(A, h.maxHeapify)
	i=len(A)-1
	while i>=0:
		A[i] = h.extractMax(h.max, h.maxHeapify)
		i-=1

n = int(input())
i=0
A=[]
while(i<n):
	A.append(float(input()))
	i+=1

sort(A)
for x in A:
	print(x),