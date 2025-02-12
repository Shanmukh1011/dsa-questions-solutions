
import java.util.*;

public class Code {

    public static void main(String[] args) {
        
        int arr[] = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();

        sS(arr, result, new ArrayList<>(), 0,);
        System.out.println(result);

    }

    public static void sS(int arr[], List<List<Integer>> result, List<Integer> subSet, int i) {
        int n = arr.length;
        if(i==n){
           result.add(new ArrayList<>(subSet));
            return;
        }
        sS(arr, result, subSet, i + 1);
        subSet.add(arr[i]);
        sS(arr, result, subSet, i + 1);
        subSet.remove(subSet.size()-1);
        
        
        
    }
}
