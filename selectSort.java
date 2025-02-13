// "static void main" must be defined in a public class.
public class Main {
    public static void printArr(int arr[]){
        for(int n : arr){
            System.out.println(n);
        }
    }
    public static void selectSort(int arr[]){
    for(int i = 0;i<arr.length;i++){
        int midPos = i;
        for(int j = i+1;j<arr.length;j++){
            if(arr[j]<arr[midPos]){
                midPos = j;
            }
        }
        //swop
        int temp = arr[i];
        arr[i] = arr[midPos];
        arr[midPos] = temp;
    }
     
    }
    public static void main(String[] args) {
        int arr[] = {2,4,3,78,98,1,6,5,8};
        selectSort(arr);
        printArr(arr);
      
    
}
}
