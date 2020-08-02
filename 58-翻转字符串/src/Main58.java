public class Main58{
	public static void main(String[] args) {
		String str = "I am a student.";
		Main58 test = new Main58();
		String res = test.reverseStr(str);
		System.out.println(res);
	}
	
	public String reverseStr(String str) {
		if(str==null || str.length()==0) return "";
		String[] arr = str.split(" ");
		StringBuilder res = new StringBuilder();
		int len = arr.length;
		for(int i=len-1;i>=1;i--) {
			res.append(arr[i]);
			res.append(" ");
		}
		res.append(arr[0]);
		return res.toString();
	}
}