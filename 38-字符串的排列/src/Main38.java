/*******�Ժ�ϰ�ص��ٿ�һ��*******/

import java.util.ArrayList;
import java.util.Arrays;

public class Main38{
	
	static ArrayList<String> res = new ArrayList<>();
	
	public static void main(String[] args) {
		String str = "aaaabcdefg";
		Main38 test = new Main38();
		test.strPermutation(str);
		System.out.println(res.size());
	}
	
	
	// ������������
	public void strPermutation(String str) {
		if(str==null || str.length()==0) return;
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		backtracking(chars, new boolean[chars.length], new StringBuilder());
	}
	
	private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
		if(s.length() == chars.length) {
			res.add(s.toString());
			return;
		}
		for(int i=0;i<chars.length;i++) {
			if(hasUsed[i]) continue;
			if(i!=0 && chars[i]==chars[i-1] && hasUsed[i-1]) continue;	// hasUsed��Ϊ!hasUsedҲ����
			hasUsed[i] = true;
			s.append(chars[i]);
			backtracking(chars, hasUsed, s);
			s.deleteCharAt(s.length()-1);
			hasUsed[i] = false;
		}
	}
}