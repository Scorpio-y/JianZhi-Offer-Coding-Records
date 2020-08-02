import java.util.Arrays;

public class Main45{
	public static void main(String[] args) throws Exception {
		int[] nums = new int[] {1,3,2};
		Main45 test = new Main45();
		String res = test.minNumber(nums);
		System.out.println(res);
	}
	
	public String minNumber(int[] nums) throws Exception {
		if(nums==null || nums.length==0) throw new Exception("输入的数组为空！");
		int len = nums.length;
		String[] numbers = new String[len];
		for(int i=0; i<len; i++) {
			numbers[i] = nums[i]+"";
		}
		Arrays.sort(numbers, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));		// lambda表达式
		
		String res = "";
		for(String tmp:numbers) {
			res += tmp;
		}
		return res;
	}
}