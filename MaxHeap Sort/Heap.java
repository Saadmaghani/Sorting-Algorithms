import java.util.*;
class Heap{
	
	public static void main(String args[]){
		ArrayList<Double> A = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; A.add(sc.nextDouble()),i++);
		Heap h = new Heap();
		h.sort(A);
		for(int i=0; i<n; System.out.print(A.get(i++) +" "));
	}

	void sort(ArrayList<Double> A){ 
		offlineInsert(A);
		for(int i=A.size()-1; i>=0;i--){
			A.set(i, extractMax());
		}
	}

	/*  left child of i: 2i+1
		right child of i: 2i+2
		parent of i: (i-1)/2
	*/
	ArrayList<Double> heap; 
	Heap(){
		heap=new ArrayList<Double>();
	}

	public void onlineInsert(double x){
		heap.add(x);
		int i= heap.size()-1;
		while(i>0 && heap.get(i) > heap.get((i-1)/2)){
			swap(i,(i-1)/2);
			i = (i-1)/2;
		}
	}

	public void offlineInsert(ArrayList<Double> A){
		for(int i=0; i<A.size(); heap.add(A.get(i++)));
		for(int i=(A.size()-1)/2; i>=0; i--){
			int j = i;
			while(j<heap.size()){
				int newJ = maxHeapify(j);
				if(newJ==j)break;
				else j=newJ;
			}
		}
	}

	public double extractMax(){
		double x = max();
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int i=0;
		while(i<heap.size()){
			int newI = maxHeapify(i);
			if(newI==i)
				break;
			else
				i = newI;
		}
		return x;
	}

	private int maxHeapify(int i){
		double p = heap.get(i);
		Double lc = (2*i+1 < heap.size()) ? heap.get(2*i+1) : Double.NEGATIVE_INFINITY;
		Double rc = (2*i+2 < heap.size()) ? heap.get(2*i+2) : Double.NEGATIVE_INFINITY;
		if(lc > p && lc >= rc){
			swap(i, 2*i+1);
			return 2*i+1;
			
		}else if(rc >p && rc >= lc){
			swap(i, 2*i+2);
			return 2*i+2;
		}
		return i;
	}

	public double max(){
		return heap.get(0); 
	}

	public void swap(int i, int j){
		double t = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, t);
	}
}