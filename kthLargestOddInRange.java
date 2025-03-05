import java.util.*;

public class Main {

    // Function to find the Kth largest odd number in the range [L, R]
    public static int kthLargest(int L, int R, int K) {
        int count = 0; // To count the number of odd numbers encountered

        // Start the loop from the largest odd number within [L, R]
        // If R is odd, start from R; otherwise, start from R-1 (nearest odd number)
        for (int i = (R % 2 == 1) ? R : R - 1; i >= L; i -= 2) { 
            count++; // Increment the count as we find an odd number
            
            // If we have found the Kth largest odd number, return it
            if (count == K) {
                return i;
            }
        }
        
        // If there are fewer than K odd numbers in the range, return 0
        return 0;
    }

    public static void main(String args[]) {
        // Define the range [L, R] and K value
        int L = -10, R = 10, K = 6;

        // Call the function to get the Kth largest odd number
        int ans = kthLargest(L, R, K);

        // Print the result
        System.out.println(ans);
    }
}
