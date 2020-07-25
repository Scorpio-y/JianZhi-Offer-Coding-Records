class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}

public class Main24{
	public static void main(String[] args) {
		Main24 test = new Main24();
		ListNode head = test.buildList();
		test.printList(head);
		ListNode res = test.reverseList(head);
		test.printList(res);
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode left = null, now = head, right = head.next;
		while(now!=null) {
			right = now.next;
			now.next = left;
			left = now;
			now = right;
		}
		return left;
	}
	
	// 构建链表
	private ListNode buildList() {
		ListNode head = new ListNode(1);
		ListNode root = head;
		for(int i=2;i<=10;i++) {
			root.next = new ListNode(i);
			root = root.next;
		}
		return head;
	}
	
	// 打印链表
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