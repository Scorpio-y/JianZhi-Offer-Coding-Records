/* ����ʹ�ó˳���, for, while, if, else, switch, case, A?B:C */

public class Main64{
	public static void main(String[] args) {
		int n = 10;
		Main64 test = new Main64();
		int res = test.getSum(n);
		System.out.println(res);
	}
	
	// �ݹ�
	public int getSum(int n) {
		int sum = n;
		boolean b = (n>0) && ((sum += getSum(n-1))>0);	// �õ���&&�Ķ�·ԭ���ж���ֹ����
		return sum;
	}
}