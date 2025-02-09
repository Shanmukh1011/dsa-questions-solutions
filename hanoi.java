
 
public class timepass {
    static void towerOfHanoi(int n, char from_rod, 
                             char to_rod, char aux_rod) { 
 
        // Base Case
        if (n == 0) { 
            return; 
        } 
 
        // Move n-1 disk from rod A (from_rod) to rod B (aux_rod).
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod); 
 
        // Move nth disk from rod A (from_rod) to rod C (to_rod).
        System.out.println("Move disk " + n + " from rod "
                           + from_rod + " to rod "
                           + to_rod); 
 
        // Move n-1 disk from rod B (aux_rod) to rod C (to_rod).
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod); 
    } 
 
    public static void main(String args[]) 
    { 
        int N = 3; 
 
        // A, B and C are names of rods 
        towerOfHanoi(N, 'A', 'C', 'B'); 
    } 
}
 
