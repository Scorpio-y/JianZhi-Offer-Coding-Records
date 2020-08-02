public class Main50{
	public static void main(String[] args) throws Exception {
		String str = "abaccdeff";
		Main50 test = new Main50();
		char res = test.getFirstNotRepeatingChar(str);
		System.out.println(res);
	}
	
	public char getFirstNotRepeatingChar(String str) throws Exception{
		if(str==null || str.length()==0) throw new Exception("�����ַ�������Ϊ�գ�");
		char[] chars = str.toCharArray();
		int[] count = new int[256];
		for(char c:chars) {
			count[c]++;
		}
		for(int i=0;i<256;i++) {
			if(count[i]==1) return (char)i;
		}
		throw new Exception("�ַ�����û��ֻ����һ�ε��ַ�");
	}
}