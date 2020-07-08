public class ArrayStack {
	public static final int CAPACITY=10;
	protected int capacity;
	protected int top=-1;
	protected int[] stackRep;

	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int cap) {
		this.capacity = cap;
		this.stackRep = new int[capacity];
	}

	public int size() {
		return (top+1);
	}

	public boolean isEmpty() {
		return (top<0);
	}

	public void push(int data) throws Exception {
		if(size()==capacity) 
			throw new Exception("Stack Overflow");
		stackRep[++top] = data;
	}

	public int pop() throws Exception {
		if(isEmpty()) 
			throw new Exception("Stack Underflow");
		else {
			int data = stackRep[top--];
			return data;
		}
	}

	public int peek() throws Exception {
		if(isEmpty()) 
			throw new Exception("Stack Underflow");
		return stackRep[top];
	}

	public String toString() {
		String result="[";
		if(size()>0)
			result += stackRep[0];
		if(size()>1) {
			for(int i=1; i<size(); i++) {
				result += ", " + stackRep[i];
			}
		}
		return result+"]";
	}

	public static void main(String[] args) throws Exception {
		ArrayStack as = new ArrayStack();
		as.push(10);
		as.push(20);
		as.push(30);

		// as.pop();

		System.out.println(as.peek());

		System.out.println(as);
	}
}
