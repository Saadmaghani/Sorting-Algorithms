import java.util.*;
class Merge{
	
	public static void main(String args[]){
		ArrayList<Double> A = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; A.add(sc.nextDouble()),i++);
		sort(A,0,A.size());
		for(int i=0; i<n; System.out.print(A.get(i++) +" "));
	}

	static void merge(ArrayList<Double> A, int s1, int end1, int end2){ //merge A[s1..end1] and A[end1..end2]. end1 and end2 exclusive
		int i=s1, j=end1;
		ArrayList<Double> T = new ArrayList<Double>();
		
		while(i<end1 && j<end2){
			if(A.get(i) < A.get(j))
				T.add(A.get(i++));
			else
				T.add(A.get(j++));
		}

		if(j<end2)
			T.addAll(A.subList(j,end2));	
		else if(i<end1)
			T.addAll(A.subList(i,end1));
			
		int ind=s1;
		for(i=0; i<T.size(); i++)
			A.set(ind++, T.get(i));
	}


	static void sort(ArrayList<Double> A, int s, int end){ //sort from s to end-1
		if(s+1<end){
			int half = (end+s)/2;
			sort(A,s,half);
			sort(A,half,end);
			merge(A,s,half,end);
		}	
	}
}