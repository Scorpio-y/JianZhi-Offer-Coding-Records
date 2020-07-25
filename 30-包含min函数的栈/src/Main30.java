import java.util.Stack;

public class Main30{
	public static void main(String[] args) throws Exception {
		myStack stack = new myStack();
		stack.push(2);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
	}
}

class myStack{
	
	Stack<Integer> data;
	Stack<Integer> mindata;
	
	myStack(){
		data = new Stack<>();
		mindata = new Stack<>();
	}
	
	void push(int value) {
		data.add(value);
		if(!mindata.isEmpty()) {
			if(value>mindata.peek()) {
				mindata.add(mindata.peek());
			}else {
				mindata.add(value);
			}
		}else {
			mindata.add(value);
		}
	}
	
	int pop() throws Exception {
		if(!data.isEmpty()) {
			mindata.pop();
			return data.pop();
		}
		throw new Exception("stack is empty!");
	}
	
	int min() throws Exception{
		if(!data.isEmpty()) {
			return mindata.peek();
		}
		throw new Exception("stack is empty!");
	}
	
}