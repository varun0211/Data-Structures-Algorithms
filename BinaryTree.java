import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.*;

class Tree {
   Node root;

   static class Node {
      int data;
      Node left,right;

      Node(int data) {
         this.data = data;
         left=right=null;
      }
   }

   public Node insertTreeWithArray(int[] arr, Node root, int i) {
      if(i<arr.length && arr[i]!=-1) {
         root = new Node(arr[i]);
         root.left = insertTreeWithArray(arr, root.left,(2*i+1));
         root.right = insertTreeWithArray(arr, root.right,(2*i+2));
      }
      return root;
   }

   public void insert(int newData) {
      Node newNode = new Node(newData);
      Node curr = root;
      Node prev = null;
      while(curr!=null) {
         prev = curr;
         if(newData>curr.data)
            curr = curr.right;
         else
            curr = curr.left;
      }
      if(prev==null)
         root = newNode;
      else if(newData>prev.data)
         prev.right = newNode;
      else 
         prev.left = newNode;
   }
// Self Coded
   // public void insert(int newData) {
   //    if(root==null) {
   //       root = new Node(newData);
   //       return;
   //    }
   //    Node curr = root;
   //    while(curr!=null) {
   //       if(curr.data > newData) {
   //          if(curr.left != null) 
   //             curr = curr.left;
   //          else {
   //             curr.left = new Node(newData);
   //             return;
   //          }
   //       } else {
   //          if(curr.right != null) 
   //             curr = curr.right;
   //          else {
   //             curr.right = new Node(newData);
   //             return;
   //          }
   //       }
   //    }
   // }

   public ArrayList<Integer> preOrderTraversal(Node root) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      if(root==null)
         return res;
      Stack<Node> s = new Stack<Node>();
      s.push(root);
      while(!s.isEmpty()) {
         Node curr = s.pop();
         res.add(curr.data);
         if(curr.right!=null)
            s.push(curr.right);
         if(curr.left!=null)
            s.push(curr.left);
      }
      return res;
   }

   public ArrayList<Integer> inOrderTraversal(Node root) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      if(root==null)
         return res;
      Stack<Node> s = new Stack<Node>();
      while(root!=null || s.size()>0) {
         while(root!=null) {
            s.push(root);
            root = root.left;
         }
         Node curr = s.pop();
         res.add(curr.data);
         root = curr.right;
      }
      return res;
   }

   public ArrayList<Integer> postOrderTraversal(Node root) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      if(root==null)
         return res;
      Stack<Node> s = new Stack<Node>();
      s.push(root);
      Node prev=null;
      while(!s.isEmpty()) {
         Node curr = s.peek();
         if(prev==null || prev.left==curr || prev.right==curr) {
            if(curr.left!=null)
               s.push(curr.left);
            else if(curr.right!=null)
               s.push(curr.right);
         } else if(curr.left==prev) {
            if(curr.right!=null)
               s.push(curr.right);
         } else {
            res.add(curr.data);
            s.pop();
         }
         prev=curr;
      }
      return res;
   }

// Self coded 
      // public ArrayList<Integer> postOrderTraversal(Node root) {
      //    ArrayList<Integer> res = new ArrayList<Integer>();
      //    if(root==null)
      //       return res;
      //    Stack<Node> s = new Stack<Node>();
      //    boolean flag = false;
      //    Node prev=null, old=null, curr=root;
      //    while(!flag) {
      //       if(curr!=null) {
      //          prev=curr;
      //          s.push(curr);
      //          curr=curr.left;
      //       } else {
      //          while(!s.isEmpty() && curr==null) {
      //             if(prev.right!=old) {
      //                if(prev.right!=null) {
      //                   curr=prev.right;
      //                } else {
      //                   Node tmp=s.pop();
      //                   res.add(tmp.data);
      //                   old=tmp;
      //                   prev=s.peek();
      //                }
      //             } else {
      //                Node tmp=s.pop();
      //                res.add(tmp.data);
      //                if(s.isEmpty()) {
      //                   flag=true;
      //                   break;
      //                }
      //                old=tmp;
      //                prev=s.peek();
      //             }
      //          }
      //       }
      //    }
      //    return res;
      // }

//https://www.youtube.com/watch?v=sMI4RBEZyZ4 (Kavin Naughton)
   // public ArrayList<Integer> postOrderTraversal(Node root) {
   //    ArrayList<Integer> res = new ArrayList<Integer>();
   //    if(root==null)
   //       return res;
   //    Stack<Node> s = new Stack<Node>();
   //    s.push(root);
   //    while(!s.isEmpty()) {
   //       Node curr = s.pop();
   //       res.add(0,curr.data);
   //       if(curr.left!=null)
   //          s.push(curr.left);
   //       if(curr.right!=null)
   //          s.push(curr.right);
   //    }
   //    return res;
   // }

// Using 2 stack postOrderTraversal
   // public ArrayList<Integer> postOrderTraversal(Node root) {
   //    ArrayList<Integer> res = new ArrayList<Integer>();
   //    if(root==null)
   //       return res;
   //    Stack<Node> s1 = new Stack<Node>();
   //    Stack<Node> s2 = new Stack<Node>();
   //    s1.push(root);
   //    while(!s1.isEmpty()) {
   //       Node curr = s1.pop();
   //       s2.push(curr);
   //       if(curr.left!=null)
   //          s1.push(curr.left);
   //       if(curr.right!=null)
   //          s1.push(curr.right);
   //    }
   //    while(!s2.isEmpty()) {
   //       Node out = s2.pop();
   //       res.add(out.data);
   //    }
   //    return res;
   // }

   public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if(root==null)
         return res;
      Queue<Node> q = new LinkedList<Node>();
      q.offer(root);
      q.offer(null);
      ArrayList<Integer> curr = new ArrayList<Integer>();
      while(!q.isEmpty()) {
         Node tmp = q.poll();
         if(tmp!=null) {
            curr.add(tmp.data);
            if(tmp.left!=null)
               q.offer(tmp.left);
            if(tmp.right!=null)
               q.offer(tmp.right);
         } else {
            ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
            res.add(c_curr);
            curr.clear();
            if(!q.isEmpty())
               q.offer(null);
         }
      }
      return res;
   }

   public static void main(String[] args) {
      Tree t = new Tree();
      // t.insert(5);
      // t.insert(8);
      // t.insert(4);
      // t.insert(2);
      // t.insert(6);
      // t.insert(10);
      // t.insert(3);
      // t.insert(7);
      // t.insert(1);
      // t.insert(0);
      // t.insert(9);
      // t.insert(5);

      int[] arr = {1,2,3,4,5,6,7,-1,-1,8,9};
      t.root = t.insertTreeWithArray(arr, t.root, 0);
      
      // System.out.println("Required: 5,4,2,1,0,3,8,6,7,10,9");
      // ArrayList<Integer> result1 = t.preOrderTraversal(t.root);
      // System.out.print("preOrder: ");
      // for(int r:result1)
      //    System.out.print(r+" "); // [5,4,2,1,0,3,8,6,7,10,9]
      // System.out.println("\n");

      // System.out.println("Required: 0,1,2,3,4,5,6,7,8,9,10");
      // ArrayList<Integer> result2 = t.inOrderTraversal(t.root);
      // System.out.print("inOrder: ");
      // for(int r:result2)
      //    System.out.print(r+" "); // [0,1,2,3,4,5,6,7,8,9,10]
      // System.out.println("\n");

      // System.out.println("Required: 0,1,3,2,4,7,6,9,10,8,5");
      // ArrayList<Integer> result3 = t.postOrderTraversal(t.root);
      // System.out.print("postOrder: ");
      // for(int r:result3)
      //    System.out.print(r+" "); // [0,1,3,2,4,7,6,9,10,8,5]
      // System.out.println("\n");

      // System.out.println("Required: 5,4,8,2,6,10,1,3,7,9,0");
      ArrayList<ArrayList<Integer>> result4 = t.levelOrderTraversal(t.root);
      System.out.println("levelOrder: ");
      for(ArrayList<Integer> r:result4)
         System.out.println(r+" "); // [0,1,3,2,4,7,6,9,10,8,5]
      // System.out.println("\n");

      

   }
}
