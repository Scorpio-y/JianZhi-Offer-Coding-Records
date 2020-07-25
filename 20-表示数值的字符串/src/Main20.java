public class Main20{
	public static void main(String[] args) {
		String str = "-5.2e+3";
		Main20 test = new Main20();
		System.out.println(test.isNumber(str));
	}
	
	// 使用正则表达式匹配         参考：https://blog.csdn.net/weixin_43860260/article/details/91417485
	public boolean isNumber(String s) {
		if(s == null || s.length()==0) return false;
		return s.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
	}
}