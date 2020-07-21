public class Main14{
	public static void main(String[] args) {
		int n = 8;
		Main14 test = new Main14();
		int res = test.maxProduct(n);
		System.out.println(res);
	}
	
	private int maxProduct(int n) {
		// ��Ϊ�涨���Ӽ���m�Σ�m>1
		if(n<2) return 0;
		if(n<=3) return n-1;
		int[] dp = new int[n+1];
		
		// �����ǰ�治ͬ�����ǲ������ӵ����
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		
		int max = 0;
		for(int i=4;i<=n;i++) {
			max = 0;
			for(int j=1;j<=i/2;j++) {
				int product = dp[j]*dp[i-j];
				if(product>max) max = product;
			}
			dp[i] = max;
		}
		return dp[n];
	}
}