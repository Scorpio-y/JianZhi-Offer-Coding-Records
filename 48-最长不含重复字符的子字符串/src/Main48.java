import java.util.Arrays;

public class Main48{
	public static void main(String[] args) {
		String str = "arabcacfr";
		Main48 test = new Main48();
		int res = test.longestSubStringWithoutDuplication(str);
		System.out.println(res);
	}
	
	public int longestSubStringWithoutDuplication(String str) {
		if(str==null || str.length()==0) return 0;
		int[] preIndex = new int[26];		// �洢ÿ���ַ���һ�γ���ʱ������
		Arrays.fill(preIndex, -1); 			// ��ʼ������Ԫ��Ϊ-1
		
		int len = str.length();
		int res = 0;
		int nowLen = 0;
		for(int i=0;i<len;i++) {
			int c = str.charAt(i)-'a';
			int preI = preIndex[c];
			if(preI==-1 || i-preI>nowLen) {	// ���֮ǰû���ֹ������߳��ֵ�����������һ�����ַ����ڣ��Ͳ�Ӱ��
				nowLen++;
			}else {
				res = Math.max(res, nowLen);
				nowLen = i-preI;
			}
			preIndex[c] = i;
		}
		return Math.max(res, nowLen);
	}
}