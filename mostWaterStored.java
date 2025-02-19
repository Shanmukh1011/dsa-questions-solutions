                        import java.util.*;

class Code{


    public static int storeWater(ArrayList<Integer> list){
        int water = 0;
        for(int i = 0;i<list.size();i++){
            for(int j = i+1;j<list.size();j++){
                int height = Math.min(list.get(i),list.get(j));
                int width = j-i;
                water = Math.max(water,height*width);
            }
        }
        return water;
    }
    public static int mostWaterOpt(ArrayList<Integer> list){
        int left = 0,right = list.size()-1,storedWater = 0;
        while(left < right){
            int height = Math.min(list.get(left),list.get(right));
            int width = right - left;
            storedWater = Math.max(storedWater,height*width);
            //revise the below code whenever you see this..
            if(list.get(left)<list.get(right))
            left++;
            else
            right--;
        }
        return storedWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //1,8,6,2,5,4,8,3,7;
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        //System.out.println(storeWater(list));
        System.out.println(mostWaterOpt(list));
        
    }
}

