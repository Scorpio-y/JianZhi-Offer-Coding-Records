class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}

public class Main22{
	
	public static void main(String[] args) {
		Main22 test = new Main22();
		ListNode head = test.buildList();
		test.printList(head);
		int k = 1;
		ListNode res = test.findKthToTail(head, k);
		if(res!=null)
			System.out.println(res.val);
		else
			System.out.println("�����k�����Ϸ�Χ������");
	}
	
	public ListNode findKthToTail(ListNode head, int k) {
		// ����k=0ʱ��Ϊû�����壡
		if(k<=0 || head==null) return null;
		ListNode left = head, right = head;
		for(int i=0;i<k;i++) {
			if(right==null) return null;
			right = right.next;
		}
		while(right!=null) {
			left = left.next;
			right = right.next;
		}
		return left;
	}
	
	// ��������
	private ListNode buildList() {
		ListNode head = new ListNode(1);
		ListNode root = head;
		for(int i=2;i<=10;i++) {
			root.next = new ListNode(i);
			root = root.next;
		}
		return head;
	}
	
	// ��ӡ����
	private void printList(ListNode head) {
		ListNode list = head;
		if(list==null) return;
		System.out.print(list.val);
		list = list.next;
		while(list!=null) {
			System.out.print(", "+list.val);
			list = list.next;
		}
		System.out.println();
	}
}