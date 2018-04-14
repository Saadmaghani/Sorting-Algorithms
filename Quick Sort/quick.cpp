#include <iostream>
using namespace std;

void swap(double *A, int i, int j) {
	double t = A[i];
	A[i] = A[j];
	A[j] = t;
}

int partition(double *A, int beg, int end) {
	int v = end-1;
	double pivot = A[v];
	int i=beg-1;
	for(int j=i+1; j<end; j++) {
		if(j==v) {
			swap(A,i+1,v);
		}else{
			double newVal = A[j];
			if(newVal <= pivot) {
				swap(A,i+1,j);
				i++;
			}
		}
	}
	return 	i+1; //index of pivot
}
	
	


void sort(double * A, int beg, int end){ //sort from s to end-1
	if(beg+1<end){
		int v = partition(A,beg,end);
		sort(A,beg,v);
		sort(A,v+1,end);
	}	
}


int main(){
	int n;
	cin >> n;
	double *A = new double[n];
	for(int i=0; i<n; cin >> A[i++]);
	sort(A,0,n);
	for(int i=0; i<n; cout <<A[i++]<<" ");
}