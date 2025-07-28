import java.util.*;
public class Main{
    public static boolean isDistint(int nums[]){
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int profit(int price[]){
        int n = price.length;
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0;i<n;i++){
            if(price[i]>buyPrice){
                int profit = price[i]- buyPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
            else{
                buyPrice = price[i];
            }
        }
        return maxProfit;
    }
    public static int trapedWater(int height[]){
        int n = height.length;
        int totWater = 0;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];


        //left boundry;
        leftMax[0] = height[0];
        for(int i = 1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        //right boundry;
        rightMax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        for(int i = 0;i<n;i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            if(waterLevel>height[i]){
                totWater+=waterLevel-height[i];
            }
        }
        return totWater;

    }
    public static void main(String args[]){
        int nums [] = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(profit(nums));
//        System.out.println(isDistint(nums));
        System.out.println(trapedWater(nums));
    }
}
