import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}

public class Main52{
	public static void main(String[] args) throws Exception {
		Main52 test = new Main52();
		ListNode[] list = test.buildList();
		ListNode list1 = list[0];
		ListNode list2 = list[1];
		test.printList(list1);
		test.printList(list2);
		
		ListNode res = test.findFirstCommonNode1(list1, list2);
		System.out.println("方法一：第一个公共节点的值："+res.val);
		res = test.findFirstCommonNode2(list1, list2);
		System.out.println("方法二：第一个公共节点的值："+res.val);
		res = test.findFirstCommonNode3(list1, list2);
		System.out.println("方法三：第一个公共节点的值："+res.val);
	}
	
	// 方法一，从链表尾部开始比较，使用栈结构
	public ListNode findFirstCommonNode1(ListNode list1, ListNode list2) throws Exception {
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		
		while(list1!=null) {
			stack1.add(list1);
			list1 = list1.next;
		}
		
		while(list2!=null) {
			stack2.add(list2);
			list2 = list2.next;
		}
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			ListNode node1 = stack1.pop();
			ListNode node2 = stack2.pop();
			if(node1 == node2) continue;
			else return node1.next;
		}
		throw new Exception("两链表没有公共节点！");
	}
	
	// 方法二，更简单，先得到两链表的长度差，然后较长链表向前进几个之后，两链表再开始从头比较
	public ListNode findFirstCommonNode2(ListNode list1, ListNode list2) throws Exception {
		int len1 = 0, len2 = 0;
		ListNode ptr1 = list1, ptr2 = list2;
		while(ptr1!=null) {
			len1++;
			ptr1 = ptr1.next;
		}
		while(ptr2!=null) {
			len2++;
			ptr2 = ptr2.next;
		}
		
		if(len1==0 || len2==0) throw new Exception("两链表没有公共节点！");
		
		int difference = Math.abs(len1-len2);
		if(len1>len2) {
			while(difference>0) {
				list1 = list1.next;
				difference--;
			}
		}else {
			while(difference>0) {
				list2 = list2.next;
				difference--;
			}
		}
		
		while(list1 != null && list2!=null) {
			if(list1 == list2) return list1;
			list1 = list1.next;
			list2 = list2.next;
		}
		throw new Exception("两链表没有公共节点！");
	}
	
	// 方法三、很神奇，分别从两个链表的头部同时向后走，走到尾部后接着另一个链表的头部继续走，直到两个指针指向的节点相同
	public ListNode findFirstCommonNode3(ListNode list1, ListNode list2) throws Exception {
		ListNode ptr1 = list1;
		ListNode ptr2 = list2;
		while(ptr1!=null && ptr2!=null) {
			boolean flag1 = true, flag2 = true;
			if(ptr1 == ptr2) return ptr1;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			if(ptr1 == null && flag1 == true) {
				ptr1 = list2;
				flag1 = !flag1;
			}
			if(ptr2 == null && flag2 == true) {
				ptr2 = list1;
				flag2 = !flag2;
			}
		}
		throw new Exception("两链表没有公共节点！");
	}
	
	public ListNode[] buildList() {
		ListNode head1 = new ListNode(1);
		ListNode pointer = head1;
		pointer.next = new ListNode(2);
		pointer = pointer.next;
		pointer.next = new ListNode(3);
		pointer = pointer.next;
		pointer.next = new ListNode(6);
		pointer = pointer.next;
		pointer.next = new ListNode(7);
		
		ListNode head2 = new ListNode(3);
		head2.next = new ListNode(5);
		head2.next.next = pointer;
		return new ListNode[] {head1,head2};
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