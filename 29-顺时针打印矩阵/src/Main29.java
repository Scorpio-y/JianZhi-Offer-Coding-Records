public class Main29{
	public static void main(String[] args) {
		Main29 test = new Main29();
		int[][] mat1 = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int[][] mat2 = new int[][] {{1,2},{3,4}};
		test.printMatrixInCircle(mat1);
		System.out.println();
		test.printMatrixInCircle(mat2);
		System.out.println();
	}
	
	// ²Î¿¼https://github.com/CyC2018/CS-Notes/blob/master/notes/29.%20%E9%A1%BA%E6%97%B6%E9%92%88%E6%89%93%E5%8D%B0%E7%9F%A9%E9%98%B5.md
	private void printMatrixInCircle(int[][] matrix) {
		int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
	    while (r1 <= r2 && c1 <= c2) {
	        for (int i = c1; i <= c2; i++)
	            System.out.print(matrix[r1][i]+", ");
	        for (int i = r1 + 1; i <= r2; i++)
	        	System.out.print(matrix[i][c2]+", ");
	        for (int i = c2 - 1; i >= c1; i--)
	        	System.out.print(matrix[r2][i]+", ");
	        for (int i = r2 - 1; i > r1; i--)
	        	System.out.print(matrix[i][c1]+", ");
	        r1++; r2--; c1++; c2--;
	    }
	}
	
}