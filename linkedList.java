import java.util.*;
import  java.util.ArrayList;

class Main{
    // solving problem in two pointer aproach....

    public static int mostWater(ArrayList<Integer> list){
        int height = 0,width = 0,waterStored = 0, left = 0, right = list.size()-1;
        while(left < right){
            //gitting hight;
            height = Math.min(list.get(left),list.get(right));
            // getting width;;
            width = right-left;
            waterStored = Math.max(waterStored,width*height);

            if(list.get(left)<list.get(right)){
                left++;
            }else{
                right--;
            }

        }
        return waterStored;
    }
    public static int storeWater(ArrayList<Integer> list){
        int height =0;
        int water = 0,width = 0;

        for(int i = 0;i <list.size()-1;i++){
            for(int j = i+1;j<list.size();j++){
                height = Math.min(list.get(i),list.get(j));
                width = j-i;
                water = Math.max(water,height*width);

            }
        }
        return water;
    }
    public static boolean targetSum(ArrayList<Integer> list,int tar){
        //int n1 = 0,n2 = 0;

        for(int n1 = 0;n1<list.size()-1;n1++){
            for(int n2 = n1+1;n2 < list.size();n2++){
                if(list.get(n1)+list.get(n2) == tar){
                 return true;
                }
            }
        }
        return false;
    }
    ///  two pointer approach is only usful in sorted array
    public static boolean twoPointertTS(ArrayList<Integer>list,int tar){
        int start = 0,end = list.size()-1;
        while(start < end){
            //case 1
            if(list.get(start)+list.get(end) == tar){
                return true;
            }
            //case 2;
            if(list.get(start)+list.get(end) > tar){
                end--;
            }
            //case 3;
            if(list.get(start)+list.get(end)<tar){
                start++;
            }

        }
        return false;
    }

    public static boolean twoPointerRoated(ArrayList<Integer> list,int tsum){
        // finding the pivot point in the Arraylist///
        int pivot = -1;
        int n = list.size();
        for(int i = 0;i < n-1;i++){
            //if pivot is found;
            if(list.get(i)>list.get(i+1)){
                pivot = i+1;
                break;
            }

        }
        //incase it is not roated;
        if(pivot == -1){
            pivot = 0;
        }
        // while writing i confused here so observe it properly;
        int right = (pivot-1+n)%n;
        int left = pivot ;
        while(left != right) {//i forget to add while loop here

            if (list.get(left) + list.get(right) == tsum) {
                return true;
            }
            if (list.get(left) + list.get(right) > tsum) {
                right = (right - 1 + n) % n;
            } else {
                left = (left + 1) % n;
            }

        }
        return false;
    }


    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        //1,8,6,2,5,4,8,3,7;
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
       // System.out.println(storeWater(list));
        //System.out.println(mostWater(list));
        //System.out.println(targetSum(list,45));
        //System.out.println(twoPointertTS(list,18));
        ArrayList<Integer> rotatedList = new ArrayList<>(Arrays.asList(6,7,8,9,1,2,3,4,5));
        System.out.println(twoPointerRoated(rotatedList,53));

    }
}
