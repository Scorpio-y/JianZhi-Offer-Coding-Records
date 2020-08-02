public class Main49{
	public static void main(String[] args) throws Exception {
		int n = 1500;
		Main49 test = new Main49();
		int res = test.getUglyNumber(n);
		System.out.println(res);
	}
	
	public int getUglyNumber(int n) throws Exception {
		if(n<=0) throw new Exception("输入的n必须为大于0的整数！");
		if(n<6) return 6;
		int idx2 = 0, idx3 = 0, idx5 = 0;
		int[] dp = new int[n];
		dp[0] = 1;
		for(int i=1; i<n; i++) {
			int next2 = dp[idx2]*2, next3 = dp[idx3]*3, next5 = dp[idx5]*5;
			dp[i] = Math.min(next2, Math.min(next3, next5));
			
			if(dp[i]==next2) idx2++;	// 不能写成if else形式，因为next2,next3,next5可能会相同
			if(dp[i]==next3) idx3++;
			if(dp[i]==next5) idx5++;
		}
		return dp[n-1];
	}
}