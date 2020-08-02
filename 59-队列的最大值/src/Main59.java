import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main59{
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,4,2,6,2,5,1};
		int size = 3;
		Main59 test = new Main59();
		ArrayList<Integer> res = test.maxInWindows(arr,size);
		System.out.println(res);
	}
	
	// 使用大根堆
	public ArrayList<Integer> maxInWindows(int[] arr, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		
		int len = arr.length;
		if(arr==null || arr.length==0 || size<1 || size>len) return res;
		
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
		for(int i=0;i<size;i++) heap.add(arr[i]);
		
		res.add(heap.peek());
		
		for(int i=0, j=size;j<len;i++,j++) {
			heap.remove(arr[i]);
			heap.add(arr[j]);
			res.add(heap.peek());
		}
		return res;
	}
}