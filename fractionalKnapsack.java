import java.util.*;

public class Main {
    public static void main(String[] args) {
        double value[] = {60, 100, 120};
        double weight[] = {10, 20, 30};
        double capacity = 50;

        // Store value-to-weight ratio with index
        double ratio[][] = new double[value.length][2];
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i; // Store index
            ratio[i][1] = value[i] / weight[i]; // Store value-to-weight ratio
        }

        // Sort ratios in descending order (greedy approach)
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

        double newCap = capacity;
        double val = 0;

        // Loop through sorted items
        for (int i = 0; i < value.length; i++) {
            int idx = (int) ratio[i][0]; // Get original index
            double itemWeight = weight[idx];
            double itemValue = value[idx];

            if (itemWeight <= newCap) {  // If the item fits entirely
                val += itemValue;
                newCap -= itemWeight;
            } else {  // If only a fraction can be taken
                val += ratio[i][1] * newCap;
                break;  // Knapsack is full
            }
        }

        System.out.println("Maximum value in Knapsack: " + val);
    }
}
