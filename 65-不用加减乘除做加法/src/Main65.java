public class Main65{
	public static void main(String[] args) {
		int num1 = 200, num2 = 320;
		Main65 test = new Main65();
		int res = test.myAdd(num1, num2);
		System.out.println(res);
	}
	
	// b���Կ��ɽ�λ��a^b��ʾ��Ӻ󲻽�λ��(a&b)<<1��ʾ��λ�����߼�����Ӽ��Ǵ�
	public int myAdd(int a, int b) {
		return b==0 ? a : myAdd(a^b,(a&b)<<1);
	}
}