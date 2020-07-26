import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main32{
	public static void main(String[] args) {
		Main32 test = new Main32();
		TreeNode tree = test.buildTree();
		ArrayList<Integer> res1 = test.printFromTopToBottom1(tree);
		test.printList1(res1);
		ArrayList<ArrayList<Integer>> res2 = test.printFromTopToBottom2(tree);
		test.printList2(res2);
	}
	
	private ArrayList<Integer> printFromTopToBottom1(TreeNode tree) {
		if(tree==null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> res = new ArrayList<>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if(tmp==null) continue;
			queue.add(tmp.left);
			queue.add(tmp.right);
			res.add(tmp.val);
		}
		return res;
	}
	
	private ArrayList<ArrayList<Integer>> printFromTopToBottom2(TreeNode tree) {
		if(tree==null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		queue.add(tree);
		while(!queue.isEmpty()) {
			int count = queue.size();
			ArrayList<Integer> r = new ArrayList<>();
			while(count>0) {
				count--;
				TreeNode tmp = queue.poll();
				if(tmp==null) continue;
				queue.add(tmp.left);
				queue.add(tmp.right);
				r.add(tmp.val);
			}
			if(r.size()!=0) res.add(r);
		}
		return res;
	}
	
	private void printList1(ArrayList<Integer> list) {
		if(list==null) return;
		System.out.println(list);
	}
	
	private void printList2(ArrayList<ArrayList<Integer>> list) {
		if(list==null) return;
		System.out.println(list);
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
}