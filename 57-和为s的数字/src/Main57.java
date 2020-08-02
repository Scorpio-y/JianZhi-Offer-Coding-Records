public class Main57{
	public static void main(String[] args) throws Exception {
		int[] arr = new int[] {1,2,4,7,11,15};
		int target = 15;
		Main57 test = new Main57();
		int[] res = test.findNumbersWithSumN(arr,target);
		System.out.println("["+res[0]+","+res[1]+"]");
	}
	
	public int[] findNumbersWithSumN(int[] arr, int target) throws Exception{
		if(arr==null || arr.length==0) throw new Exception("数组为空！");
		int left = 0, right = arr.length-1;
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(sum>target) right--;
			else if(sum<target) left++;
			else return new int[] {arr[left],arr[right]};
		}
		throw new Exception("无解！");
	}
}