public class Main17{
	public static void main(String[] args) throws Exception {
		int n = 3;
		Main17 test = new Main17();
		test.print1ToMaxOfNDigits_1(n);
		test.print1ToMaxOfNDigits_2(n);
	}
	
	// 不能处理n特别大的情况——大数问题
	private void print1ToMaxOfNDigits_1(int n) throws Exception {
		if(n<0) throw new Exception("input should be greater than zero!!!");
		else if (n==0) return;
		long count = (long) (Math.pow(10, n));
		for(long i=1;i<count-1;i++) {
			System.out.print(i+", ");
		}
		System.out.println(count-1);
	}
	
	// *数字全排列解法,回溯法
	private void print1ToMaxOfNDigits_2(int n) throws Exception {
		if(n<0) throw new Exception("input should be greater than zero!!!");
		else if (n==0) return;
		char[] number = new char[n];
		print1ToMaxOfNDigits_2(number, 0);
	}
	
	// digit表示数组索引
	private void print1ToMaxOfNDigits_2(char[] number, int digit) {
		if(digit==number.length) {	// 直到数组的最后一位
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++) {
			number[digit] = (char) (i+'0');
			print1ToMaxOfNDigits_2(number,digit+1);	// 数组的下一位继续循环
		}
	}
	
	private void printNumber(char[] number) {
		int idx = 0;
		while(idx<number.length && number[idx]=='0') {
			idx++;
		}
		while(idx<number.length) {
			System.out.print(number[idx]);	// 从第一个不是0的数字开始打印
			idx++;
		}
		System.out.println();
	}
}