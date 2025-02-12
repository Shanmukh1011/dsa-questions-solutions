public class Code{
    public static void printArr(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
    public static void mergSort(int arr[],int si,int ei){
        if (si >= ei) {
            return;
        }
        //kaam
        int mid = si+(ei-si)/2;//si+ei/2..
        mergSort(arr,si,mid);
        mergSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
        
       
    }
    public static void merge(int arr[],int si,int mid,int ei){
        //left(0,3)=4 and right(4,6) = 3 -> (6-0+1)= 7;
        int temp[] = new int[ei-si+1];
        int i =si;//iterator for left part;
        int j = mid+1;//iterator for right part
        int k = 0;//iterator for temparr

        while(i <=mid&& j <= ei){
            if(arr[i]<=arr[j]){
                temp[k]=arr[i]; // or keep i++ directly
                i++;
            }else{
                temp[k]=arr[j]; // or keep j++ directly
                j++;
            }
            k++;
    
        }
        //copy remaining elements of left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //copy temp to original array
        for(k = 0, i = si ;k <=temp.length-1;i++,k++){
            arr[i]= temp[k];
        }
        

    }
    public static void main(String[] args){
    int arr [] = {6,3,9,5,2,8};
    mergSort(arr,0,arr.length-1);
    printArr(arr);
    }
}
