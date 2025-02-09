class timepass{
    public static void main(String args[]){
        int arr[] = {10,20,30,40,50};
        int key = 30;
        int i = arr.length-1;
        System.out.print(firstOccurence(arr,i,key));
    }
    public static int firstOccurence(int arr[],int i,int key){
        if(i == -1){
            return-1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurence(arr,i-1,key);
    }
}
