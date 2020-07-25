class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
}

public class Main23{
	public static void main(String[] args) {
		Main23 test = new Main23();
		ListNode head = test.buildList();
		ListNode res = test.entryNodeOfLoop(head);
		if(res!=null)
			System.out.println(res.val);
		else
			System.out.println("链表中没有环！");
	}
	
	// 找到环的入口节点
	public ListNode entryNodeOfLoop(ListNode head) {
		if(head==null) return null;
		ListNode node = head;
		boolean hasLoop = hasLoop(node);	// 判断有没有环
		if(hasLoop) {
			int num = nodeOfLoop(node);		// 计算环中节点的个数
			return findEntry(node, num);	// 返回环的入口节点
		}else {
			return null;
		}
		
	}
	
	// 给定环中节点的个数，返回环的入口节点
	private ListNode findEntry(ListNode head, int num) {
		ListNode left = head, right = head;
		for(int i=0;i<num;i++) {
			right = right.next;
		}
		while(left!=right) {
			left = left.next;
			right = right.next;
		}
		return left;
	}
	
	// 判断链表中有没有环
	private boolean hasLoop(ListNode head) {
		ListNode left = head, right = left.next;
		while(right!=null) {
			left = left.next;
			if(right.next!=null && right.next.next!=null) {
				right = right.next.next;
			}else {
				return false;
			}
			if(left==right) break;
		}
		return true;
	}
	
	// 计算环中节点的个数
	private int nodeOfLoop(ListNode head) {
		ListNode left = head, right = left.next;
		int count = 1;
		while(right!=null) {
			left = left.next;
			right = right.next.next;
			if(left==right) break;
		}
		right = right.next;
		while(left!=right) {
			right = right.next;
			count++;
		}
		return count;
	}
	
	// 构建有环链表，链表见《剑指offer》第139页
	private ListNode buildList() {
		ListNode head = new ListNode(1);
		ListNode root = head;
		for(int i=2;i<=6;i++) {
			root.next = new ListNode(i);
			root = root.next;
		}
		root.next = head.next.next;
		return head;
	}
	
}