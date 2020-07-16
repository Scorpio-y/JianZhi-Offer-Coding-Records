public class Main10{
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(Fibonacci(n));
		System.out.println(Fibonacci2(n));
	}
	
	private static long Fibonacci(int n) {
		if(n<2) return n;
		long n_1 = 1, n_2 = 0, res = 0;
		for(int i=2;i<=n;i++) {
			res = n_1+n_2;
			n_2 = n_1;
			n_1 = res;
		}
		return res;
	}
	
	// ÇàÍÜÌøÌ¨½×£¬À©Õ¹
	private static long Fibonacci2(int n) {
		return (long) Math.pow(2, n-1);
	}
}