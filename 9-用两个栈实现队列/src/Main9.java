import java.util.Stack;

public class Main9{
	public static void main(String[] args) throws Exception {
		myQueue queue = new myQueue();
		queue.add(3);
		queue.add(1);
		System.out.println(queue.delete());
		System.out.println(queue.delete());
		System.out.println(queue.delete());
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

// ������ջʵ�ֶ���