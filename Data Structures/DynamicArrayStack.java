public class DynamicArrayStack {
   public static final int CAPACITY=4;
   public static int MINCAPACITY=1<<2;
   protected int capacity;
   protected int top=-1;
   protected int[] stackRep;

   public DynamicArrayStack() {
      this(CAPACITY);
   }

   public DynamicArrayStack(int cap) {
      this.capacity = cap;
      this.stackRep = new int[capacity];
   }

   public int size() {
      return (top+1);
   }

   public boolean isEmpty() {
      return (top<0);
   }

   public void push(int data) throws Exception {
      if(size()==capacity)
         expand();
      stackRep[++top] = data;
   }

   private void expand() {
      int length = size();
      int[] newStack = new int[length<<1];
      System.arraycopy(stackRep,0,newStack,0,length);
      stackRep = newStack;
      this.capacity = this.capacity<<1;
   }

   private void shrink() {
      int length = size();
      if(length<MINCAPACITY) {
         this.capacity = MINCAPACITY;
         return;
      }
      if(length<=(capacity/2)/2) 
         capacity = capacity/2;
      int newStack[] = new int[capacity];
      System.arraycopy(stackRep,0,newStack,0,length);
      stackRep = newStack;
   }

   public int pop() throws Exception {
      int data;
      if (isEmpty())
         throw new Exception("Stack is empty.");
      data = stackRep[top];
      stackRep[top--] = Integer.MIN_VALUE;
      shrink();
      return data;
   }

   public int peek() throws Exception {
      if(isEmpty()) 
         throw new Exception("Stack Underflow");
      return stackRep[top];
   }

   public String toString() {
      String result="[";
      if(size()>0)
         result += stackRep[0];
      if(size()>1) {
         for(int i=1; i<size(); i++) {
            result += ", " + stackRep[i];
         }
      }
      return result+"]";
   }

   public static void main(String[] args) throws Exception {
      DynamicArrayStack ds = new DynamicArrayStack();
      for(int i=0; i<14; i++) {
         ds.push(i);
      }

      System.out.println("Capacity: "+ds.capacity); // Capacity: 16
      System.out.println("ArraySize: "+ds.size()); // ArraySize: 14
      System.out.println(ds); // [0,1,2,3,4,5,6,7,8,9,10,11,12,13]
      System.out.println();

      for(int i=0; i<9; i++) {
         ds.pop();
      }

      System.out.println("Capacity: "+ds.capacity); // Capacity: 16
      System.out.println("ArraySize: "+ds.size()); // ArraySize: 5
      System.out.println(ds); // [0, 1, 2, 3, 4]
      System.out.println();

      ds.pop(); // 4

      System.out.println("Capacity: "+ds.capacity); // Capacity: 8
      System.out.println("ArraySize: "+ds.size()); // ArraySize: 4
      System.out.println(ds); // [0, 1, 2, 3]
      System.out.println();

      ds.pop();
      ds.pop();
      ds.pop();
      ds.pop(); // No capacity break over here bcoz min capacity is 4  

      System.out.println("Capacity: "+ds.capacity); // Capacity: 4
      System.out.println("ArraySize: "+ds.size()); // ArraySize: 0
      System.out.println(ds); // []        

   }
}
