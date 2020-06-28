class LinkedList {
	Node head;
	private int length=0;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		Node(int data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public LinkedList() {
		length=1;
	}

	
}