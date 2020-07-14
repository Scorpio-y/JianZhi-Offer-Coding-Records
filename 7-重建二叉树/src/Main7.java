import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// ������������ǰ����������У���ԭ������

// �������ṹ����
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	// ���캯��
	TreeNode(int x){
		val = x;
	}
}

public class Main7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			// ��ȡ��������Ԫ�ظ������Լ�ǰ����������У���������
			int len = sc.nextInt();
			int[] preorder = new int[len], inorder = new int[len];
			for(int i=0;i<len;i++) {
				preorder[i] = sc.nextInt();
			}
			for(int i=0;i<len;i++) {
				inorder[i] = sc.nextInt();
			}
			
			//�ݹ黹ԭ������
			TreeNode res = reConstructBinaryTree(preorder, inorder);
			
			// ǰ�����������
			printPreOrder(res);
			System.out.println();
			
			// �������������
			printInOrder(res);
			System.out.println();
			
			// �������������
			printPostOrder(res);
			System.out.println();
		}
	}
	
	private static Map<Integer, Integer> index = new HashMap<>();
	private static TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
		for(int i=0;i<inorder.length;i++) {
			index.put(inorder[i], i);
		}
		return reConstructBinaryTree(preorder, 0, inorder.length-1, 0);
	}
	
	
	private static TreeNode reConstructBinaryTree(int[] preorder, int preL, int preR, int inL) {
		if(preL>preR) return null;
		TreeNode root = new TreeNode(preorder[preL]);
		int idx = index.get(root.val);
		int leftTreeSize = idx-inL;		// inL����ȷ�����ĳ���
		root.left = reConstructBinaryTree(preorder, preL+1, preL+leftTreeSize, inL);
		root.right = reConstructBinaryTree(preorder, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
		return root;
	}
	
	private static void printPreOrder(TreeNode tree) {
		if(tree!=null) System.out.print(tree.val);
		else return;
		printPreOrder(tree.left);
		printPreOrder(tree.right);
	}
	
	private static void printInOrder(TreeNode tree) {
		if(tree==null) return;
		printInOrder(tree.left);
		System.out.print(tree.val);
		printInOrder(tree.right);
	}
	
	private static void printPostOrder(TreeNode tree) {
		if(tree==null) return;
		printPostOrder(tree.left);
		printPostOrder(tree.right);
		System.out.print(tree.val);
	}
}