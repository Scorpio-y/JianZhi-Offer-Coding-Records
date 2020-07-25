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
			System.out.println("������û�л���");
	}
	
	// �ҵ�������ڽڵ�
	public ListNode entryNodeOfLoop(ListNode head) {
		if(head==null) return null;
		ListNode node = head;
		boolean hasLoop = hasLoop(node);	// �ж���û�л�
		if(hasLoop) {
			int num = nodeOfLoop(node);		// ���㻷�нڵ�ĸ���
			return findEntry(node, num);	// ���ػ�����ڽڵ�
		}else {
			return null;
		}
		
	}
	
	// �������нڵ�ĸ��������ػ�����ڽڵ�
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
	
	// �ж���������û�л�
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
	
	// ���㻷�нڵ�ĸ���
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
	
	// �����л��������������ָoffer����139ҳ
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