import java.util.*;

public class Main {

    // Function to check if two strings S and T are anagrams
    public static boolean isAnagram(String S, String T) {
        // Create a HashMap to store character counts from string S
        HashMap<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character in string S
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Increment count or initialize to 1
        }

        // Traverse through string T and reduce the count of each character
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);

            // If character exists in the map, reduce its count
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch); // Remove character if count becomes 0
                } else {
                    map.put(ch, map.get(ch) - 1); // Decrease count by 1
                }
            } else {
                // If character not found in map, strings are not anagrams
                return false;
            }
        }

        // If map is empty, all characters matched and counts balanced => anagram
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String S = "race";
        String T = "care";

        // Call the function and print the result
        System.out.println(isAnagram(S, T)); // Output: true
    }
}
