import java.util.*;
public class Main{
    public static int maxHistogramArea(int heights[]){
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i = 0;i <n;i++ ){
            int currHeight = (i == n) ? 0:heights[i];
            while(!s.isEmpty() && currHeight < heights[s.peek()]){
                int height = heights[s.pop()];
                int width = s.isEmpty()?i:i- s.peek()-1;
                maxArea= Math.max(maxArea,height*width);
            }
            s.push(i);

        }
        return maxArea;
    }
    public static void main(String args []){
        int heights[] = {2, 1, 5, 6, 2, 3};
        System.out.println("Maximum Area of Histogram: " + maxHistogramArea(heights));
    }


}
