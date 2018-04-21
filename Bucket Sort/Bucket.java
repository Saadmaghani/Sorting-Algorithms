import java.util.*;
class Bucket{
	
	public static void main(String args[]){
		ArrayList<Double> A = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			A.add(sc.nextDouble());
		}
		
		Bucket buckets[] = new Bucket[n];
		for(int i=0; i<n; buckets[i++]=new Bucket());

		for(int i=0; i<n; i++){
			int x = (int) Math.floor(A.get(i)*n);
			buckets[x].add(A.get(i));
		}
		for(int i=0; i<n; buckets[i++].sort());
		
		for(int i=0; i<n; buckets[i++].print());
	}
	
	private ArrayList<Double> list;
	Bucket(){
		list = new ArrayList<Double>();
	}

	void add(double x){
		list.add(x);
	}
	void print(){
		for(int i=0; i<list.size(); System.out.print(list.get(i++) +" "));
	}
	void sort(){
		for(int i=1; i<list.size(); i++){
			int j=i;
			while(j>0 &&  list.get(j) < list.get(j-1)){ //in ascending order. replace < with > for descending
				double t = list.get(j);
				list.set(j, list.get(j-1));
				list.set(j-1,t);
				j--;
			}
		}
	}
}