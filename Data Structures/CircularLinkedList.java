/**
Circular Linked List(CLL):

1. Circular linked list is a linked list where all nodes are connected to form a circle.
2. In SLL & DLL, the end of the list are indicated with NULL value. But CLL don't have ends. 
while traversing the CLL we should be careful, otherwise we will be traversing the list infinitely.
3. A circular linked list can be a singly circular linked list or doubly circular linked list.

Advantages of CLL:
1. Any node can be a starting point. We can traverse the whole list by starting from any point. 
We just need to stop when the first visited node is visited again. 
2. Useful for implementation of queue. we don’t need to maintain two pointers for front and rear 
if we use circular linked list. We can maintain a pointer to the last inserted node and front can always be obtained as next of last.
3. Circular Doubly Linked Lists are used for implementation of advanced data structures like Fibonacci Heap.
*/

class LinkedList {
	Node tail;
	private int length;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		public String toString() {
			return Integer.toString(data);
		}
	}

	public void insertAtBegin(int newData) {
		Node newNode = new Node(newData);
		if(tail==null) {
			tail = newNode;
			tail.next = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		length++;
	}

	public void insertAtEnd(int newData) {
		Node newNode = new Node(newData);
		if(tail==null) {
			tail = newNode;
			tail.next = tail;
		} else {
			Node temp = tail;
			newNode.next = temp.next;
			temp.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public void insertAtMiddle(int newData, int position) {
		if(position<0)
			position=0;
		if(position>=length) 
			position=length;
		Node newNode = new Node(newData);
		if(tail==null) {
			tail = newNode;
			tail.next = tail;
		}
		if(position==0) {
			newNode.next = tail.next;
			tail.next = newNode;
		} else if(position>=length) {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		} else {
			Node temp = tail.next;
			for(int i=1; i<position; i++) { 
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length++;
	}

	public void removeAtBegin() {
		if(tail==null) {
			return;
		} else if(tail==tail.next) {
			tail = null;
			length--;
			return;
		} else {
			tail.next = tail.next.next;
			length--;
		}
	}

	public void removeAtEnd() {
		if(tail==null) 
			return;
		Node temp = tail;
		while(temp.next!=tail)
			temp = temp.next;
		temp.next = tail.next;
		tail.next = null;
		tail = temp;
		length--;
	}

	public void removeAtMiddle(int position) {
		if(position<0)
			position=0;
		if(position>=length)
			position=length-1;
		if(tail==null) 
			return;
		Node temp = tail.next;
		if(position==0) {
			tail.next = temp.next;
			temp.next=null;
			length--;
		} else {
			for(int i=1; i<position; i++) 
				temp = temp.next;
			temp.next = temp.next.next;
			length--;
		}
	}

	public String toString() {
		String result="[";
		if(tail==null || length==0) 
			return "List is empty";
		result = result + tail.next.data;
		Node temp = tail.next.next;
		while(temp!=tail.next) {
			result = result + ", " + temp.data;
			temp = temp.next;
		}
		return result + "]";
	}

	public int length() {
		return length;
	}

	// public void printList() {
	// 	Node temp = tail.next;
	// 	do {
	// 		System.out.print(temp.data+" ");
	// 		temp = temp.next;
	// 	}
	// 	while(temp!=tail.next);
	// }

	public static void main(String[] args) {
		LinkedList l = new LinkedList();

		l.insertAtBegin(1);
		l.insertAtBegin(0);
		l.insertAtEnd(3);
		l.insertAtEnd(99);
		l.insertAtMiddle(2,2);
		l.insertAtMiddle(10,3);

		// l.printList();
		System.out.println(l); // [0, 1, 2, 10, 3, 99]
		System.out.println("LinkedList Length: "+l.length()); // LinkedList Length: 6

		l.removeAtBegin(); // 0
		l.removeAtEnd(); // 99
		l.removeAtMiddle(2); // 10

		System.out.println(l); // [1, 2, 3]
		System.out.println("LinkedList Length: "+l.length()); // LinkedList Length: 3
	}
}