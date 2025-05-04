import java.util.*;

public class Main {

    // ===============================
    // Memoization (Top-Down Approach)
    // Time: O(n * W)
    // ===============================
    public static int Knapsack(int val[], int wt[], int W, int n, int[][] dp) {
        // Base Case: No items left or no capacity
        if (n == 0 || W == 0) {
            return 0;
        }

        // If already solved, return the stored result
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        // Choice Diagram
        if (wt[n - 1] <= W) {
            // Option 1: Include the item
            int include = val[n - 1] + Knapsack(val, wt, W - wt[n - 1], n - 1, dp);

            // Option 2: Exclude the item
            int exclude = Knapsack(val, wt, W, n - 1, dp);

            // Take the maximum of both choices
            dp[n][W] = Math.max(include, exclude);
        } else {
            // If item can't be included, skip it
            dp[n][W] = Knapsack(val, wt, W, n - 1, dp);
        }

        return dp[n][W];
    }

    // ============================
    // Tabulation (Bottom-Up DP)
    // Time: O(n * W)
    // ============================
    public static int KnapsackTab(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1]; // dp[i][j] = max value for i items and capacity j

        // Initialize base case: 0 items or 0 capacity -> 0 profit (Java initializes to 0 by default)

        // Build the dp table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int currentVal = val[i - 1];
                int currentWt = wt[i - 1];

                if (currentWt <= j) {
                    // Option 1: Include the current item
                    int include = currentVal + dp[i - 1][j - currentWt];

                    // Option 2: Exclude the current item
                    int exclude = dp[i - 1][j];

                    // Choose the better of the two
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    // Can't include the item, so take the value without it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W]; // Final answer
    }

    public static void main(String[] args) {
        // Item values and weights
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;

        // ===============================
        // Memoization Method
        // ===============================
        int[][] dp = new int[val.length + 1][W + 1];

        // Initialize all entries as -1 (not computed)
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Uncomment below to use memoization:
        // int ans = Knapsack(val, wt, W, val.length, dp);
        // System.out.println("Maximum value (Memoization): " + ans);

        // ===============================
        // Tabulation Method
        // ===============================
        int tabAns = KnapsackTab(val, wt, W);
        System.out.println("Maximum value (Tabulation): " + tabAns);
    }
}
