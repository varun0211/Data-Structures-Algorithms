class Node {
	private int data;
	private Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
}

class LinkedList {
	static Node head;

	public void append(int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		if(temp == null) 
			head = newNode;
		else {
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setNext(null);
		}
	}

	public void insert(int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		if(temp == null)
			head = newNode;
		else {
			newNode.setNext(temp);
			head = newNode;
		}
	}
// To be corrected replace()
	public void replace(int data, int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		while(temp != null) {
			if(temp.getData() == data) {
				temp.setData(newData);
				break;
			}
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		newNode.setNext(null);
	}

	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		head.setNext(second);
		second.setNext(third);

		l.append(4);
		l.insert(0);
		l.append(5);
		l.replace(1,6);

		l.printList();
	}
}