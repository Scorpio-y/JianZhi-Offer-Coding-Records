import java.util.Scanner;

public class Test{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str1 = sc.nextLine();
			int row = Integer.valueOf(str1.split(" ")[0]);
			int col = Integer.valueOf(str1.split(" ")[1]);
			String str = sc.nextLine();
			int[][] arr = new int[row][col];
			for(int i=0, idx = 0;i<row;i++) {
				for(int j=0;j<col;j++) {
					arr[i][j] = str.charAt(idx++)-'0';
				}
			}
			String str2 = sc.nextLine();
			str2 = str2.substring(1, str2.length()-1);
			int y = Integer.valueOf(str2.split(",")[0]);
			int x = Integer.valueOf(str2.split(",")[1]);
			
			
		}
	}
}