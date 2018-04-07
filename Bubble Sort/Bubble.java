import java.util.*;
class Bubble{
	
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
			for(int j=0; j<A.size()-1-i; j++){
				if(A.get(j) > A.get(j+1)){ //in ascending order. replace > with < for descending
					double t = A.get(j);
					A.set(j, A.get(j+1));
					A.set(j+1, t);
				}
			}
		}
	}
}