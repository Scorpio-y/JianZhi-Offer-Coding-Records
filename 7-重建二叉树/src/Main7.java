import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

// 给定二叉树的前序和中序排列，还原二叉树

// 二叉树结构定义
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	// 构造函数
	TreeNode(int x){
		val = x;
	}
}

public class Main7{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			// 读取二叉树的元素个数，以及前序和中序排列，存入数组
			int len = sc.nextInt();
			int[] preorder = new int[len], inorder = new int[len];
			for(int i=0;i<len;i++) {
				preorder[i] = sc.nextInt();
			}
			for(int i=0;i<len;i++) {
				inorder[i] = sc.nextInt();
			}
			
			//递归还原二叉树
			TreeNode res = reConstructBinaryTree(preorder, inorder);
			
			// 前序遍历二叉树
			printPreOrder(res);
			System.out.println();
			
			// 中序遍历二叉树
			printInOrder(res);
			System.out.println();
			
			// 后序遍历二叉树
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
		int leftTreeSize = idx-inL;		// inL用来确定数的长度
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