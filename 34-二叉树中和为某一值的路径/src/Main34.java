import java.util.ArrayList;

class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int val){
		this.val = val;
	}
}

public class Main34{
	
	private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public static void main(String[] args) {
		Main34 test = new Main34();
		TreeNode tree = test.buildTree();
		int target = 22;
		test.res = test.findPath(tree, target);
		System.out.println(test.res);
	}
	
	public ArrayList<ArrayList<Integer>> findPath(TreeNode tree, int target){
		if(tree==null) return null;
		backtracking(tree, target, new ArrayList<Integer>());
		return res;
	}
	
	private void backtracking(TreeNode tree, int target, ArrayList<Integer> path) {
		if(tree==null) return;
		path.add(tree.val);
		target -= tree.val;
		if(target==0 && tree.left==null && tree.right==null) {
			res.add((ArrayList<Integer>) path.clone());
		}else {
			backtracking(tree.left, target, path);
			backtracking(tree.right, target, path);
		}
		path.remove(path.size()-1);
	}
	
	private TreeNode buildTree() {
		TreeNode ret = new TreeNode(10);
		ret.left = new TreeNode(5);
		ret.right = new TreeNode(12);
		ret.left.left = new TreeNode(4);
		ret.left.right = new TreeNode(7);
		return ret;
	}
}