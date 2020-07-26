class complexListNode{
	int val;
	complexListNode next;
	complexListNode sub;
	complexListNode(int val){
		this.val = val;
	}
}

public class Main35{
	public static void main(String[] args) {
		Main35 test = new Main35();
		complexListNode list = test.buildComplexList();
		test.printList(list);
		complexListNode res = test.cloneComplexList(list);
		test.printList(res);
	}
	
	public complexListNode cloneComplexList(complexListNode list) {
		copyNode(list);
		copyPointer(list);
		complexListNode res = splitList(list);
		return res;
	}
	
	// 分割链表
	private complexListNode splitList(complexListNode list) {
		complexListNode now = list;
		complexListNode res = list.next;
		complexListNode copy = res;
		
		while(copy.next!=null) {
			now.next = copy.next;
			now = now.next;
			copy.next = now.next;
			copy = copy.next;
		}
		now.next = null;
		copy.next = null;
		
		return res;
	}
	
	// 复制指针
	private void copyPointer(complexListNode list) {
		complexListNode now = list;
		while(now!=null) {
			now.next.sub = now.sub;
			now = now.next.next;
		}
	}
	
	// 复制节点
	private void copyNode(complexListNode list) {
		complexListNode now = list;
		while(now!=null) {
			complexListNode copy = new complexListNode(now.val);
			copy.next = now.next;
			now.next = copy;
			now = copy.next;
		}
	}
	
	// 构建复杂链表
	public complexListNode buildComplexList() {
		complexListNode node = new complexListNode(1);
		node.next = new complexListNode(2);
		node.next.next = new complexListNode(3);
		node.next.next.next = new complexListNode(4);
		node.next.next.next.next = new complexListNode(5);
		node.sub = node.next.next;
		node.next.sub = node.next.next.next.next;
		node.next.next.next.sub = node.next;
		return node;
	}
	
	// 打印链表
	private void printList(complexListNode list) {
		complexListNode now = list;
		while(now!=null) {
			System.out.print(now.val+", ");
			if(now.sub!=null) System.out.print(now.sub.val);
			System.out.println();
			now = now.next;
		}
		System.out.println();
	}
}