 class Code{
    public static void printArr(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
   
   public static void quickSort(int[] arr,int si,int ei){
    if(si>=ei){
        return;
    }
    //last element;
    int pidx = partition(arr,si,ei);
    quickSort(arr,si,pidx-1);//left part;
    quickSort(arr,pidx+1,ei);//rightpart;
   }

   public static int partition(int arr[],int si,int ei){
    int pivot = arr[ei];
    int i = si-1; //to make place for els smaller then pivot
    for(int j = si;j<ei;j++){
        if(arr[j]<= pivot){
            i++;
            //swop
            int temp = arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }
    i++;
    //swop for to move pivot to keep after smallervalues
    int temp = pivot;
    arr[ei]= arr[i];//donot use pivot = arr[i] it will change the variable not the index
    arr[i] = temp;
    return i;

   }

    public static void main(String[] args){
    int arr [] = {6,3,9,5,2,8};
    quickSort(arr,0,arr.length-1);
    printArr(arr);
   
    }
}
