#include <iostream>
#include <climits>
using namespace std;

int * sort(int * A, int n, int offset, int max){
	int *C = new int[max-offset+1]();
	for(int i=0; i<n; i++){
		C[A[i]-offset]+=1;
	}
	
	for(int i=1; i<max-offset+1; i++){
		C[i]+= C[i-1];
	}

	int *B = new int[n];
	for(int i=n-1; i>=0; i--){
		int val = A[i];
		B[C[val-offset]-1] = val;
		C[val-offset]-=1;
	}
	return B;
}

int main(){
	int n;
	cin >> n;
	int *A = new int[n];
	int max = INT_MIN;
	int min = INT_MAX;
	for(int i=0; i<n; i++){
		cin >> A[i];
		if(A[i]>max) max = A[i];
		if(A[i]<min) min = A[i];
	}
	int *B =sort(A,n,min,max);
	for(int i=0; i<n; cout <<B[i++]<<" ");
}