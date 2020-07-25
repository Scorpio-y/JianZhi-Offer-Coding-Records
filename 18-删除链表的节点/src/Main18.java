class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}

public class Main18{
	
	public static void main(String[] args) {
		Main18 test = new Main18();
		ListNode head = test.buildList();
		test.printList(head);
		ListNode tobedeletednode = head.next;
		test.deleteNode(head, tobedeletednode);
		test.printList(head);
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
	
	// ɾ������ڵ�
	private void deleteNode(ListNode head, ListNode node) {
		if(head==null || node==null) return;
		if(node.next!=null) {	// ��ɾ���Ĳ������һ���ڵ�
			ListNode tmp = node.next;
			node.val = tmp.val;
			node.next = tmp.next;
			tmp.next = null;
		}else {
			if(node==head) {	// ֻ��һ���ڵ�
				head = null;
			}else {
				ListNode tmp = head;
				while(tmp.next!=node) {
					tmp = tmp.next;
				}
				tmp.next=null;
			}
		}
	}
	
	
}