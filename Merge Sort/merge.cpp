#include <iostream>
using namespace std;

void merge(double *A, int s1, int end1, int end2){ //merge A[s1..end1] and A[end1..end2]. end1 and end2 exclusive
	int i=s1, j=end1;
	double *T = new double[end2-s1];
	int ind=0;
	while(i<end1 && j<end2){
		if(A[i] < A[j])
			T[ind]=A[i++];
		else
			T[ind]=A[j++];
		ind++;
	}

	if(j<end2)
		for(j; j<end2; j++)
			T[ind++]=A[j];
		
	else if(i<end1)
		for(i; i<end1; i++)
			T[ind++]=A[i];
		
	
	ind=s1;
	for(i=0; i<end2-s1; i++)
		A[ind++]=T[i];
	
	delete[] T;
}


void sort(double * A, int s, int end){ //sort from s to end-1
	if(s+1<end){
		int half = (end+s)/2;
		sort(A,s,half);
		sort(A,half,end);
		merge(A,s,half,end);
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