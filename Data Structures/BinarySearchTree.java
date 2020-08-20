// Final Tree Code
class BinarySearchTree {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}

		public String toString() {
			return data+"";
		}
	}
/**
Note: Recursive insertion should be implemented(not yet tried)
*/
	public void insert(int newData) {
		if(root==null) {
			root = new Node(newData);
			return;
		}
		Node curr = root;
		while(curr!=null) {
			if(curr.data > newData) {
				if(curr.left != null) 
					curr = curr.left;
				else {
					curr.left = new Node(newData);
					return;
				}
			} else {
				if(curr.right != null) 
					curr = curr.right;
				else {
					curr.right = new Node(newData);
					return;
				}
			}
		}
	}
// Recursive Delete Implementation
	public void delete(int key) {
		root = deleteKey(root, key);
	}

	public Node deleteKey(Node root, int key) {
		if(root==null) 
			return root;
		if(key < root.data)
			root.left = deleteKey(root.left, key);
		else if(key > root.data)
			root.right = deleteKey(root.right, key);
		else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			root.data = minNode(root.right);
			root.right = deleteKey(root.right, root.data);
		}
		return root;
	}

// Iterative Delete Implementation
	public void delete(int key) {
		Node prev=root, curr=root;
		if(root==null)
			return;
		while(key!=curr.data) {
			if(key < curr.data) {
				prev = curr;
				curr = curr.left;
			} else {
				prev = curr;
				curr = curr.right;
			}
		}
		if(curr.data <= prev.data) {
			if(curr.left==null) {
				prev.left = curr.right;
				return;
			}
			else if(curr.right==null) {
				prev.left = curr.left;
				return;
			}
		} else if(curr.data > prev.data) {
			if(curr.left==null) {
				prev.right = curr.right;
				return;
			}
			else if(curr.right==null) {
				prev.right = curr.left;
				return;
			}
		}
		Node tmp = maxNode(curr.left);
		curr.data = tmp.data;
		prev = curr;
		curr = curr.left;
		while(curr.right!=null) {
			prev = curr;
			curr = curr.right;
		}
		if(curr.data <= prev.data) {
			if(curr.left!=null) 
				prev.left = curr.left;
			else 
				prev.left = null;	
		} else if(curr.data > prev.data) {
			if(curr.left!=null) 
				prev.right = curr.left;
			else 
				prev.right = null;
		}
	} 

	Node maxNode(Node root) {
		while(root.right!=null) 
			root = root.right;
		return root;
	}

	Node minNode(Node root) {
		while(root.left!=null)
			root = root.left;
		return root;
	}

	void inOrder() {
		inOrderTraversal(root);
	}

	public void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data+" ");
			inOrderTraversal(root.right);
		}
	}

	public boolean search(Node root,int key) {
		if(root==null)
			return false;
		else if(root.data == key)
			return true;
		else if(key<=root.data)
			return search(root.left, key);
		return search(root.right, key);
	}

	public static void main(String[] args) {
                BinarySearchTree tree = new BinarySearchTree();

                tree.insert(50); 
                tree.insert(30); 
                tree.insert(20); 
                tree.insert(40); 
                tree.insert(70); 
                tree.insert(60); 
                tree.insert(80);
                tree.insert(35);
                tree.insert(45);
                tree.insert(65);

                // tree.inOrderTraversal(tree.root); // [20, 30, 35, 40, 45, 50, 60, 65, 70, 80]
                tree.inOrder(); // [20, 30, 35, 40, 45, 50, 60, 65, 70, 80]

                System.out.println();
                System.out.println(tree.search(tree.root,40)); // true

                System.out.println("Min Node: "+tree.minNode(tree.root)); // 20
                System.out.println("Max Node: "+tree.maxNode(tree.root)); // 80

                tree.delete(40);
                tree.inOrder(); // [20, 30, 35, 45, 50, 60, 65, 70, 80]

	}
}
