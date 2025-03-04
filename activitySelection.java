import java.util.*;
public class Main{
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //sorting if the end is not sorted
        int Activities[][] = new int[start.length][3];
        for(int i = 0;i < start.length;i++){
            Activities[i][0] = i;
            Activities[i][1] = start[i];
            Activities[i][2] = end[i];
        }
        //lamdafunction -> shortform;
        Arrays.sort(Activities,Comparator.comparingDouble(o -> o[2]));

        // end time base sorting
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //picking 1st activity
        maxAct = 1;
        ans.add(Activities[0][0]);// 1st activity
        int lastEnd = Activities[0][2];
        for(int i = 1; i < start.length;i++){
            if(Activities[i][1] >= lastEnd){
                maxAct++;
                ans.add(Activities[i][0]);
                lastEnd = Activities[i][2];
            }
        }

        System.out.println("Maximum activities = " + maxAct);
        for(int i = 0;i<ans.size();i++){
            System.out.print("A " + ans.get(i) + " ");
        }


    }
}
