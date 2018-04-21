import java.util.*;
class Radix{
	
	public static void main(String args[]){
		ArrayList<Integer> A = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			A.add(sc.nextInt());
		}
		sort(A);
		for(int i=0; i<n; System.out.print(A.get(i++) +" "));
	}

	static void sort(ArrayList<Integer> A){
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		int maxDigits =0;
		for(int i=0; i<A.size(); i++){ //getting digits 
			ArrayList<Integer> x = getDigits(A.get(i));
			B.add(x);
			if(x.size()> maxDigits) maxDigits=x.size();
		}
		
		for(int i=0; i<B.size(); i++){ //making sure all numbers are of equal digits
			ArrayList<Integer> x = B.get(i);
			if(x.size() <maxDigits){
				while(maxDigits>x.size()){
					x.add(0,0);
				}
			}
		}

		for(int i=maxDigits-1; i>=0; i--){
			B = sortCol(B, i);
		}
		for(int i=0; i<B.size(); i++){
			int val=0;
			for(int j=maxDigits-1; j>=0; j--){
				val += B.get(i).get(j)*(Math.pow(10,(maxDigits-1)-j));
			}
			A.set(i,val);
		}
		
	}

	static ArrayList<ArrayList<Integer>> sortCol(ArrayList<ArrayList<Integer>> A, int col){

		int[] C = new int[10];
		for(int i=0; i<A.size(); i++){
			C[A.get(i).get(col)]+=1;
		}
		
		for(int i=1; i<C.length; i++){
			C[i]+= C[i-1];
		}

		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>(A);


		for(int i=A.size()-1; i>=0; i--){
			int val = A.get(i).get(col);
			B.set(C[val]-1, A.get(i));
			C[val]-=1;
		}
		
		return B;
	}

	static ArrayList<Integer> getDigits(int x){
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while(x>9){
			digits.add(0, x%10);
			x/=10;
		}
		digits.add(0,x);
		return digits;
	}
}