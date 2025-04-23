import java.util.*;

public class Main {

    // Pair class to hold both value and index of array elements
    // Implements Comparable to allow PriorityQueue to sort by value (max-heap behavior)
    static class Pair implements Comparable<Pair> {
        int val; // value of the array element
        int idx; // index of the array element

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        // Custom comparator to create a max-heap based on the value
        // Higher value comes first
        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void main(String args[]) {
        // Input array and window size
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Result array to store maximums for each window
        int res[] = new int[arr.length - k + 1];

        // PriorityQueue (max-heap) to keep track of the current window's elements
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Process the first window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // The max value of the first window is at the top of the max-heap
        res[0] = pq.peek().val;

        // Process the rest of the windows
        for (int i = k; i < arr.length; i++) {
            // Remove elements from the heap that are outside the current window
            while (!pq.isEmpty() && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            // Add the current element to the heap
            pq.add(new Pair(arr[i], i));

            // The max value for the current window is at the top of the heap
            res[i - k + 1] = pq.peek().val;
        }

        // Print the result array containing the maximum of each window
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
