import java.util.Arrays;

public class Main61{
	public static void main(String[] args) {
		int[] nums = new int[] {2,3,4,0,6};
		Main61 test = new Main61();
		boolean res = test.isContinues(nums);
		System.out.println(res);
	}
	
	public boolean isContinues(int[] nums) {
		if(nums==null || nums.length!=5) return false;
		
		Arrays.sort(nums);
		
		// 统计0的数量
		int count0 = 0;
		int i = 0;
		for(;i<5;i++) {
			if(nums[i]==0) count0++;
			else break;
		}
		
		int need = 0;		// 需要的0的个数
		for(;i<4;i++) {
			if(nums[i+1]==nums[i]) return false;
			need += nums[i+1]-nums[i]-1;
		}
		return need<=count0?true:false;
	}
}