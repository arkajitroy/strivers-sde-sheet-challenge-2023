import java.util.*;

class Job {
  int id;
  int deadline;
  int profit;

  public Job(int id, int deadline, int profit) {
    this.id = id;
    this.deadline = deadline;
    this.profit = profit;
  }
}
class Solution {
  public static int jobScheduling(int[][] jobs) {
    int n = jobs.length;

    // Create Job objects and sort them in descending order based on profit
    Job[] sortedJobs = new Job[n];
    for (int i = 0; i < n; i++) {
      sortedJobs[i] = new Job(i, jobs[i][0], jobs[i][1]);
    }
    Arrays.sort(sortedJobs, (a, b) -> b.profit - a.profit);

    int maxDeadline = 0;
    for (int[] job: jobs) {
      maxDeadline = Math.max(maxDeadline, job[0]);
    }

    int[] result = new int[maxDeadline + 1];
    Arrays.fill(result, -1);

    int totalProfit = 0;

    // Iterate through sorted jobs and assign them to available slots
    for (Job job: sortedJobs) {
      int slot = job.deadline;

      while (slot > 0 && result[slot] != -1) {
        slot--;
      }

      if (slot > 0) {
        result[slot] = job.id;
        totalProfit += job.profit;
      }
    }

    return totalProfit;
  }
}