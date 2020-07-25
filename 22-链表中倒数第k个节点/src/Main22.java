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
			System.out.println("输入的k不符合范围！！！");
	}
	
	public ListNode findKthToTail(ListNode head, int k) {
		// 这里k=0时认为没有意义！
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