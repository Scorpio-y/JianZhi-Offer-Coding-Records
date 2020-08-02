public class Main63{
	public static void main(String[] args) {
		int[] arr = new int[] {9,11,8,5,7,12,16,14};
		Main63 test = new Main63();
		int res = test.maxProfit(arr);
		System.out.println(res);
	}
	
	public int maxProfit(int[] arr) {
		if(arr==null || arr.length==0) return 0;
		int buy = arr[0];
		int len = arr.length;
		int res = 0;
		for(int i=1;i<len;i++) {
			if(arr[i]>buy) res = Math.max(res, arr[i]-buy);
			else if(arr[i]<buy) buy = arr[i];
		}
		return res;
	}
}