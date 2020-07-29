class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class Main37{
	private String remainStr;
	public static void main(String[] args) {
		Main37 test = new Main37();
		TreeNode tree = test.buildTree();
		test.printPreorder(tree);
		System.out.println();
		test.printInorder(tree);
		System.out.println();
		test.printPostorder(tree);
		System.out.println();
		
		String str = test.serializeTree(tree);
		System.out.println(str);
		
		test.remainStr = str;
		TreeNode res = test.deserializeTree();
		
		test.printPreorder(res);
		System.out.println();
		test.printInorder(res);
		System.out.println();
		test.printPostorder(res);
		System.out.println();
	}
	
	// 反序列化得到二叉树
	public TreeNode deserializeTree() {
		if(remainStr==null || remainStr.length()==0) return null;
		int idx = remainStr.indexOf(",");
		String node = idx==-1?remainStr:remainStr.substring(0, idx);
		remainStr = idx==-1?"":remainStr.substring(idx+1);
		
		if(node.equals("#")) return null;
		TreeNode res = new TreeNode(Integer.parseInt(node));
		res.left = deserializeTree();
		res.right = deserializeTree();
		return res;
	}
	
	// 按前序遍历顺序序列化二叉树
	public String serializeTree(TreeNode tree) {
		if(tree == null) return "#";
		return tree.val+","+serializeTree(tree.left)+","+serializeTree(tree.right);
	}
	
	public TreeNode buildTree() {
		TreeNode ret = new TreeNode(1);
		ret.left = new TreeNode(2);
		ret.right = new TreeNode(3);
		ret.left.left = new TreeNode(4);
		ret.right.left = new TreeNode(5);
		ret.right.right = new TreeNode(6);
		return ret;
	}
	
	// 练习一下
	// 前序遍历打印
	public void printPreorder(TreeNode tree) {
		if(tree == null) return;
		System.out.print(tree.val+", ");
		printPreorder(tree.left);
		printPreorder(tree.right);
	}
	
	// 中序遍历打印
	public void printInorder(TreeNode tree) {
		if(tree == null) return;
		printInorder(tree.left);
		System.out.print(tree.val+", ");
		printInorder(tree.right);
	}
	
	// 后序遍历打印
	public void printPostorder(TreeNode tree) {
		if(tree == null) return;
		printPostorder(tree.left);
		printPostorder(tree.right);
		System.out.print(tree.val+", ");
	}
}