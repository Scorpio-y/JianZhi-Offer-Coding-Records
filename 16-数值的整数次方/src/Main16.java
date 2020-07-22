public class Main16{
	public static void main(String[] args) throws Exception {
		Main16 test = new Main16();
		double base = 2;
		int exponent = 10;
		double res = test.Power(base, exponent);
		System.out.println(res);
	}
	
	private double Power(double base, int exponent) throws Exception {
		if(base == 1) return 1;
		if(exponent == 0) {
			if(base == 0) throw new Exception("wrong number!");
			return 1;
		}
		
		boolean flag = true;
		if(exponent<0) {
			flag = false;
			exponent = -exponent;
		}
		
		double res = base;
		int count = 2;
		while(count <= exponent) {
			res = res*res;
			count = count << 1;
		}
		count = exponent - (count >> 1);
		while(count>0) {
			res = res*base;
			count--;
		}
		
		if(flag) {
			return res;
		}else {
			return 1/res;
		}
	}
}