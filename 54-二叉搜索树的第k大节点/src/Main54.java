class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main54{
	private TreeNode res;
	private int k = 3;
	public static void main(String[] args) {
		Main54 test = new Main54();
		TreeNode tree = test.buildTree();
		test.getKthNode(tree);
		test.printRes();
	}
	
	// 中序遍历
	public void getKthNode(TreeNode tree) {
		if(tree==null) return;
		getKthNode(tree.left);
		k--;
		if(k==0) res = tree;
		getKthNode(tree.right);
	}
	
	// 构建二叉搜索树
	public TreeNode buildTree() {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(8);
		return tree;
	}
	
	public void printRes() {
		System.out.println(res.val);
	}
}