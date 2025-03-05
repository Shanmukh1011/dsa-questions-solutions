import java.util.*;

public class Main {
    
    // Job class to store job details
    public static class Job {
        int deadLine; // Deadline of the job
        int profit;   // Profit associated with the job
        int id;       // Job ID (0 -> A, 1 -> B, 2 -> C, etc.)

        // Constructor to initialize a job
        public Job(int i, int d, int p) {
            id = i;
            deadLine = d;
            profit = p;
        }
    }

    public static void main(String[] args) { // Time Complexity: O(nlogn)

        // Job information in the format {deadline, profit}
        int jobInfo[][] = { {4, 20}, {1, 10}, {1, 40}, {1, 10} };

        // List to store job objects
        ArrayList<Job> jobs = new ArrayList<>();

        // Creating job objects and adding them to the list
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // Sorting jobs in descending order of profit (Greedy approach)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // List to store the selected job sequence
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0; // Track the current time slot

        // Traversing through the sorted job list
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i); // Get the current job
            
            // If the job's deadline allows us to schedule it, add to the sequence
            if (curr.deadLine > time) {
                seq.add(curr.id); // Add job ID to sequence
                time++; // Increment the scheduled job count
            }
        }

        // Printing the results
        System.out.println("Maximum jobs that can be scheduled = " + time);
        System.out.println("Job sequence (Job IDs): " + seq);
    }
}
