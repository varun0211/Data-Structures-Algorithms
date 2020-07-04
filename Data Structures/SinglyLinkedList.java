class LinkedList {
	Node head;
	private int length;

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}

		// public String toString() {
		// 	return Integer.toString(data);
		// }
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
			head = newNode;
		}
		length++;
	}

	public void insertAtEnd(int newData) {
		Node newNode = new Node(newData);
		if(head==null)
			head = newNode;
		else {
			Node p,q;
			for(p=head; (q=p.next)!=null; p=q)
				continue;
			p.next = newNode;
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
			head = newNode;
		}
		else {
			Node temp = head;
			for(int i=1; i<position; i++)
				temp = temp.next;
			newNode.next = temp.next;
			temp.next = newNode;
		}
		length++;
	}

	public Node removeAtBegin() {
		Node temp = head;
		if(temp!=null) {
			head = temp.next;
			temp.next = null;
			length--;
		}
		return temp;
	}

	public Node removeAtEnd() {
		if(head==null)
			return null;
		Node p=head, q=null, nxt=p.next;
		if(nxt==null){
			head=null;
			length--;
			return p;
		}
		while((nxt=p.next)!=null) {
			q=p;
			p=nxt;
		}
		q.next = null;
		length--;
		return p;
	}

	public void removeKey(int key) {
		if(head==null)
			return;
		Node temp=head, nxt=null;
		if(temp.data==key) {
			head = temp.next;
			length--;
			return;
		}
		while((nxt=temp.next)!=null && nxt.data!=key) {
			temp=nxt;
		}
		temp.next = nxt.next;
		length--;
		return;
	}

	public void removeAtMiddle(int position) {
		if(position<0)
			position=0;
		if(position>=length)
			position=length-1;
		Node temp=head;
		if(head==null)
			return;
		if(position==0) {
			head=temp.next;
			length--;
		}
		else {
			for(int i=1; i<position; i++)
				temp=temp.next;
			temp.next = temp.next.next;
			length--;
		}
	}

	public void deleteList() {
		head=null;
		length=0;
	}

	public String toString() {
		String result="[";
		if(head==null)
			return result+"]";
		result = result + head.data;
		Node temp=head.next;
		while(temp!=null) {
			result = result + ", " + temp.data;
			temp = temp.next;
		}
		return result + "]";
	}

	public int length() {
		return length;
	}

	// public void printList() {
	// 	Node temp = head;
	// 	try {
	// 		if(temp!=null) {
	// 			while(temp!=null) {
	// 				System.out.print(temp.data+" ");
	// 				temp = temp.next;
	// 			}
	// 			System.out.println("\nLenght of the List: "+length);
	// 		}
	// 		else {
	// 			System.out.println("List is Empty");
	// 		}
	// 	}
	// 	catch(NullPointerException e) {
	// 		System.out.println("List is Empty");
	// 	}		
	// }

	// public void printList() {
	// 	Node temp = head;
	// 	if(temp!=null) {
	// 		while(temp!=null) {
	// 			System.out.print(temp.data+" ");
	// 			temp = temp.next;
	// 		}
	// 		System.out.println("\nLenght of the List: "+length);
	// 	}
	// 	else {
	// 		System.out.println("List is Empty");
	// 	}		
	// }

	public String printList() {
		Node temp = head.next;
		String result="["+head.data;
		if(temp!=null) {
			while(temp!=null) {
				result = result + ", " + temp.data;
				temp = temp.next;
			}
			result = result + "]";
			return result;
		}
		else {
			return "List is Empty";
		}		
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.head = new Node(1);
		l.insertAtBegin(0);
		l.insertAtEnd(2);
		l.insertAtEnd(3);
		l.insertAtEnd(5);
		l.insertAtEnd(6);
		l.insertAtMiddle(99,4);
		l.insertAtMiddle(100,10);
		
		// Printing list using printList() method.
		System.out.println(l.printList());
		// l.removeAtPos(1000);
		// l.printList();
		
		// Printing list using toString() method.
		System.out.println(l);
		System.out.println(l.length());
	}
}
