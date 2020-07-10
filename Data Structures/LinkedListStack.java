public class LinkedListStack {
   Node top;
   private int length;

   static class Node {
      int data;
      Node next;
      Node(int data) {
         this.data=data;
         this.next=null;
      }
   }

   public LinkedListStack() {
      this.top=null;
      this.length=0;
   }

   public int size() {
      return length;
   }

   public boolean isEmpty() {
      return (top==null);
   }

   public void push(int newData) {
      Node newNode = new Node(newData);
      if(top==null)
         top=newNode;
      else {
         newNode.next=top;
         top=newNode;
         length++;
      }
   }

   public int pop() throws Exception {
      if(isEmpty()) 
         throw new Exception("Stack Underflow");
      int data=top.data;
      top=top.next;
      length--;
      return data;
   }

   public int peek() throws Exception {
      if(isEmpty()) 
         throw new Exception("Stack Underflow");
      return top.data;
   }

   public String toString() {
      if(isEmpty())
         return "Stack is empty";
      else {
         String result="[";
         result = result + top.data;
         Node temp = top.next;
         while(temp!=null) {
            result = result + ", " + temp.data;
            temp = temp.next;
         }
         result = result + "]";
         return result;
      }
   }

   public static void main(String[] args) throws Exception {
      LinkedListStack ls = new LinkedListStack();

      ls.push(1);
      ls.push(2);
      ls.push(3);
      ls.push(4);

      System.out.println(ls); // [4, 3, 2, 1]

      System.out.println("Pop: "+ls.pop()); // 4

      System.out.println(ls); // [3, 2, 1]

      System.out.println("Peek: "+ls.peek()); // 3
   }

}