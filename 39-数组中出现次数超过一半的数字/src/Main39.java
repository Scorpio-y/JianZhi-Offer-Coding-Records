public class Main39{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,2,2,2,5,4,2};
		Main39 test = new Main39();
		int res = test.moreThanHalfNum(arr);
		System.out.println(res);
	}
	
	public int moreThanHalfNum(int[] arr) {
		if(arr == null || arr.length == 0) {
			System.out.println("输入数组为空!");
			return -1;
		}
		int res = arr[0];
		int count = 1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==res) count++;
			else count--;
			
			if(count<0) {
				res = arr[i];
				count = 1;
			}
		}
		
		count = 0;
		for(int ele:arr) {
			if(ele == res) count++;
		}
		
		if(count<=arr.length/2) {
			System.out.println("数组没有出现次数超过一半的数字!");
			return -1;
		}
		return res;
	}
}