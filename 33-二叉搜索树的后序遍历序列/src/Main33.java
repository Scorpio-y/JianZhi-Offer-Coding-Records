public class Main33{
	public static void main(String[] args) {
		int[] input = new int[] {5,7,6,9,11,10,8};
//		int[] input = new int[] {7,4,6,5};
		Main33 test = new Main33();
		boolean res = test.verifySequenceOfBST(input, 0, input.length-1);
		System.out.println(res);
	}
	
	// �ж�����������ܷ񹹽��ɶ���������
	private boolean verifySequenceOfBST(int[] input, int start, int end) {
		if(input==null || input.length==0) return false;
		
		// ���ڵ��ֵ
		int root = input[end];
		int i = 0;
		for(;i<end;i++) {
			if(input[i]>root) break;
		}
		
		int j = i;
		for(;j<end;j++) {
			if(input[j]<root) return false;
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean left = true;	// �ֲ�������Ҫ��ʼ��
		if(i>0) {
			left = verifySequenceOfBST(input, 0, i-1);
		}
		
		// �ж��������ǲ��Ƕ���������
		boolean right = true;
		if(i<end) {
			right = verifySequenceOfBST(input, i, end-1);
		}
		
		return (left&&right);
		
	}
}