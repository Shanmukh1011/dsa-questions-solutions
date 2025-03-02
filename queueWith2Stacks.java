import java.util.*;

public class Main {
    public static class Queue {
        Stack<Integer> s1 = new Stack<>();  // Main stack
        Stack<Integer> s2 = new Stack<>();  // Temporary stack

        // Check if queue is empty
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // Add element to the queue (O(n) complexity)
        public void add(int data) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Push new element into s1
            s1.push(data);

            // Move elements back from s2 to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove element from the queue (O(1) complexity)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // Get front element of the queue (O(1) complexity)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(2);
        q.add(4);
        q.add(6);
        q.add(8);
        q.add(10);

        // Print and remove all elements from the queue
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
