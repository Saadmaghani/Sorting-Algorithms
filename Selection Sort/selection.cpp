#include <iostream>
using namespace std;

void sort(double * A, int n){
	for(int i=0; i<n-1; i++){
		int minInd = i;
		for(int j=i+1; j<n; j++)
			if(A[j] < A[minInd]) minInd=j; //in ascending order. replace < with > for descending (change minInd to maxInd too)
		double t = A[i];
		A[i] = A[minInd];
		A[minInd] = t;
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