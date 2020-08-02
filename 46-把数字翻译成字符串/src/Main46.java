public class Main46{
	public static void main(String[] args) {
//		int num = 12258;
		int num = 506;
		Main46 test = new Main46();
		int res = test.getTranslationCount(num);
		System.out.println(res);
	}
	
	// 用动态规划做
	public int getTranslationCount(int num) {
		if(num<0) return 0;
		int f_2 = 1;
		int f_1 = 1;
		int res = 1;
		int rem = num%10;
		num /= 10;
		while(num>0) {
			int flag = isValid((num%10)*10+rem);
			res = f_1 + flag*f_2;
			f_2 = f_1;
			f_1 = res;
			rem = num%10;
			num /= 10;
		}
		return res;
	}
	
	private int isValid(int num) {
		if(num>10 && num<26) return 1;		// 必须要大于10，否则像输入506答案就会出错，06没有与之对应的单个字符
		else return 0;
	}
}