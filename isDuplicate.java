import java.util.*;

public class Main {

    // Function to check if a string has valid parentheses
    public static boolean isVallied(String str) {
        Stack<Character> s = new Stack<>();

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If it's an opening bracket, push it onto the stack
            if (ch == '[' || ch == '{' || ch == '(') {
                s.push(ch);
            } else {
                // If we encounter a closing bracket but the stack is empty, it's invalid
                if (s.isEmpty()) {
                    return false;
                } else {
                    // Get the top element from the stack (last pushed opening bracket)
                    char top = s.peek();

                    // Check if the current closing bracket matches the last opened one
                    if ((top == '{' && ch == '}') ||
                        (top == '[' && ch == ']') ||
                        (top == '(' && ch == ')')) {
                        s.pop(); // If matched, remove the top bracket from the stack
                    } else {
                        return false; // If mismatched, return false
                    }
                }
            }
        }

        // If the stack is empty after processing, it means all brackets matched correctly
        return s.isEmpty();
    }

    // Function to check for duplicate parentheses
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If we encounter a closing parenthesis ')'
            if (ch == ')') {
                int count = 0;

                // Pop elements until an opening bracket '(' is found
                while (s.peek() != '(') {
                    count++;
                    s.pop();
                }

                // If there were no elements between ( ), it's a duplicate
                if (count < 1) {
                    return true;
                } else {
                    s.pop(); // Pop the opening bracket '('
                }
            } else {
                // Push all characters except closing brackets
                s.push(ch);
            }
        }
        
        // If no duplicate parentheses were found, return false
        return false;
    }

    public static void main(String[] args) {
        String str = "(a+b)"; // Example input
        System.out.println(isDuplicate(str)); // Output: false
    }
}
