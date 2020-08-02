public class Main47{
	public static void main(String[] args) {
//		int[][] map = new int[][] {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		int[][] map = new int[][] {{1,2,5},{3,2,1}};
		Main47 test = new Main47();
		int res = test.getMaxValue1(map);
		System.out.println(res);
		res = test.getMaxValue2(map);
		System.out.println(res);
	}
	
	// 动态规划求解
	public int getMaxValue1(int[][] map) {
		if(map==null || map.length==0 || map[0].length==0) return 0;
		int row = map.length;
		int col = map[0].length;
		int[][] dp = new int[row][col];
		
		// 初始化dp第一列和第一行
		dp[0][0] = map[0][0];
		for(int i=1;i<row;i++) {
			dp[i][0] = dp[i-1][0]+map[i][0];
		}
		for(int i=1;i<col;i++) {
			dp[0][i] = dp[0][i-1]+map[0][i];
		}
		
		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+map[i][j];
			}
		}
		return dp[row-1][col-1];
	}
	
	// 优化版动态规划，dp只要一维数组即可
	public int getMaxValue2(int[][] map) {
		if(map==null || map.length==0 || map[0].length==0) return 0;
		int row = map.length;
		int col = map[0].length;
		int[] dp = new int[col];
		
		for(int[] rows:map) {
			dp[0] += rows[0];
			for(int i=1;i<col;i++) {
				dp[i] = Math.max(dp[i-1], dp[i])+rows[i];
			}
		}
		return dp[col-1];
	}
}