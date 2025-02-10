class timepass{

    public static  void indOcc(int arr[],int key,int i){
        if(i == arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
         indOcc(arr,key,i+1);
    }
    public static void main(String args[]){
        int arr[] = {2,3,4,5,2,6,7,2};
        int key = 2;
        int i = 0;
        indOcc(arr,key,i);
    }
}
