// 定义二叉树
class TreeNode{
	char val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(char x){
		val = x;
	}
}


// 给定一棵二叉树和其中的一个节点，找出中序遍历的下一个节点
public class Main8{
	private static TreeNode tree;	// 全局变量
	public static void main(String[] args) {
		// 构造一个二叉树
		tree = constructTree();
		// 中序遍历
		printInOrder(tree);
		System.out.println();
		
		TreeNode node = tree.right.left;
		TreeNode res = findNextNode(node);
		if(res!=null) {
			System.out.println(res.val);
		}
	}
	
	private static TreeNode findNextNode(TreeNode node) {
		// 如果节点右子树不为空，则下一个节点是右子树的最左节点
		if(node.right!=null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		}else {		// 如果没有右子树，就往上找，如果父节点的左子节点是我，那么父节点就是下一个节点
			while(node.parent!=null) {
				TreeNode parent = node.parent;
				if(parent.left==node)
					return parent;
				node = parent;
			}
			return null;
		}
	}
	// 构造一棵《剑指Offer》里图2.8所示的树
	private static TreeNode constructTree() {
		TreeNode root = new TreeNode('a');
		TreeNode tmp = root;
		tmp.left = new TreeNode('b');
		tmp.left.parent = tmp;
		tmp = tmp.left;
		tmp.left = new TreeNode('d');
		tmp.left.parent = tmp;
		tmp.right = new TreeNode('e');
		tmp.right.parent = tmp;
		tmp = tmp.right;
		tmp.left = new TreeNode('h');
		tmp.left.parent = tmp;
		tmp.right = new TreeNode('i');
		tmp.right.parent = tmp;
		tmp = root;
		tmp.right = new TreeNode('c');
		tmp.right.parent = tmp;
		tmp = tmp.right;
		tmp.left = new TreeNode('f');
		tmp.left.parent = tmp;
		tmp.right = new TreeNode('g');
		tmp.right.parent = tmp;
		return root;
	}
	
	private static void printInOrder(TreeNode tree) {
		if(tree==null) return;
		printInOrder(tree.left);
		System.out.print(tree.val+" ");
		printInOrder(tree.right);
	}
}