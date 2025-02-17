//understanding backtracking through an array...
//  initally allotig 1,2,3,4,5 to indexes later arr[i]-2 for 3,2,1,0,-1 by back racking




public class Code{
    public static void changeArr(int arr[],int i,int val){
        //BASE CASE
        if(i==arr.length){
            printArr(arr);
            return;
        }
        //RECURSION/KAAM
        arr[i] = val;
        changeArr(arr,i+1,val+1);//fnx call
        arr[i] = arr[i]-2;//step at backtracking

    }
    public static void printArr(int arr[]){
        for(int n:arr){
            System.out.print(n+" ");
        }
        System.out.println();
    }
    public static void main(String [] agrs){
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);
    }
}
