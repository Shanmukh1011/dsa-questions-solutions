import java.util.*;

public class Main {

    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) {
            arr.add(val);
            int childIdx = arr.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            // Bubble up
            while (childIdx > 0 && arr.get(childIdx) < arr.get(parentIdx)) {
                // Swap
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parentIdx));
                arr.set(parentIdx, temp);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        public int peek() {
            if (arr.isEmpty()) throw new NoSuchElementException("Heap is empty");
            return arr.get(0);
        }

        private void heapify(int i) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.size() && arr.get(left) < arr.get(smallest)) {
                smallest = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(smallest)) {
                smallest = right;
            }

            if (smallest != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(smallest));
                arr.set(smallest, temp);

                heapify(smallest);
            }
        }

        public int remove() {
            if (arr.isEmpty()) throw new NoSuchElementException("Heap is empty");

            int data = arr.get(0);

            // Swap root with last element
            int lastIdx = arr.size() - 1;
            arr.set(0, arr.get(lastIdx));
            arr.remove(lastIdx);

            // Restore heap property
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.isEmpty();
        }
    }

    public static void main(String[] args) {
        MinHeap pq = new MinHeap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
