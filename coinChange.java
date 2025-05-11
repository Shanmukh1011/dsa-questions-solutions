import java.util.*;

public class Main {
    
    // Function to calculate the number of combinations to make up the given amount using the coins
    public static int coinChange(int coins[], int amt) {
        int n = coins.length;

        // dp[i][j] will store the number of ways to make amount 'j' using the first 'i' coins
        int dp[][] = new int[n + 1][amt + 1];

        // Base case: There is 1 way to make amount 0 — by choosing no coin
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {           // Loop over each coin
            for (int j = 1; j <= amt; j++) {     // Loop over each amount from 1 to amt
                if (coins[i - 1] <= j) {
                    // If the coin can be included, we add:
                    // 1. Ways to make (j - coins[i-1]) using the current coin again (dp[i][j - coins[i-1]])
                    // 2. Ways to make j without using the current coin (dp[i - 1][j])
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    // If the coin cannot be included, we take the value from the previous row
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The final answer is the number of ways to make amount 'amt' using all 'n' coins
        return dp[n][amt];
    }

    public static void main(String args[]) {
        int coins[] = {1, 2, 5, 10};  // Array of available coin denominations
        int amt = 15;                 // Target amount

        // Print the number of combinations to make up the amount
        System.out.println(coinChange(coins, amt));
    }
}
