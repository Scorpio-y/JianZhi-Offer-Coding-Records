class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main26{
	public static void main(String[] args) {
		Main26 test = new Main26();
		TreeNode A = test.buildTree1();
		TreeNode B = test.buildTree2();
		
		test.printPreOrder(A);
		System.out.println();
		test.printPreOrder(B);
		System.out.println();
		
		System.out.println(test.hasSubTree(A, B));
	}
	
	public boolean hasSubTree(TreeNode A, TreeNode B) {
		boolean res = false;
		if(A != null && B != null) {
			if(A.val == B.val) {
				res = doesAHaveB(A, B);		// 找到与B的根节点相同的点，然后再开始判断
			}
			if(!res) {
				res = hasSubTree(A.left, B);
			}
			if(!res) {
				res = hasSubTree(A.right, B);
			}
		}
		return res;
	}
	
	private boolean doesAHaveB(TreeNode A, TreeNode B) {
		if(B == null) return true;
		if(A == null) return false;
		if(A.val != B.val) return false;
		return doesAHaveB(A.left, B.left) && doesAHaveB(A.right, B.right);
	}
	
	private TreeNode buildTree1() {
		TreeNode ret = new TreeNode(8);
		ret.right = new TreeNode(7);
		ret.left = new TreeNode(8);
		ret.left.left = new TreeNode(9);
		ret.left.right = new TreeNode(2);
		ret.left.right.left = new TreeNode(4);
		ret.left.right.right = new TreeNode(7);
		return ret;
	}
	
	private TreeNode buildTree2() {
		TreeNode ret = new TreeNode(8);
		ret.left = new TreeNode(9);
		ret.right = new TreeNode(2);
		return ret;
	}
	
	// 前序遍历
	private void printPreOrder(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val+", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}