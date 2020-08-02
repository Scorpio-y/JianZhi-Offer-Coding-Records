public class Main53{
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,3,3,3,4,5};
		int target = 3;
		Main53 test = new Main53();
		int res = test.getNumberOfN1(arr,target);
		System.out.println(res);
		res = test.getNumberOfN2(arr,target);
		System.out.println(res);
	}
	
	public int getNumberOfN1(int[] arr, int target) {
		int first = binaryHelp1(arr, target);
		int second = binaryHelp1(arr, target+1);
		System.out.println();
		return (first == arr.length || arr[first]!=target) ? 0 : second-first;
	}
	
	public int getNumberOfN2(int[] arr, int target) {
		int first = binaryHelp2(arr, target-1);
		int second = binaryHelp2(arr, target);
		System.out.println();
		return (second == arr.length || arr[second]!=target) ? 0 : second-first;
	}
	
	// ʹ�ö��ַ�
	public int binaryHelp1(int[] arr, int target) {
		if(arr == null || arr.length==0) return -1;
		int left = 0, right = arr.length-1;
		
		// �ҵ�ֵ�����������
		while(left<right) {
			int mid = left + (right-left)/2;		// ������ż��ʱ��ȡ�м�ƫ��ģ�������Ҫleft+,�������������ѭ��
			if(target<=arr[mid]) right = mid;
			else left = mid+1;
		}
		return left;
	}
	
	// ʹ�ö��ַ�
	public int binaryHelp2(int[] arr, int target) {
		if(arr == null || arr.length==0) return -1;
		int left = 0, right = arr.length-1;
		
		// �ҵ�ֵ�����ұ߱�����
		while(left<right) {
			int mid = left + (right-left)/2 + 1;	// ������ż��ʱ��ȡ�м�ƫ�ҵģ�������Ҫright-,�������������ѭ��
			if(target<arr[mid]) right = mid-1;
			else left = mid;
		}
		return right;
	}	
}