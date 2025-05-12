import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Step 1: Use a HashSet to store unique elements from nums
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);  // removes duplicates automatically
        }

        // Step 2: Create an array arr2 from the set
        int[] arr2 = new int[set.size()];
        int i = 0;
        for (int n : set) {
            arr2[i++] = n; // copy each unique element into arr2
        }

        // Step 3: Sort arr2 to get increasing order
        Arrays.sort(arr2);

        // Step 4: Apply LCS between original array and sorted unique array
        return lcs(nums, arr2);
    }

    // Function to find the length of Longest Common Subsequence
    // between arr1 and arr2
    public static int lcs(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // Step 5: Create a 2D dp array where dp[i][j] stores the LCS length
        // for first i elements of arr1 and first j elements of arr2
        int[][] dp = new int[n + 1][m + 1];

        // Step 6: Fill dp table using bottom-up dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If elements match, take diagonal + 1
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Else, take max of left and top cell
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 7: The bottom-right cell contains the answer
        return dp[n][m];
    }
}
