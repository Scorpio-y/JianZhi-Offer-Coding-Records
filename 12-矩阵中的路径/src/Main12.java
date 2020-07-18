public class Main12{
	private static int row, col;
	private static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
	
	public static void main(String[] args) {
		row = 3;
		col = 4;
		char[] arr = {'a','b','t','g','c','f','c','s','j','d','e','h'};
		char[][] map = buildMatrix(arr,row,col);
		char[] str = {'d','e','h','s','c'};
		boolean res = hasPath(map,str);
		System.out.println(res);
		
	}
	
	private static char[][] buildMatrix(char[] arr, int row, int col){
		char[][] ret = new char[row][col];
		for(int i=0, idx=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				ret[i][j] = arr[idx++];
			}
		}
		return ret;
	}
	
	private static boolean hasPath(char[][] map, char[] str) {
		boolean[][] marked = new boolean[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(backTracking(map, str, marked, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// map:地图   str:待寻找字符串   marked:用于标记走过的点   strLen：已经找到的序列长度    r:当前横坐标    c:当前纵坐标
	private static boolean backTracking(char[][] map, char[] str, boolean[][] marked, int strLen, int r, int c) {
		if(strLen==str.length) return true;
		if(r<0 || r>=row || c<0 || c>=col || marked[r][c] || map[r][c]!=str[strLen]) return false;
		marked[r][c] = true;
		for(int[] n : next) {
			if(backTracking(map, str, marked, strLen+1, r+n[0], c+n[1])) {
				return true;
			}
		}
		marked[r][c] = false;
		return false;
	}
}