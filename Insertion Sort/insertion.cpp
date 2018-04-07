#include <iostream>
using namespace std;

void sort(double * A, int n){
	for(int i=1; i<n; i++){
		int j=i;
		while(j>0 &&  A[j] < A[j-1]){ //in ascending order. replace < with > for descending
			double t = A[j];
			A[j]=A[j-1];
			A[j-1]=t;
			j--;
		}
	}
}

int main(){
	int n;
	cin >> n;
	double *A = new double[n];
	for(int i=0; i<n; cin >> A[i++]);
	sort(A,n);
	for(int i=0; i<n; cout <<A[i++]<<" ");
}