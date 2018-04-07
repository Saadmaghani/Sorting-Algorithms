import java.util.*;
class Selection{
	
	public static void main(String args[]){
		ArrayList<Double> A = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; A.add(sc.nextDouble()),i++);
		sort(A);
		for(int i=0; i<n; System.out.print(A.get(i++) +" "));
	}

	static void sort(ArrayList<Double> A){
		for(int i=0; i<A.size()-1; i++){
			int minInd = i;
			for(int j=i+1; j<A.size(); j++)
				if(A.get(j) < A.get(minInd)) minInd=j; //in ascending order. replace < with > for descending (change minInd to maxInd too)
			double t = A.get(i);
			A.set(i, A.get(minInd));
			A.set(minInd, t);
		}
	}
}