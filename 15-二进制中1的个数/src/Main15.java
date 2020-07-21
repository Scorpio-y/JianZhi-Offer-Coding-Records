// 输出二进制中1的个数，主要考虑输入为负数
public class Main15{
	public static void main(String[] args) {
		int n = -10;
		Main15 test = new Main15();
		int res1 = test.countOne1(n);
		int res2 = test.countOne2(n);
		int res3 = test.countOne3(n);
	
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
	
	private int countOne1(int n) {
		int res = 0;
		int flag = 1;
		while(flag!=0) {
			if((n & flag) != 0) res++;
			flag = flag << 1;
		}
		return res;
	}
	
	private int countOne2(int n) {
		int res = 0;
		while(n!=0) {
			res++;
			n = n & (n-1);
		}
		return res;
	}
	
	private int countOne3(int n) {
		return Integer.bitCount(n);
	}
}