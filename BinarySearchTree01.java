import java.util.Stack;

class Test {
	Node root;
	// Data Structure
	static class Node{
		int data;
		Node left,right;

		Node(int data) {
			this.data=data;
			left=right=null;
		}

		public String toString() {
			return data+"";
		}
	}
	// Insertion of node in BST
	public void insert(int newData) {
		Node newNode=new Node(newData);
		if(root==null) {
			root=newNode;
			return;
		}
		Node curr=root, prev=null;
		while(curr!=null) {
			if(newData<=curr.data) {
				prev=curr;
				curr=curr.left;
			} else {
				prev=curr;
				curr=curr.right;
			}
		}
		if(newData<=prev.data) 
			prev.left=newNode;
		else 
			prev.right=newNode;
		return;
	}
	//Deletion of node in BST
	public void delete(int key) {
		Node curr=root, prev=root;
		if(root==null)
			return;
		while(key!=curr.data) {
			if(key<curr.data) {
				prev=curr;
				curr=curr.left;
			} else {
				prev=curr;
				curr=curr.right;
			}
		}
		if(curr.data<=prev.data) {
			if(curr.left==null) {
				prev.left=curr.right;
				return; 
			} else if(curr.right==null) {
				prev.left=curr.left;
				return;
			}
		} else {
			if(curr.left==null) {
				prev.right=curr.right;
				return;
			} else if(curr.right==null) {
				prev.right=curr.left;
				return;
			}
		}
		Node tmp=maxNode(curr.left);
		curr.data=tmp.data;
		prev=curr;
		curr=curr.left;
		while(curr.right!=null) {
			prev=curr;
			curr=curr.right;
		}
		if(curr.data<=prev.data) {
			if(curr.left!=null)
				prev.left=curr.left;
			else
				prev.left=null;
		} else {
			if(curr.left!=null)
				prev.right=curr.left;
			else
				prev.right=null;
		}
	}
	// Min Node in BST
	Node minNode(Node root) {
		while(root.left!=null)
			root=root.left;
		return root;
	}
	// Max Node in BST
	Node maxNode(Node root) {
		while(root.right!=null) 
			root=root.right;
		return root;
	}
	// Predecessor of the given node
	Node predecessor(int key) {
		Stack<Node> stack = new Stack<>();
		Node curr=root;
		if(key==curr.data) {
			if(curr.left!=null)
				return maxNode(curr.left);
			else
				return null;
		}
		else {
			while(key!=curr.data) {
				if(key<=curr.data) {
					stack.push(curr);
					curr=curr.left;
				}
				else {
					stack.push(curr);
					curr=curr.right;
				}
			}
		}
		if(curr.left!=null)
			return maxNode(curr.left);
		else {
			while(!stack.isEmpty()) {
				if(key<stack.peek().data)
					stack.pop();
				else 
					return stack.peek();
			}
			return null;
		}
	}
	// Sucessor of the given node
	Node sucessor(int key) {
		Stack<Node> stack = new Stack<>();
		Node curr=root;
		if(key==curr.data) {
			if(curr.right!=null)
				return minNode(root.right);
			else
				return null;
		}
		else {
			while(key!=curr.data) {
				if(key<=curr.data) {
					stack.push(curr);
					curr=curr.left;
				}
				else {
					stack.push(curr);
					curr=curr.right;
				}
			}
		}
		if(curr.right!=null)
			return minNode(curr.right);
		else {
			while(!stack.isEmpty()) {
				if(key>stack.peek().data)
					stack.pop();
				else
					return stack.peek();
			}
			return null;
		}
	}
	// main method
	public void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}

	public boolean search(int key) {
		Node curr=root;
		boolean flag=false;
		while(!flag && curr!=null) {
			if(key<curr.data)
				curr=curr.left;
			else if(key>curr.data)
				curr=curr.right;
			else if(key==curr.data) {
				flag=true;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Test tree = new Test();

		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80);
        tree.insert(35);
        tree.insert(45);
        // tree.insert(44);
        // tree.insert(65);
        // tree.insert(69);
        // tree.insert(33);

		tree.inOrder(tree.root); // [20, 30, 33, 35, 40, 44, 45, 50, 60, 65, 69, 70, 80]
		System.out.println();

		// System.out.println("Min Node: "+tree.minNode(tree.root));
		// System.out.println("Max Node: "+tree.maxNode(tree.root));

		// tree.delete(50); // [20 30 35 37 40 45 50 60 70 75 80]
		// tree.inOrder(tree.root);

		// System.out.println(tree.predecessor(40)); 		
		// System.out.println(tree.sucessor(70)); 

		System.out.println(tree.search(40)); // true	

	}
}
