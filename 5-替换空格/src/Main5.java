import java.util.Scanner;

// 输入字符串，将字符串中的空格替换为20%

// 备注：StringBuffer 有charAt()和setCharAt()方法

public class Main5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			// 接收键盘输入的字符串
			StringBuilder str = new StringBuilder(sc.nextLine());
			ReplaceBlank(str);
			System.out.println(str);
		}
	}
	
	public static void ReplaceBlank(StringBuilder str) {
		char[] chr = str.toString().toCharArray();
		int left = chr.length-1;
		// 遍历字符串，发现一个空格，就在str后面追加两个元素
		for(char ele:chr) {
			if(ele==' ') {
				str.append("  ");
			}
		}
		
		// 从后向前遍历
		int right = str.length()-1;
		while(left>=0 && right>left) {
			char tmp = str.charAt(left--);
			if(tmp!=' ') {
				str.setCharAt(right--, tmp);
			}else {
				str.setCharAt(right--, '0');
				str.setCharAt(right--, '2');
				str.setCharAt(right--, '%');
			}
		}
	}
}