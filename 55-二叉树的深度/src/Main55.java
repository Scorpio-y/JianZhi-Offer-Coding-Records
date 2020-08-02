class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main55{
	public static void main(String[] args) {
		Main55 test = new Main55();
		TreeNode tree = test.buildTree();
		int res = test.getTreeDepth(tree);
		System.out.println(res);
	}
	
	// 获取树的深度
	public int getTreeDepth(TreeNode tree) {
		if(tree == null) return 0;
		return Math.max(getTreeDepth(tree.left), getTreeDepth(tree.right)) + 1;
	}
	
	// 构建二叉树
	public TreeNode buildTree() {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.left.right.left = new TreeNode(7);
		tree.right.right = new TreeNode(6);
		return tree;
	}
}