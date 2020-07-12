public class CircularArrayQueue {
   public static final int MINCAPACITY=4;
   protected int[] queueRep;
   protected int size, front, rear, capacity;

   public CircularArrayQueue() {
      this(MINCAPACITY);
   } 
   public CircularArrayQueue(int cap) {
      this.capacity = cap;
      queueRep = new int[cap];
      this.size=0; this.front=0; this.rear=0;
   }

   public boolean isEmpty() {
      return (size==0);
   }

   public boolean isFull() {
      return (size==capacity);
   }

   public void clear() {
      size=0; front=0; rear=0;
   }

   public void enQueue(int data) throws Exception {
      if(size==capacity)
         throw new Exception("Queue Overflow");
      else {
         size++;
         queueRep[rear] = data;
         rear = (rear+1)%capacity;
      }
   }

   public int deQueue() throws Exception {
      if(size==0)
         throw new Exception("Queue Underflow");
      else {
         size--;
         int data = queueRep[front];
         front = (front+1)%capacity;
         return data;
      }
   }

   public String toString() {
      String result = "[";
      if(size==0)
         return result+"]";
      result += queueRep[front];
      for(int i=1; i<size; i++) {
         result += ", " + queueRep[(front+i)%capacity];
      }
      return result+"]";
   }

   public static void main(String[] args) throws Exception {
      CircularArrayQueue aq = new CircularArrayQueue(8);

      for(int i=10; i<70; i+=10) {
         aq.enQueue(i);
      }
      System.out.println(aq); // [10,20,30,40,50,60]

      aq.deQueue(); // 10
      System.out.println(aq); // [20,30,40,50,60]
      
      aq.clear(); 
      System.out.println(aq); // []

      aq.enQueue(99); 
      aq.enQueue(999);
      System.out.println(aq); // [99,999]
   }
}
