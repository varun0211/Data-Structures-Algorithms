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

	public void delete(int key) {
		boolean flag = false;
		Node prev=null, curr=root;
		if(root==null)
			return;
		else if(root.data==key) {
			Node tmp = maxNode(root.left);
			root.data = tmp.data;
			curr = root.left;
		}
		else {
			while(!flag) {
				if(key < curr.data) {
					prev=curr;
					curr = curr.left;
					if(curr==null) {
						System.out.println("Data not found");
						return;
					}
				}
				else if(key > curr.data) {
					prev=curr;
					curr = curr.right;
					if(curr==null) {
						System.out.println("Data not found");
						return;
					}
				}
				else {
					flag = true;
					if(curr.data < prev.data) {
						if(curr.left==null) {
							prev.left = curr.right;
							return;
						}
						else if(curr.right==null) {
							prev.left = curr.left;
							return;
						}
						Node tmp = maxNode(curr.left);
						curr.data = tmp.data;
					}
					else if(curr.data > prev.data) {
						if(curr.left==null) {
							prev.right = curr.right;
							return;
						}
						else if(curr.right==null) {
							prev.right = curr.left;
							return;
						}
						Node tmp = maxNode(curr.left);
						curr.data = tmp.data;
					}
					prev = curr;
					curr = curr.left;
				}
			}
		}
		while(curr.right!=null) {
			prev = curr;
			curr = curr.right;
		}
		if(curr.left!=null)
			prev.right = curr.left;
		else
			prev.right = null;
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

		// tree.inOrderTraversal(tree.root); // [20,30,40,50,60,70,80]
		tree.inOrder(); // [20,30,40,50,60,70,80]

		System.out.println();
		System.out.println(tree.search(tree.root,40)); // true

		System.out.println("Min Node: "+tree.minNode(tree.root)); // 20
		System.out.println("Max Node: "+tree.maxNode(tree.root)); // 80

		tree.delete(40);
		tree.inOrder(); // [20,30,40,60,70,80]
		}
}
