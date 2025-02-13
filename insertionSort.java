// "static void main" must be defined in a public class.
public class Main {
    public static void printArr(int arr[]){
        for(int n : arr){
            System.out.println(n);
        }
    }
    public static void insertSort(int arr[]){
    for(int i = 1;i <arr.length;i++){
        int key = arr[i];// a variable to store the array 
        int j = i-1;
        while(j >=0&&arr[j]< key){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
     
    }
    public static void main(String[] args) {
        int arr[] = {2,4,3,1,6,5,8};
        insertSort(arr);
        printArr(arr);
      
    
}
}
