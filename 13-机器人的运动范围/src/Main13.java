public class Main13{
	private static final int[][] next = {{-1,0},{1,0},{0,-1},{0,1}};
	private int row;
	private int col;
	private int threshold;
	private int count = 0;
	private int[][] digitSum;
	
	public static void main(String[] args) {
		Main13 test = new Main13();
		System.out.println(test.movingCount(3, 3, 2));
	}
	
	private int movingCount(int row, int col, int threshold) {
		this.row = row;
		this.col = col;
		this.threshold = threshold;
		initDigitSum();
		boolean[][] marked = new boolean[row][col];
		dfs(marked, 0, 0);
		return this.count;
	}
	
	// 回溯法，深度优先搜索（Depth First Search，DFS）的一个特例
	private void dfs( boolean[][] marked, int r, int c) {
		if(r<0 || r>=this.row || c<0 || c>=this.col || marked[r][c] || this.digitSum[r][c]>this.threshold) return;
		marked[r][c] = true;
		this.count++;
		for(int[] n:next) {
			dfs(marked, r+n[0], c+n[1]);
		}
	}
	
	private void initDigitSum() {
		int[] digitSumOne = new int[Math.max(this.row, this.col)];
		for(int i=0;i<digitSumOne.length;i++) {
			int n = i, res = 0;
			while(n>0) {
				res += n%10;
				n /= 10;
			}
			digitSumOne[i] = res;
		}
		
		this.digitSum = new int[this.row][this.col];
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				this.digitSum[i][j] = digitSumOne[i]+digitSumOne[j];
			}
		}
		
	}
}