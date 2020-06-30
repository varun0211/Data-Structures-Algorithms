// Doubly Linked List(DLL):

// 1. DLL is a Linear data structure.
// 2. DLL is same as SLL with extra pointer, which is used to point previous node. hence DLL contains 3 fields(prev, data, next).

// Advantage over SLL:
// 1. DLL can traverse in both the direction i.e, forward and backward direction whereas in SLL forward is only possible.
// 2. Deletion operation is more efficient i.e, while deleting the node, pointer to its previous node is not required whereas in SLL pointer to its previous node is required.

// Disadvantages of DLL:
// 1. Each node requires an extra pointer.
// 2. The insertion or deletion of a node takes a bit longer(more pointer operation).

class LinkedList {
	Node head;
	Node tail;
	private int length;

	static class Node {
		private int data;
		private Node next;
		private Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

		Node(int data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		public String toString() {
			return data+"";
		}
	}

	LinkedList() {
		length=1;
	}

	public void insertAtBegin(int newData) {
		Node newNode = new Node(newData);
		if(head==null)
			head = newNode;
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		length++;
		// Node temp = head;
		// if(head==null)
		// 	head = new Node(newData);
		// else {
		// 	head = new Node(newData, null, temp);
		// 	head.next.prev = head;
		// }
	}

	public void insertAtEnd(int newData) {
		tail = new Node(newData);
		if(head==null) 
			head = tail;
		else {
			Node temp=head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next = tail;
			tail.prev = temp;
		}
		length++;
	}

	public void insertAtMiddle(int newData, int position) {
		if(position<0)
			position=0;
		if(position>length)
			position=length;
		Node newNode = new Node(newData);
		if(head==null)
			head = newNode;
		else if(position==0) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else {
			Node temp=head;
			for(int i=1; i<position; i++) {
				temp=temp.next;
			}
			newNode.next = temp.next;
			temp.next.prev = newNode;
			newNode.prev = temp;
			temp.next = newNode;
		}
		length++;
	}

	public void removeAtBegin() {
		if(head==null) 
			return;
		if(head.next==null) {
			head=null;
			length--;
			return;
		}
		Node temp = head;
		head = temp.next;
		head.prev = null;
		temp.next = null;
		length--;
	}

	public void removeAtEnd() {
		if(head==null)
			return;
		if(head.next==null) {
			head=null;
			length--;
			return;
		}
		Node temp = tail;
		tail = tail.prev;
		tail.next = null;
		temp.next = null;
		length--;
	}

	public void removeAtMiddle(int position) {
		if(position<0) 
			position=0;
		if(position>=length)
			position=length-1;
		if(position==0) {
			head = head.next;
			if(head==null)
				tail=null;
		}
		else {
			Node temp = head;
			for(int i=0; i<position; i++) {
				if(temp.next.next==null) {
					tail = temp;
					tail.next = null;
					length--;
					return;
				}
				temp = temp.next;
			}
			temp.next.prev = temp.prev;
			temp.prev.next = temp.next; 
		}
		length--;
	}

	public String reversePrint() {
		String result="[";
		result = result + tail.data;
		Node temp = tail.prev;
		while(temp!=null) {
			result = result + ", " + temp.data;
			temp = temp.prev;
		}
		result = result + "]";
		return result;
	}

	public String toString() {
		if(head==null)
			return "List is empty";
		else {
			String result="[";
			result = result + head.data;
			Node temp = head.next;
			while(temp!=null) {
				result = result + ", " + temp.data;
				temp = temp.next;
			}
			result = result + "]";
			return result;
		}
	}

	public int length() {
		return length;
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.head = new Node(1);
		l.insertAtBegin(0);
		l.insertAtEnd(3);
		l.insertAtEnd(99);
		l.insertAtMiddle(2,2);
		l.insertAtMiddle(10,3);
		
		System.out.println(l);
		System.out.println("LinkedList Length: "+l.length()); 

		// l.removeAtMiddle(1);
		
		System.out.println(l.reversePrint());
		System.out.println("LinkedList Length: "+l.length()); 
	}
}
