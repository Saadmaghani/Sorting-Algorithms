import java.util.*;
class Counting{
	
	public static void main(String args[]){
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			if(min>x) min=x;
			if(max<x) max=x;
			A.add(x);
		}
		int[] B = sort(A, min, max);
		for(int i=0; i<n; System.out.print(B[i++] +" "));
	}

	static int[] sort(ArrayList<Integer> A, int offset, int max){
		int[] C = new int[max-offset+1];
		for(int i=0; i<A.size(); i++){
			C[A.get(i)-offset]+=1;
		}
		
		for(int i=1; i<C.length; i++){
			C[i]+= C[i-1];
		}

		int[] B = new int[A.size()];
		for(int i=A.size()-1; i>=0; i--){
			int val = A.get(i);
			B[C[val-offset]-1] = val;
			C[val-offset]-=1;
		}
		return B;
	}
}