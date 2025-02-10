class timepass{
    public static void main(String[] args) {
        int arr [] = {20,30,40,50,70,90,95};
        int key = 60;
        int res = binarySearch(arr,key,0,arr.length-1);
        if(res==-1){
            System.out.println("element not found");
        }else{
            System.out.println("element found at index = "+res);
        }
    }
    public static int binarySearch(int arr[],int key,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid] > key){
          return  binarySearch(arr,key,start,mid-1);
        }else{
         return   binarySearch(arr,key,mid+1,end);
        }
    }
}
