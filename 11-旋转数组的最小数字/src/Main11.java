import java.util.Scanner;

public class Main11{
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int length = sc.nextInt();
			int[] arr = new int[length];
			for(int i=0;i<length;i++) {
				arr[i] = sc.nextInt();
			}
			
			System.out.println(arrayMin(arr));
			
		}
	}
	
	private static int arrayMin(int[] arr) throws Exception {
		if(arr.length==0) {
			throw new Exception("The input array is null!");
		}
		int left = 0, right = arr.length-1;
		int mid = left;	// 初始化为left原因：如果数组未旋转，则直接return arr[0]
		while(arr[left]>=arr[right]) {
			if(right-left==1) {
				mid = right;
				break;
			}
			mid = left+(right-left)/2;
			
			// arr[left]==arr[mid]==arr[right]时，按顺序查找
			if(arr[left]==arr[mid] && arr[left]==arr[right]) {
				return arrayMinInOrder(arr,left,right);
			}
			
			if(arr[mid]>=arr[left]) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return arr[mid];
	}
	
	private static int arrayMinInOrder(int[] arr, int left, int right) {
		int res = arr[left];
		for(int i=left+1;i<=right;i++) {
			if(res>arr[i]) {
				res = arr[i];
			}
		}
		return res;
	}
}