// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static void printArr(int arr[]){
        for(int n : arr){
            System.out.println(n);
        }
    }
  public static void countSort(int arr[]){
     int largest = Integer.MIN_VALUE;
      //loop to find the largest element or to get the range;
      for(int i = 0;i <arr.length;i++){
          largest = Math.max(largest,arr[i]);
      }
      int count[] = new int[largest+1];// so the we could inclued 0;
      for(int i = 0;i < arr.length;i++){
          count[arr[i]]++; // here we count the frequency of elements and store them in the index ;
      }
      int j = 0;
      //sorting takes place here please understand the code..
      for(int i = 0;i <count.length;i++){
          while(count[i]>0){
              arr[j] = i;//includes the index as element 
              j++;//moves to the nxt index;
              count[i]--;//redusese the frequency after adding the element
          }
      }
    }
    public static void main(String[] args) {
        int arr[] = {2,4,3,7,7,9,9,8,1,6,5,0,8,9,9,8};
        countSort(arr);
        printArr(arr);
      
    
}
}
