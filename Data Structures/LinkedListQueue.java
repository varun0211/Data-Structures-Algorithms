public class LinkedListQueue {
   private int length=0;
   Node front=null, rear=null;

   static class Node {
      int data;
      Node next;

      Node(int data) {
         this.data = data;
         this.next = null;
      }

      public String toString() {
         return data+"";
      }
   }

   public boolean isEmpty() {
      return (length==0);
   }

   public int size() {
      return length;
   }

   public void clear() {
      length=0; front=null; rear=null;
   }

   public void enQueue(int newData) {
      Node newNode = new Node(newData);
      if(front==null) {
         front = newNode;
         rear = newNode;
      } else {
         rear.next = newNode;
         rear = newNode;
      }
      length++;
   }

   public Node deQueue() throws Exception {
      if(isEmpty()) 
         throw new Exception("Queue Underflow");
      else {
         Node temp = front;
         front = temp.next;
         temp.next = null;
         length--;
         if(isEmpty())
            rear = null;
         return temp;
      }
   }

   public String toString() {
      String result = "[";
      if(front==null)
         return result+"]";
      result += front.data;
      Node temp = front.next;
      while(temp!=null) {
         result += ", " + temp.data;
         temp = temp.next;
      }
      return result+"]";
   }

   public static void main(String[] args) throws Exception {
      LinkedListQueue lq = new LinkedListQueue();

      for(int i=10; i<=50; i+=10) 
         lq.enQueue(i);
      System.out.println(lq); // [10,20,30,40,50]
      System.out.println("size: "+lq.length); // size: 5 

      System.out.println();

      for(int i=0; i<5; i++)
         System.out.print(lq.deQueue()+" ");
      System.out.println();
      System.out.println(lq); // [40,50]
      System.out.println("size: "+lq.length); // size: 2
   }
}
