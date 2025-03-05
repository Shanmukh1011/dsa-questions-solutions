import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Dimensions of the board (n x m)
        int n = 4, m = 6;

        // Cost arrays for vertical and horizontal cuts
        Integer costVer[] = {4, 3, 2, 1, 1}; // Vertical cut costs
        Integer costHor[] = {4, 2, 1}; // Horizontal cut costs

        // Step 1: Sort the costs in descending order (Greedy approach)
        Arrays.sort(costHor, Collections.reverseOrder()); // Sorting horizontal costs
        Arrays.sort(costVer, Collections.reverseOrder()); // Sorting vertical costs

        // Step 2: Initialize variables
        int v = 0, h = 0; // Pointers for costVer and costHor arrays
        int vp = 1, hp = 1; // Number of vertical and horizontal pieces
        int cost = 0; // Total cost

        // Step 3: Greedy approach to minimize the cost of cuts
        while (v < costVer.length && h < costHor.length) {
            // If horizontal cut cost is greater than or equal to vertical cut cost
            if (costVer[v] <= costHor[h]) { 
                // Make a horizontal cut
                cost += (costHor[h] * vp); // Multiply cost by current vertical pieces
                h++; // Move to the next horizontal cut
                hp++; // Increase the number of horizontal pieces
            } else {
                // Make a vertical cut
                cost += (costVer[v] * hp); // Multiply cost by current horizontal pieces
                v++; // Move to the next vertical cut
                vp++; // Increase the number of vertical pieces
            }
        }

        // Step 4: Process remaining vertical cuts
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        // Step 5: Process remaining horizontal cuts
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            vp++;
            h++;
        }

        // Step 6: Print the minimum cost
        System.out.println("Minimum cost of cuts = " + cost);
    }
}
