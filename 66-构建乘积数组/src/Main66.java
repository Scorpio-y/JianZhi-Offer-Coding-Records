public class Main66{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		Main66 test = new Main66();
		int[] res = test.getMultiplyArray(arr);
		test.printArray(arr);
		test.printArray(res);
	}
	
	public int[] getMultiplyArray(int[] arr) {
		if(arr==null || arr.length==0) return arr;
		int len = arr.length;
		int[] res = new int[len];
		
		for(int i=0, product=1; i<len; i++) {		// 先从左向右乘
			res[i] = product;
			product *= arr[i];
		}
		
		for(int i=len-1, product=1;i>=0;i--) {		// 再从右向左乘
			res[i] *= product;
			product *= arr[i];
		}
		return res;
	}
	
	public void printArray(int[] arr) {
		if(arr == null || arr.length==0) return;
		System.out.print("[");
		int len = arr.length;
		for(int i=0;i<len-1;i++) System.out.print(arr[i]+", ");
		System.out.println(arr[len-1]+"]");
	}
}