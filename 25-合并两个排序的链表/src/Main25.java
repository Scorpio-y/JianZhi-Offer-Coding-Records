class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}

public class Main25{
	public static void main(String[] args) {
		Main25 test = new Main25();
		ListNode list1 = test.buildList(1,2,7);
		ListNode list2 = test.buildList(2,2,8);
		
		System.out.print("list1 = ");
		test.printList(list1);
		System.out.print("list2 = ");
		test.printList(list2);
		
		ListNode res = test.mergeList(list1, list2);
		System.out.print("merged list = ");
		test.printList(res);
	}
	
	// 合并链表，递归
	public ListNode mergeList(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		else if(list2 == null) return list1;
		ListNode mergedList = null;
		if(list1.val<list2.val) {
			mergedList = list1;
			mergedList.next = mergeList(list1.next, list2);
		}else {
			mergedList = list2;
			mergedList.next = mergeList(list1, list2.next);
		}
		return mergedList;
	}
	
	// 构建链表
	private ListNode buildList(int start, int gap, int end) {
		ListNode head = new ListNode(start);
		ListNode root = head;
		for(int i=start+gap;i<=end;i+=gap) {
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