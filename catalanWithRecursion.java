import java.util.*;
public class Main{
    public static int catalanNum(int n){
        int ans = 0;
        if(n == 0||n == 1) return 1;
        for(int i = 0;i<n;i++) {
            ans += catalanNum(i) * catalanNum(n - i - 1);
        }
        return ans;
    }
    public static void main(String args[]){
        int n = 4;
        System.out.println(catalanNum(n));
    }

}
