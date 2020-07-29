// ´ó¶¥¶Ñ

import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main40{
	public static void main(String[] args) {
		int[] arr = new int[] {4,5,1,6,2,7,3,8,9,10,0};
		int k = 5;
		Main40 test = new Main40();
		ArrayList<Integer> res = test.getLeastKNumbers(arr, k);
		System.out.println(res);
	}
	
	public ArrayList<Integer> getLeastKNumbers(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1,o2)->o2-o1);
		if(arr==null || arr.length==0 || k<=0) return new ArrayList<>();
		heap.add(arr[0]);
		for(int i=1; i<arr.length; i++) {
			if(heap.size()!=k || arr[i]<heap.peek()) {
				heap.add(arr[i]);
			}
			if(heap.size()>k) {
				heap.poll();
			}
		}
		return new ArrayList<>(heap);
	}
}