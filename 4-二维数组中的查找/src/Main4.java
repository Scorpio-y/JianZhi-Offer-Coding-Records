import java.util.Scanner;

// ����Ķ�ά����������ҵ������������µ���

public class Main4{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// �������������
			int row = sc.nextInt(), col = sc.nextInt();
			int[][] arr = new int[row][col];
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int target = sc.nextInt();
			boolean ans = Find(arr, row, col, target);
			System.out.println(ans);
		}
	}
	
	// �ж϶�ά�������Ƿ���ڸ�����
	public static boolean Find(int[][] arr, int row, int col, int target) {
		// �����½ǿ�ʼ
		int nr = row-1, nc = 0;
		while(nr>=0 && nc<col) {
			int now = arr[nr][nc];
			if(target>now) {
				nc = nc+1;
			}else if(target<now) {
				nr = nr-1;
			}else {
				return true;
			}
		}
		return false;
	}
}