// ���������
class TreeNode{
	char val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(char x){
		val = x;
	}
}


// ����һ�ö����������е�һ���ڵ㣬�ҳ������������һ���ڵ�
public class Main8{
	private static TreeNode tree;	// ȫ�ֱ���
	public static void main(String[] args) {
		// ����һ��������
		tree = constructTree();
		// �������
		printInOrder(tree);
		System.out.println();
		
		TreeNode node = tree.right.left;
		TreeNode res = findNextNode(node);
		if(res!=null) {
			System.out.println(res.val);
		}
	}
	
	private static TreeNode findNextNode(TreeNode node) {
		// ����ڵ���������Ϊ�գ�����һ���ڵ���������������ڵ�
		if(node.right!=null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node;
		}else {		// ���û�����������������ң�������ڵ�����ӽڵ����ң���ô���ڵ������һ���ڵ�
			while(node.parent!=null) {
				TreeNode parent = node.parent;
				if(parent.left==node)
					return parent;
				node = parent;
			}
			return null;
		}
	}
	// ����һ�á���ָOffer����ͼ2.8��ʾ����
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