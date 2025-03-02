import java.util.*;

public class Main {
    // Node class to represent each element in the linked list
    public static class Node {
        int data; // Data part of the node
        Node next; // Pointer to the next node

        // Constructor to initialize a node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class implemented using a linked list
    public static class Queue {
        static Node head; // Front of the queue
        static Node tail; // Rear of the queue

        // Method to check if the queue is empty
        public static boolean isEmpty() {
            return head == null && tail == null; // If both head and tail are null, queue is empty
        }

        // Method to add (enqueue) an element to the queue
        public static void add(int data) {
            Node newNode = new Node(data); // Create a new node with the given data
            if (head == null) { // If queue is empty, both head and tail will point to the new node
                tail = head = newNode;
                return;
            }
            tail.next = newNode; // Link the last node to the new node
            tail = newNode; // Update the tail to the new node
        }

        // Method to remove (dequeue) an element from the queue
        public int remove() {
            if (isEmpty()) { // If queue is empty, return an error message
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data; // Store the front element
            if (head == tail) { // If only one element is present, reset head and tail
                tail = head = null;
            } else {
                head = head.next; // Move head to the next element
            }
            return front; // Return the removed element
        }

        // Method to return the front element of the queue without removing it
        public int peek() {
            if (isEmpty()) { // If queue is empty, return -1
                return -1;
            }
            return head.data; // Return the front element
        }
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        Queue q = new Queue(); // Create a new queue
        q.add(2); // Enqueue 2
        q.add(4); // Enqueue 4
        q.add(6); // Enqueue 6

        // Loop until the queue is empty, printing and removing elements
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // Print front element
            q.remove(); // Remove front element
        }
    }
}
