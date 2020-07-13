public class DynamicArrayQueue {
   public static final int MINCAPACITY=2;
   protected int[] queueRep;
   protected int size, front, rear, capacity;

   public DynamicArrayQueue() {
      this(MINCAPACITY);
   } 
   public DynamicArrayQueue(int cap) {
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
         expand();
      size++;
      queueRep[rear] = data;
      rear = (rear+1)%capacity;
   }

   public int deQueue() throws Exception {
      if(size==0)
         throw new Exception("Queue Underflow");
      else {
         if((size-1)<=(capacity/2)/2)
            shrink();
         size--;
         int data = queueRep[(front%capacity)];
         front = (front+1)%capacity;
         return data;
      }
   }

   private void expand() {
      int length = size;
      int[] newQueue = new int[length*2];
      System.arraycopy(queueRep,0,newQueue,0,length);
      queueRep = newQueue;
      front=0;
      rear = size;
      this.capacity *= 2;
   }

   private void shrink() {
      int length = size;
      capacity = capacity/2;
      int[] newQueue = new int[capacity];
      System.arraycopy(queueRep,front,newQueue,0,length);
      queueRep = newQueue;
      front=0;
      rear = size;
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
      DynamicArrayQueue dq = new DynamicArrayQueue();

      for(int i=10; i<=20; i+=10)
         dq.enQueue(i);
      System.out.println(dq); // [10,20,30,40,50,60,70,80,90]
      System.out.println("capacity: "+dq.capacity); // capacity: 16

      for(int i=0; i<5; i++) 
         dq.deQueue();
      System.out.println(dq); // [60,70,80,90]
      System.out.println("capacity: "+dq.capacity); // capacity: 8
   }
}