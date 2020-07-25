class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main28{
	public static void main(String[] args) {
		Main28 test = new Main28();
		TreeNode tree = test.buildTree1();
		test.printPreOrder(tree);
		System.out.println();
		boolean res = test.isMirrorTree(tree, tree);
		System.out.println(res);
	}
	
	public boolean isMirrorTree(TreeNode tree1, TreeNode tree2) {
		if(tree1==null && tree2==null) return true;
		if(tree1==null || tree2==null) return false;
		if(tree1.val!=tree2.val) return false;
		return isMirrorTree(tree1.left, tree2.right) && isMirrorTree(tree1.right, tree2.left);
	}
	
	private TreeNode buildTree1() {
		TreeNode ret = new TreeNode(8);
		ret.left = new TreeNode(6);
		ret.right = new TreeNode(6);
		ret.left.left = new TreeNode(5);
		ret.left.right = new TreeNode(7);
		ret.right.left = new TreeNode(7);
		ret.right.right = new TreeNode(5);
		return ret;
	}

	
	// Ç°Ðò±éÀú
	private void printPreOrder(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val+", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}