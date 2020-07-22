public class Main17{
	public static void main(String[] args) throws Exception {
		int n = 3;
		Main17 test = new Main17();
		test.print1ToMaxOfNDigits_1(n);
		test.print1ToMaxOfNDigits_2(n);
	}
	
	// ���ܴ���n�ر������������������
	private void print1ToMaxOfNDigits_1(int n) throws Exception {
		if(n<0) throw new Exception("input should be greater than zero!!!");
		else if (n==0) return;
		long count = (long) (Math.pow(10, n));
		for(long i=1;i<count-1;i++) {
			System.out.print(i+", ");
		}
		System.out.println(count-1);
	}
	
	// *����ȫ���нⷨ,���ݷ�
	private void print1ToMaxOfNDigits_2(int n) throws Exception {
		if(n<0) throw new Exception("input should be greater than zero!!!");
		else if (n==0) return;
		char[] number = new char[n];
		print1ToMaxOfNDigits_2(number, 0);
	}
	
	// digit��ʾ��������
	private void print1ToMaxOfNDigits_2(char[] number, int digit) {
		if(digit==number.length) {	// ֱ����������һλ
			printNumber(number);
			return;
		}
		for(int i=0;i<10;i++) {
			number[digit] = (char) (i+'0');
			print1ToMaxOfNDigits_2(number,digit+1);	// �������һλ����ѭ��
		}
	}
	
	private void printNumber(char[] number) {
		int idx = 0;
		while(idx<number.length && number[idx]=='0') {
			idx++;
		}
		while(idx<number.length) {
			System.out.print(number[idx]);	// �ӵ�һ������0�����ֿ�ʼ��ӡ
			idx++;
		}
		System.out.println();
	}
}