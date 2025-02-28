import java.util.*;

public class Main {
    // function for to push at bottom;



public static void nextGreaterElement(int arr[],int nge[]){
    // Creating a  stack;
    Stack<Integer> s = new Stack<>();
    // compairing the elemnets for last to first...
    for(int i = arr.length-1;i >= 0;i--){
       while(!s.isEmpty() && arr[i] >= s.peek()){
           s.pop();
       }
//       if(s.isEmpty()){
//           nge[i] = -1;
//       }
//       else{
//           nge[i] = s.peek();
//       }
        // same code with turnary operator
        nge[i] = s.isEmpty() ? -1:s.peek();

       // Push curr element to stack
        s.push(arr[i]);
    }

}

    public static void main(String args[]) {
        int arr[] = {4, 5, 2, 25, 7, 8, 6, 10};
        int nge[] = new int[arr.length];
        nextGreaterElement(arr, nge);

        for (int i = 0; i < nge.length; i++){
            System.out.print(nge[i] + " ");
        }
    }
}

