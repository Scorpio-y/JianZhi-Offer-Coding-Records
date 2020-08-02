public class Main56{
	public static void main(String[] args) {
		int[] arr = new int[] {2,4,3,6,3,2,5,5};
		Main56 test = new Main56();
		int[] res = test.findNumsAppearOnce(arr);
		System.out.println("["+res[0]+","+res[1]+"]");
	}
	
	public int[] findNumsAppearOnce(int[] arr) {
		int tmp = 0;

		// 全部数字异或
		for(int ele:arr) {
			tmp = tmp^ele;
		}
		
		tmp = tmp & (-tmp);	// 除了tmp中最右边第一位为1的数，然后其他位都置为0
		
		int[] res = new int[2];
		for(int ele:arr) {
			if((ele&tmp)==0) res[0] = res[0]^ele;
			else res[1] = res[1]^ele;
		}
		
		return res;
	}
}