import java.util.Scanner;

// �����ַ��������ַ����еĿո��滻Ϊ20%

// ��ע��StringBuffer ��charAt()��setCharAt()����

public class Main5{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			// ���ռ���������ַ���
			StringBuilder str = new StringBuilder(sc.nextLine());
			ReplaceBlank(str);
			System.out.println(str);
		}
	}
	
	public static void ReplaceBlank(StringBuilder str) {
		char[] chr = str.toString().toCharArray();
		int left = chr.length-1;
		// �����ַ���������һ���ո񣬾���str����׷������Ԫ��
		for(char ele:chr) {
			if(ele==' ') {
				str.append("  ");
			}
		}
		
		// �Ӻ���ǰ����
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