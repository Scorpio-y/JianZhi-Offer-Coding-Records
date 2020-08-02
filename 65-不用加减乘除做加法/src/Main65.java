public class Main65{
	public static void main(String[] args) {
		int num1 = 200, num2 = 320;
		Main65 test = new Main65();
		int res = test.myAdd(num1, num2);
		System.out.println(res);
	}
	
	// b可以看成进位，a^b表示相加后不进位，(a&b)<<1表示进位，二者继续相加即是答案
	public int myAdd(int a, int b) {
		return b==0 ? a : myAdd(a^b,(a&b)<<1);
	}
}