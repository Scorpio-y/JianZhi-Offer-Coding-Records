import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test{
	static Set<ArrayList<Integer>> set = new HashSet<>();
	static int res = 0;
	public static void main(String[] args) {
		int[] arr = {1,2,-3};
        find(arr);
        for(ArrayList<Integer> a : set) {
        	if(isSubArray(a)) res++;
        }
        System.out.println(res);
	}
	
	public static void find(int[] arr) {
        for(int j=0;j<arr.length;j++) {
        	for(int i=0;i<=j;i++) {
        		int[] a = Arrays.copyOfRange(arr, i, j+1);
        		ArrayList<Integer> tmp = new ArrayList<>();
        		for(int n:a) tmp.add(n);	// 需要去重，所以转成arraylist再存
        		set.add(tmp);
        	}
        }
    }
	
	public static void find(int[] arr, Set<int[]> set) {
        for(int j=0;j<arr.length;j++) {
        	for(int i=0;i<=j;i++) {
        		int[] a = Arrays.copyOfRange(arr, i, j+1);
        		set.add(a);		// 不去重没影响，直接存数组
        	}
        }
    }
	
	private static boolean isSubArray(ArrayList<Integer> list) {
		Set<int[]> set = new HashSet<>();
		int[] tmp = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			tmp[i] = list.get(i);
		}
		
		find(tmp, set);
		for(int[] a : set) {
			int sum = 0;
			for(int i=0;i<a.length;i++) {
				sum += a[i];
			}
			if(sum==0) return false;
		}
		return true;
	}
}