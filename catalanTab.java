import java.util.*;

public class Main {

    // Function to compute the nth Catalan number using tabulation (Bottom-Up DP)
    public static int catalanTab(int n) {
        int dp[] = new int[n + 1];  // dp[i] stores the i-th Catalan number

        // Base cases: C(0) = 1, C(1) = 1
        dp[0] = 1;
        dp[1] = 1;

        // Fill dp[2] to dp[n] using the recursive formula:
        // C(n) = Σ (C(i) * C(n - i - 1)) for i = 0 to n - 1
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];  // Add product of two smaller subproblems
            }
        }

        return dp[n];  // Return the nth Catalan number
    }

    public static void main(String args[]) {
        int n = 4;  // Change this value to compute other Catalan numbers
        System.out.println(catalanTab(n));  // Output the result
    }
}
