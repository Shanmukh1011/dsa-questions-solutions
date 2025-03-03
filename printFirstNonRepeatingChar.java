import java.util.*;

public class Main {

    public static void printNonRepeating(String str) {
        Queue<Character> q = new LinkedList<>();
        int arr[] = new int[256]; // Using 256 to handle all characters

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            arr[ch]++; // Increase frequency count

            // Remove repeating characters from the queue
            while (!q.isEmpty() && arr[q.peek()] > 1) {
                q.remove();
            }

            // Print the first non-repeating character or -1 if none exist
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println(); // Newline after output
    }

    public static void main(String args[]) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
