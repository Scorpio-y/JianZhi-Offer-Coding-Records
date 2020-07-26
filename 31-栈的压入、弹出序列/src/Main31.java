import java.util.Stack;

public class Main31{
	public static void main(String[] args) {
		int[] input = new int[] {1,2,3,4,5};
		int[] output = new int[] {4,5,3,2,1};
		Main31 test = new Main31();
		boolean res = test.isPopOrder(input, output);
		System.out.println(res);
	}
	
	public boolean isPopOrder(int[] input, int[] output) {
		int len = input.length;
		Stack<Integer> stack = new Stack<>();
		for(int putidx = 0, popidx = 0; putidx<len; putidx++) {
			stack.push(input[putidx]);
			while(popidx<len && stack.peek()==output[popidx]) {
				stack.pop();
				popidx++;
			}
		}
		return stack.isEmpty();
	}
}