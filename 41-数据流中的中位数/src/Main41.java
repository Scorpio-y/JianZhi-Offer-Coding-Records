import java.util.PriorityQueue;

public class Main41{
	
	private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);	// 大根堆，存放小元素
	private PriorityQueue<Integer> right = new PriorityQueue<>();	// 小根堆，存放大元素
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		Main41 test = new Main41();
		for(int i=0;i<arr.length;i++) {
			test.insertNumber(i, arr[i]);
		}
		int res = test.getMedian(arr.length);
		System.out.println(res);
	}
	
	public void insertNumber(int i, int num) {
		if(i%2==0) {
			left.add(num);
			right.add(left.poll());	// 左边最大的元素放右边
		}else {
			right.add(num);
			left.add(right.poll());	// 右边最大的元素放左边
		}
	}
	
	public int getMedian(int n) {
		if(n%2==0) {
			return (left.peek()+right.peek())/2;
		}else {
			return right.peek();
		}
	}
}