import java.util.*;

public class Main {
    public static void main(String[] args) { // O(n log n) complexity
        // Given pairs (start, end)
        int pairs[][] = {
            {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}, {45, 49}
        };

        // Sort pairs based on the second element (end time) in ascending order
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;  // Minimum chain length starts at 1
        int chainEnd = pairs[0][1]; // Store the end of the first pair

        // Iterate through the sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) { // If the current pair can follow the previous one
                chainLength++;  // Increase chain length
                chainEnd = pairs[i][1]; // Update the last used pair's end time
            }
        }

        // Output the maximum chain length
        System.out.println("Maximum length of chain: " + chainLength);
    }
}
