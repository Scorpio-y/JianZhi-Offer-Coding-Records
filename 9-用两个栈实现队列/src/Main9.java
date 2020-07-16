import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Main9{
	public static void main(String[] args) throws Exception {
		myQueue queue = new myQueue();
		queue.add(3);
		queue.add(1);
		System.out.println(queue.delete());
		System.out.println(queue.delete());
//		System.out.println(queue.delete());
		
		myStack stack = new myStack();
		stack.push(3);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
}

// ������ջʵ�ֶ���
class myQueue{
	Stack<Integer> stack1,stack2;
	
	// ���캯��
	myQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	// ���
	void add(int num) {
		stack1.push(num);
	}
	
	// ����
	int delete() throws Exception {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		if(stack2.isEmpty()) {
			throw new Exception("Queue is empty!");
		}
		
		return stack2.pop();
	}
}

// ����������ʵ��ջ
class myStack{
	Queue<Integer> queue1,queue2;
	
	//���캯��
	myStack(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	// ��ջ
	void push(int num) {
		if(!queue1.isEmpty()) {
			queue1.add(num);
		}else {
			queue2.add(num);
		}
	}
	
	// ��ջ
	int pop() throws Exception {
		if(queue1.isEmpty() && queue2.isEmpty()) {
			throw new Exception("Stack is empty!");
		}
		
		if(queue1.isEmpty()) {
			while(queue2.size()>1) {
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		
		if(queue2.isEmpty()) {
			while(queue1.size()>1) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return 0;
	}
}