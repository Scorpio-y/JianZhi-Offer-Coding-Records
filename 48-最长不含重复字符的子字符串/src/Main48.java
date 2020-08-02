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
		int[] preIndex = new int[26];		// 存储每个字符上一次出现时的索引
		Arrays.fill(preIndex, -1); 			// 初始化数组元素为-1
		
		int len = str.length();
		int res = 0;
		int nowLen = 0;
		for(int i=0;i<len;i++) {
			int c = str.charAt(i)-'a';
			int preI = preIndex[c];
			if(preI==-1 || i-preI>nowLen) {	// 如果之前没出现过，或者出现的索引不在上一个子字符串内，就不影响
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