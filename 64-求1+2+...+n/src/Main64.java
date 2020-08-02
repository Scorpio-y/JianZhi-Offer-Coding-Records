/* 不能使用乘除法, for, while, if, else, switch, case, A?B:C */

public class Main64{
	public static void main(String[] args) {
		int n = 10;
		Main64 test = new Main64();
		int res = test.getSum(n);
		System.out.println(res);
	}
	
	// 递归
	public int getSum(int n) {
		int sum = n;
		boolean b = (n>0) && ((sum += getSum(n-1))>0);	// 用到了&&的短路原则判断终止条件
		return sum;
	}
}