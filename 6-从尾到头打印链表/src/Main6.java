import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x) { val = x; }  // ���캯��
}

public class Main6{
	public static void main(String[] args) {
		
		// �������������һ������
		ListNode input = new ListNode(0);
		ListNode now = input;
		for (int i=1;i<10;i++) {
			now.next = new ListNode(i);
			now = now.next;
		}
		
		// ��ӡ��ת������ʹ��ջ�ṹ
		PrintListReversingly1(input);
		
		// ʹ�õݹ�
		PrintListReversingly2(input);
		System.out.println();
		
		// ֱ���޸�ԭʼ����ṹ��ԭ�ط�תָ��
		PrintListReversingly3(input);
		
	}
	
	public static void PrintListReversingly1(ListNode input) {
		ListNode now = input;
		Stack<Integer> stack = new Stack<>();
		while(now!=null) {
			stack.push(now.val);
			now = now.next;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+", ");
		}
		System.out.println();
	}
	
	public static void PrintListReversingly2(ListNode input) {
		if(input != null) {
			if(input.next != null) {
				PrintListReversingly2(input.next);
			}
		}
		System.out.print(input.val+", ");
	}
	
	public static void PrintListReversingly3(ListNode input) {
		if(input != null ) {
			if(input.next == null) System.out.print(input.val);
			else {
				ListNode left = null, mid = input, right;
				while(mid != null) {
					right = mid.next;
					mid.next = left;
					left = mid;
					mid = right;
				}
				// ��ӡ����
				while(left != null) {
					System.out.print(left.val+", ");
					left = left.next;
				}
				System.out.println();
			}
		}
		
	}
}
