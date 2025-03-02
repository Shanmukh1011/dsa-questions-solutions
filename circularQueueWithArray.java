public class Main{
    public static class Queue{
       static int size;
       static int rear;
       static int front ;
       static int arr[];
       Queue(int n){
           arr = new int [n];
           size = n;
           rear = -1;
           front = -1;
       }
       public static boolean isEmpty(){
          return rear == -1 && front == -1;
       }
       public static boolean isFull(){
           return (rear+1)%size == front;
       }
        // add
        public static void add(int data){
           if(isFull()){
               System.out.println("Queue is full");
           }
           else{
               if(front == -1){
                   front = 0;
               }
               rear = rear + 1;
               arr[rear] = data;
           }
        }
        //remove
        public static int remove(){
           if(isEmpty()){
               System.out.println("Queue is empty");
               return -1;
           }
           int result = front;
           if(rear == front){
               rear = front = -1;
           }else{
               front = (front+1)%size;
           }

        return arr[result];
        }
        //peek
        public static int peek(){
           if(isEmpty()){
               System.out.println("Queue is empty");
               return -1;
           }
           return arr[front];
        }
    }

    public static void main (String args[]){

        Queue q = new Queue(5);
        q.add(2);
        q.add(4);
        q.add(6);
        System.out.println(q.remove());
        q.add(8);
        System.out.println(q.remove());
        q.add(10);


        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();

        }

    }
}
