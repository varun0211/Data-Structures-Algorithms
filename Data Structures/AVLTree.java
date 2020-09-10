// AVL tree without recursion

import java.util.Stack;

public class AVLTree {
	Node root;

	static class Node {
		int data,height;
		Node left,right;

		Node(int data) {
			this.data = data;
			height = 1;
			left = right = null;
		}

		public String toString() {
			return data+"";
		}
	}

	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	int heights(Node n) {
		if(n == null)
			return 0;
		return n.height;
	}

	int balanceFactor(Node bf) {
		if(bf == null)
			return 0;
		return heights(bf.left)-heights(bf.right);
	}

	Node rightRotation(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = max(heights(x.left),heights(x.right))+1;
		y.height = max(heights(y.left),x.height)+1;
		return y;
	}

	Node leftRotation(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = max(heights(x.left),heights(x.right))+1;
		y.height = max(x.height,heights(y.right))+1;
		return y;
	}	

	public Node insert(int newData) {
		Node curr = root;
		if(curr == null) {
			root = new Node(newData);
			return root;
		}
		Stack<Node> stack = new Stack<>();
		while(curr != null) {
			stack.push(curr);
			if(newData < curr.data)
				curr = curr.left;
			else if(newData > curr.data)
				curr = curr.right;
			else 
				return root;
		}
		if(newData < stack.peek().data)
			stack.peek().left = new Node(newData);
		else 
			stack.peek().right = new Node(newData);
		while(!stack.isEmpty()) {
			curr = stack.peek();
			curr.height = max(heights(curr.left),heights(curr.right))+1;
			int balance = balanceFactor(curr);
			if(balance>=-1 && balance<=1)
				stack.pop();
			else {
				if(balance>1 && newData<curr.left.data) {
					curr = rightRotation(curr);
				}
				else if(balance<-1 && newData>curr.right.data) {
					curr = leftRotation(curr);
				}
				else if(balance>1 && newData>curr.left.data) {
					curr.left = leftRotation(curr.left);
					curr = rightRotation(curr);
				}
				else if(balance<-1 && newData<curr.right.data) {
					curr.right = rightRotation(curr.right);
					curr = leftRotation(curr);
				}
				stack.pop();
				if(stack.isEmpty())
					return curr;
				else if(curr.data > stack.peek().data)
					stack.peek().right = curr;
				else if(curr.data < stack.peek().data)
					stack.peek().left = curr;
				stack.push(curr);
			}
		}
		return curr;
	}

	public void preOrder(Node curr) {
		if(curr != null) {
			System.out.print(curr.data+" ");
			preOrder(curr.left);
			preOrder(curr.right);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

// Test case 1: Right Skewed Tree [30 20 10 25 40 50]
		// tree.root = tree.insert(10); 
		// tree.root = tree.insert(20); 
		// tree.root = tree.insert(30); 
		// tree.root = tree.insert(40); 
		// tree.root = tree.insert(50); 
		// tree.root = tree.insert(25);

// Test case 2: [50 30 10 40 75 70 80]
		// tree.root = tree.insert(50); 
		// tree.root = tree.insert(30); 
		// tree.root = tree.insert(70); 
		// tree.root = tree.insert(10); 
		// tree.root = tree.insert(40); 
		// tree.root = tree.insert(80);
		// tree.root = tree.insert(75);

// Test case 3: [8 5 3 6 10 9]
		tree.root = tree.insert(6); 
		tree.root = tree.insert(5); 
		tree.root = tree.insert(3); 
		tree.root = tree.insert(10); 
		tree.root = tree.insert(8); 
		tree.root = tree.insert(9);

		tree.preOrder(tree.root);

	}
}
