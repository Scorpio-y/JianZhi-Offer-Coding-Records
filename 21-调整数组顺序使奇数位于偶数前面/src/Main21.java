public class Main21{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
		Main21 test = new Main21();
		test.printArray(arr);
		test.reOrderOddEven(arr);
		test.printArray(arr);
	}
	
	// 重排数组
	public void reOrderOddEven(int[] arr) {
		// 使用双指针
		if(arr==null || arr.length==0) return;
		int left = 0, right = arr.length-1;
		while(left<right) {
			while(!isEven(arr[left]) && left<right) left++;
			while(isEven(arr[right]) && left<right) right--;
			if(left<right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}
	}
	
	// 判断是否为偶数
	private boolean isEven(int num) {
		return ((num&1)==0);
	}
	
	// 打印数组
	public void printArray(int[] arr) {
		if(arr==null || arr.length==0) return;
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.println(arr[arr.length-1]);
	}
}