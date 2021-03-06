import java.util.Scanner;

// 《剑指offer》第3题：数组中重复的数字
public class Main3{
	public static void main(String[] args) {
		// 接收键盘输入的数组
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int len = sc.nextInt();
			int[] arr = new int[len];
			for(int i=0;i<len;i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(getDuplication(arr, len));  // duplicate函数会修改arr数组，所以放在后面
			System.out.println(duplicate(arr, len));
		}
	}
	
	// 判断数组中是否有重复的数字
	private static boolean duplicate(int[] arr, int len) {
		if(arr==null || len<=0) return false;
		// 如果判断越界的话，必须在外面单独用循环判断
		for(int i=0;i<len;i++) {
			if(arr[i]<0 || arr[i]>=len) return false;
		}
		
		for(int i=0;i<len;i++) {
			int num = arr[i];
			while(num!=i) {
				if(arr[num]!=num) {
					int tmp = arr[num];
					arr[num] = num;
					num = tmp;
				}else {
					return true;
				}
			}
		}
		return false;
	}

	
	// 不修改数组找出重复的数字,若没有重复返回-1
	private static int getDuplication(int[] arr, int len) {
		int left = 1, right = len-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			int count = countRange(arr,left,mid);
			if(left==right) {
				if(count>1) return left;
				else break;
			}
			if(count>(mid-left+1)) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	private static int countRange(int[] arr, int left, int right) {
		int count = 0;
		for(int ele:arr) {
			if(ele>=left && ele<=right) count++;
		}
		return count;
	}
}