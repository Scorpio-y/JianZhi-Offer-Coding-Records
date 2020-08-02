public class Main43{
	public static void main(String[] args) {
		Main43 test = new Main43();
		int n = 213450000;
		int res = test.numberOf1Between1AndN(n);
		System.out.println(res);
	}
	
	// ±©Á¦·¨
	public int numberOf1Between1AndN(int n) {
		if(n<=0) return 0;
		int res = 0;
		while(n>0) {
			char[] tmp = String.valueOf(n).toCharArray();
			for(char ele:tmp) {
				if(ele=='1') res++;
			}
			n--;
		}
		return res;
	}
}