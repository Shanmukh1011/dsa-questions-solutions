import java.util.*;

public class Main {
    // function for to push at bottom;


   public static void stockSpan(int stocks[],int span[]){
       // we are solving code with stack so creat a stack;
       Stack<Integer> s = new Stack<>();
       // span for 1st index is always zero...
       span[0] = 1;
       s.push(0);
       // creating a loop for to reach each element price and to find ther span;
       for(int i = 1;i <stocks.length;i++){
           // curr stock value to compare with prev stock vales
           int curr = stocks[i];
           while(!s.isEmpty()&&curr >stocks[s.peek()]){
               s.pop();
           }
           if(s.isEmpty()){
               span[i] = i+1;
           }else{
               // previous high in the stack to be stored in the pevvHihg
               int prevHigh = s.peek();
               //span = curr idx - idx of prev high;
               span[i] = i - prevHigh;
           }
           // Push current index
           s.push(i);

       }
   }


    public static void main(String args[]) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++){
            System.out.print(span[i] + " ");
        }
    }
}

