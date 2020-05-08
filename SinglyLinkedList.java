class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void addAtFirst(int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		newNode.next = temp;
		head = newNode;		
	}

	public void addAtLast(int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.next = null;
	}

	public void addAtGivenData(int newData, int preData) {
		Node newNode = new Node(newData);
		Node temp = head;
		if(temp.data == preData) {
			newNode.next = temp;
			head = newNode;
		}
		else {
			while(temp.next != null) {
				if(temp.next.data == preData) {
					newNode.next = temp.next;
					temp.next = newNode;
					break;
				}
				temp = temp.next;
				if(temp.next == null) {
					temp.next = newNode;
					newNode.next = null;
				}
			}
		}
	}

	public void addAtGivenIndex(int index, int newData) {
		Node newNode = new Node(newData);
		Node temp = head;
		for(int i=1; i<=index; i++) {
			if(i == index) {
				newNode.next = temp.next;
				temp.next = newNode;
			}
			temp = temp.next;
		}	 
	}

	// public void addAtGivenIndex(int index, int newData) {
	// 	Node newNode = new Node(newData);
	// 	Node temp = head;
	// 	int count = 1;
	// 	while(count != index) {
	// 		temp = temp.next;
	// 		count++;
	// 	}
	// 	newNode.next = temp.next;
	// 	temp.next = newNode;
	// }

	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();

		l.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		l.head.next = second;
		second.next = third;

		l.addAtFirst(0);
		l.addAtLast(6);

		l.addAtGivenIndex(4,4);

		l.addAtGivenData(5,7);

		l.printList();
	}
}