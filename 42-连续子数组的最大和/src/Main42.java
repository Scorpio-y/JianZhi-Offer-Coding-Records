public class Main42{
	public static void main(String[] args) throws Exception {
//		int[] arr = new int[] {1,-2,3,10,-4,7,2,-5}; 
		int[] arr = new int[] {-1,-2,-3,-10,-4,-7,-2,-5};
		Main42 test = new Main42();
		int res = test.findGreatestSumOfSubArray(arr);
		System.out.println(res);
	}
	
	public int findGreatestSumOfSubArray(int[] arr) throws Exception {
		if(arr==null || arr.length==0) throw new Exception("数组不能为空");
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for(int num:arr) {
			sum = sum<=0? num : sum+num;
			res = Math.max(res, sum);
		}
		return res;
	}
}