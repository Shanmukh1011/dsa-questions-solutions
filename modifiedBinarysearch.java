
class Code {
    public static int searchT(int arr[],int target, int si,int ei){
        if(si>ei){
            return -1;
        }

        //kaam
        int mid = si+(ei-si)/2;

        //key found
        if(arr[mid]==target){
            return mid;
        }

        //mid in line 1
        if(arr[si]<=arr[mid]){
           
            if(arr[si]<=target&&target<=arr[mid]){
                //case a for left
                return searchT(arr,target,si,mid-1);
            }else{
                //case b for right
                return searchT(arr,target,mid+1,ei);

            }
        }
        //mid in line 2
        else{
            if(arr[mid]<=target&&target<=arr[ei]){
                //case c for right
                return searchT(arr,target,mid+1,ei);

            }else{
                //case d for left
                return searchT(arr,target,si,mid-1);
            }
        

        }
       
    
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 1;
       int tar =  searchT(arr,target,0,arr.length-1);
       System.out.println(tar);

    }
}
