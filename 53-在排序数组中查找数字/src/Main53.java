public class Main53{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,3,3,3,4,5};
		int target = 3;
		Main53 test = new Main53();
		int res = test.getNumberOfN1(arr,target);
		System.out.println(res);
		res = test.getNumberOfN2(arr,target);
		System.out.println(res);
	}
	
	public int getNumberOfN1(int[] arr, int target) {
		int first = binaryHelp1(arr, target);
		int second = binaryHelp1(arr, target+1);
		System.out.println();
		return (first == arr.length || arr[first]!=target) ? 0 : second-first;
	}
	
	public int getNumberOfN2(int[] arr, int target) {
		int first = binaryHelp2(arr, target-1);
		int second = binaryHelp2(arr, target);
		System.out.println();
		return (second == arr.length || arr[second]!=target) ? 0 : second-first;
	}
	
	// 使用二分法
	public int binaryHelp1(int[] arr, int target) {
		if(arr == null || arr.length==0) return -1;
		int left = 0, right = arr.length-1;
		
		// 找到值的最左边索引
		while(left<right) {
			int mid = left + (right-left)/2;		// 数量是偶数时，取中间偏左的，所以需要left+,否则可能陷入死循环
			if(target<=arr[mid]) right = mid;
			else left = mid+1;
		}
		return left;
	}
	
	// 使用二分法
	public int binaryHelp2(int[] arr, int target) {
		if(arr == null || arr.length==0) return -1;
		int left = 0, right = arr.length-1;
		
		// 找到值的最右边边索引
		while(left<right) {
			int mid = left + (right-left)/2 + 1;	// 数量是偶数时，取中间偏右的，所以需要right-,否则可能陷入死循环
			if(target<arr[mid]) right = mid-1;
			else left = mid;
		}
		return right;
	}	
}