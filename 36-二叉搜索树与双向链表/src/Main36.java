class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class Main36{
	TreeNode head = null;
	TreeNode pre = null;
	public static void main(String[] args) {
		Main36 test = new Main36();
		TreeNode tree = test.buildTree();
		TreeNode res = test.convertTreeToList(tree);
		test.printList(res);
	}
	
	public void printList(TreeNode list) {
		if(list == null) return;
		TreeNode pointer = list;
		while(pointer != null) {
			System.out.print(pointer.val + ", ");
			pointer = pointer.right;
		}
	}
	
	public TreeNode convertTreeToList(TreeNode tree) {
		inorder(tree);
		return head;
	}
	
	// 中序遍历
	private void inorder(TreeNode tree) {
		if(tree == null) return;
		inorder(tree.left);
		tree.left = pre;
		if(pre != null) {
			pre.right = tree;
		}
		pre = tree;
		if(head == null) {		// 找到头节点
			head = tree;
		}
		inorder(tree.right);
	}
	
	public TreeNode buildTree() {
		TreeNode ret = new TreeNode(10);
		ret.left = new TreeNode(6);
		ret.right = new TreeNode(14);
		ret.left.left = new TreeNode(4);
		ret.left.right = new TreeNode(8);
		ret.right.left = new TreeNode(12);
		ret.right.right = new TreeNode(16);
		return ret;
	}
}