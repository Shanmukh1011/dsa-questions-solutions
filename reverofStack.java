import java.util.*;
public class Main{

    public static void insertBottom(Stack<Integer> s,int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int top = s.pop();
        insertBottom(s,val);
        s.add(top);
    }
   public static void reverseStack(Stack<Integer> s){
       // base case
       if(s.isEmpty()){
           return;
       }
       int top = s.pop();
       reverseStack(s);
       insertBottom(s,top);
   }
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(4);
        s.push(6);
        s.push(8);
        s.push(10);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }
}
