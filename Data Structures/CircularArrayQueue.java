public class CircularArrayQueue {
   private static final int CAPACITY=4;
   private int[] queueRep;
   private int size, front, rear;

   public CircularArrayQueue() {
      this(CAPACITY);
   }
   public CircularArrayQueue(int cap) {
      queueRep = new int[cap];
      this.size=0; this.front=0; this.rear=0;
   }

   public boolean isEmpty() {
      return (size==0);
   }

   public boolean isFull() {
      return (size==CAPACITY);
   }

   public int size() {
      return size;
   }

   public void clear() {
      size=0;
   }

   public void enQueue(int data) throws Exception {
      if(size==CAPACITY) {
         throw new Exception("Queue Overflow");
      } else {
         size++;
         queueRep[rear] = data;
         rear = (rear+1)%CAPACITY;
      }
   }

   public int deQueue() throws Exception {
      if(size==0) {
         throw new Exception("Queue Underflow");
      } else {
         size--;
         int data = queueRep[(front+1)%CAPACITY];
         queueRep[front] = 0;
         front = (front+1)%CAPACITY;
         return data;
      }
   }

   public String toString() {
      String result="[";
      if(size==0)
         return result+"]";
      for(int i=0; i<size; i++) {
         result += Integer.toString(queueRep[(front+i)%CAPACITY]);
         if(i<size-1) 
            result += ", ";
      }
      return result+"]";
   }

   public static void main(String[] args) throws Exception {
      CircularArrayQueue aq = new CircularArrayQueue();

      aq.enQueue(1);
      aq.enQueue(2);
      aq.enQueue(3);
      aq.enQueue(4);
      System.out.println(aq); // [1, 2, 3, 4]

      aq.deQueue(); // 4
      System.out.println(aq); // [1, 2, 3]

      aq.clear();
      System.out.println(aq); // []   
   }
}