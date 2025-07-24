import java.util.*;
public class Main {
    public static int linearSearch(int arr[],int key){
        for(int i = 0;i<=arr.length;i++){
            if(arr[i] == key){
                return i;
            }

        }
        return -1;
    }
    public static int binarySearch(int arr[], int key){
        int l = 0;
        int r = arr.length-1;

        while(l<=r){
            int mid = (l+(r-l))/2;
            if(arr[mid]==key ){
                return mid;
            }
            else if(arr[mid] >key){
                r = mid-1;

            }else{
                l = mid+1;
            }
        }
        return -1;
    }
    public static int largest(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if( arr[i]>largest){
                largest = arr[i];
            }

        }
        return largest;
    }
    public static void reversal(int arr[]){
        int l = 0;
        int r = arr.length-1;
        while(l < r){
            //swop of the code
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //updating the positions
            l++;
            r--;
        }
        return ;
    }
    public static void printPairs(int arr[]){
        for(int i = 0;i<arr.length-1;i++){
           for(int j = i+1;j<arr.length;j++){
               System.out.print("["+arr[i]+","+arr[j]+"] ");
           }
           System.out.println();

        }
    }
    public static void subArray(int arr[]){
            int ts = 0;
        for(int i = 0;i<=arr.length-1;i++){
            for(int j = i;j< arr.length;j++){
                for(int k = i;k<=j;k++){
                    System.out.print(arr[k]+" ");

                }
                ts++;
                System.out.println();
            }
        }
        System.out.println("total sub arrays = "+ ts);
    }
    public static void main(String args[]) {

        int arr[] = {10,20,30,40};
        int key = 68;
        reversal(arr);

    subArray(arr);

    }
}
