class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main27{
	public static void main(String[] args) {
		Main27 test = new Main27();
		TreeNode tree = test.buildTree();
		
		test.printPreOrder(tree);
		System.out.println();
		
		TreeNode res = test.getMirrorTree(tree);
		test.printPreOrder(res);
		System.out.println();
	}
	
	// ����һ�������������ض������ľ���
	public TreeNode getMirrorTree(TreeNode tree) {
		if(tree == null) return null;
		TreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		getMirrorTree(tree.left);
		getMirrorTree(tree.right);
		return tree;
	}
	
	private TreeNode buildTree() {
		TreeNode ret = new TreeNode(8);
		ret.left = new TreeNode(6);
		ret.right = new TreeNode(10);
		ret.left.left = new TreeNode(5);
		ret.left.right = new TreeNode(7);
		ret.right.left = new TreeNode(9);
		ret.right.right = new TreeNode(11);
		return ret;
	}
	
	// ǰ�����
	private void printPreOrder(TreeNode root) {
		if(root==null) return;
		System.out.print(root.val+", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
}