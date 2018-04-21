#include <iostream>
#include <cmath>
#include <limits>
using namespace std;

class Heap{
private:
	double *A;
	int size;
	void swap(int i, int j);
	int maxHeapify(int i);
public:
	Heap(int n);
	void onlineInsert(double x);
	void offlineInsert(double *B, int n);
	double max();
	double extractMax();
};

void sort(double * B, int n){ 
	Heap h(n);
	h.offlineInsert(B,n);
	for(int i=n-1; i>=0; B[i--]=h.extractMax());
}

int main(){
	int n;
	cin >> n;
	double *A = new double[n];
	for(int i=0; i<n; cin >> A[i++]);
	sort(A,n);
	for(int i=0; i<n; cout <<A[i++]<<" ");
}

/*  left child of i: 2i+1
	right child of i: 2i+2
	parent of i: (i-1)/2
*/	

	Heap::Heap(int n){
		A=new double[n];
		size=0;
	}

	void Heap::onlineInsert(double x){
		A[size]=x;
		int i= size++;
		while(i>0 && A[i] > A[(i-1)/2]){
			swap(i,(i-1)/2);
			i = (i-1)/2;
		}
	}

	void Heap::offlineInsert(double *B, int n){
		for(int i=0; i<n; i++){
			A[size++]=B[i];
		}

		for(int i=(size-2)/2; i>=0; i--){
			int j = i;
			while(j < size){
				int newJ = maxHeapify(j);
				if(newJ==j) break;
				else j=newJ;
			}
		}
	}

	double Heap::extractMax(){
		double x = max();
		A[0]= A[--size];
		int i=0;
		while(i<size){
			int newI = maxHeapify(i);
			if(newI==i)
				break;
			else
				i = newI;
		}
		return x;
	}

	int Heap::maxHeapify(int i){
		double p = A[i];
		double lc = (2*i+1 < size) ? A[2*i+1] : nan("");
		double rc = (2*i+2 < size) ? A[2*i+2] : nan("");
		if(!isnan(lc) && lc > p && ( isnan(rc) || lc >= rc)){
			swap(i, 2*i+1);
			return 2*i+1;	
		}else if(!isnan(rc) && rc >p && (isnan(lc) || rc >= lc)){
			swap(i, 2*i+2);
			return 2*i+2;
		}
		return i;
	}

	double Heap::max(){
		return A[0]; 
	}

	void Heap::swap(int i, int j){
		double t = A[i];
		A[i]=A[j];
		A[j]=t;
	}