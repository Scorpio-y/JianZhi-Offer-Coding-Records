/* 万凯 华为 提前批 笔试 第2-3题 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		di2ti();
//		di3ti();
	}
	
	public static void di2ti() {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] dir = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
		int[][] map = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// bfs
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		boolean[][] isvisited = new boolean[M][N];
		isvisited[0][0] = true;
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			if(xy[0]==M-1 && xy[1]==N-1) {
				System.out.println(1);
				return;
			}
			for(int i=0;i<4;i++) {
				int x = xy[0]+dir[i][0]*S;
				int y = xy[1]+dir[i][1]*S;
				if(x>=0 && x<M && y>=0 && y<N && !isvisited[x][y] && map[x][y]==1) {
					isvisited[x][y] = true;
					queue.add(new int[] {x,y});
				}
			}
		}
		System.out.println(0);
	}
	
	public static void di3ti() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String[] in = sc.nextLine().split(",");
			String str = in[0];
			char[] c = str.toCharArray();
			int col = Integer.parseInt(in[1]);
			if(col == 1) {
				System.out.println(str);
				return;
			}
			ArrayList<StringBuilder> list = new ArrayList<>();
			for(int i=0;i<col;i++) list.add(new StringBuilder());
			
			int left = 0, right = col-1;
			int len = c.length;
			boolean toright = false;
			int idx = 0;
			while(len>0) {
				if((left == 0) || (left == right)) toright = !toright;
				if(left != right) {
					len = len-2;
					list.get(left).append(c[idx++]);
					list.get(right).append(c[idx++]);
				}else {
					len = len-1;
					list.get(left).append(c[idx++]);
				}
				if(toright) {
					left++;
					right--;
				}else {
					left--;
					right++;
				}
			}
			
			StringBuilder res = new StringBuilder();
			for(int i=0;i<col;i++) res.append(list.get(i));
			System.out.println(res);
		}
	}
	
}