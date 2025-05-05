import java.util.*;

public class Main {

    // Function to determine if a subset exists with the given target sum
    public static boolean TargetSumSet(int arr[], int sum) {
        int n = arr.length;

        // Create a 2D DP array where dp[i][j] indicates whether a subset of
        // the first 'i' elements can sum up to 'j'
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialization:
        // A sum of 0 is always possible with 0 elements (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                int current = arr[i - 1]; // current element from the array

                // Case 1: Include current element if it's not more than 'j'
                if (current <= j && dp[i - 1][j - current]) {
                    dp[i][j] = true;
                }
                // Case 2: Exclude current element
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                // Otherwise, dp[i][j] remains false
            }
        }

        // The answer will be whether it's possible to form 'sum' using all 'n' elements
        return dp[n][sum];
    }

    public static void main(String args[]) {
        // Input array and target sum
        int arr[] = {4, 2, 7, 1, 3};
        int sum = 10;

        // Call the function and store the result
        boolean ans = TargetSumSet(arr, sum);

        // Output the result
        System.out.print(ans); // Output will be true or false
    }
}
