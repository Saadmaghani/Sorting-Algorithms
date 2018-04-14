import java.util.*;
class Quick{
	
	public static void main(String args[]){
		ArrayList<Double> A = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; A.add(sc.nextDouble()),i++);
		sort(A,0,n);
		for(int i=0; i<n; System.out.print(A.get(i++) +" "));
	}

	static void sort(ArrayList<Double> A, int beg, int end){ //sort from s to end-1
		if(beg+1 < end) {
			int v = partition(A,beg,end);
			sort(A,beg,v);
			sort(A,v+1,end);
		}
	}
	
	static int partition(ArrayList<Double> A, int beg, int end) {
		int v = end-1;
		double pivot = A.get(v);
		int i=beg-1;
		for(int j=i+1; j<end; j++) {
			if(j==v) {
				swap(A,i+1,v);
			}else{
				double newVal = A.get(j);
				if(newVal <= pivot) {
					swap(A,i+1,j);
					i++;
				}
			}
		}
		return 	i+1; //index of pivot
	}
	
	static void swap(ArrayList<Double> A, int i, int j) {
		double t = A.get(i);
		A.set(i, A.get(j));
		A.set(j,t);
	}
}