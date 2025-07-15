package GreedyAlgorithm;

//  Each Job has a deadline and a profit associated with it.
//  We need to maximise the profit.
//  Condition -> we can perform only one job in a day and job has to be performed within the deadline.

//  Thinking clear -> sort descending order on profits.
//  Have a slot for each day and fill that slot
//  Fill it as last as possible in backwards -> if deadline 5 -> fill on 5 -> if not possible go backwards.

import java.util.Arrays;

public class JobSequencingProblem {
    public static void main(String[] args) {
        int[][] jobs = {
                {1, 4, 40},
                {2, 1, 10},
                {3, 1, 40},
                {4, 1 ,30}
        };

//        POINT -> we can sort like this 1st job id and then maximum within that
//        Arrays.sort(jobs, (a, b) -> {
//            if(a[0] == b[0])    return Integer.compare(b[1], a[1]); // -> when id same -> profit in DESC
//            else    return Integer.compare(a[0], b[0]); -> when id different -> ID is ASC.
//        });

        System.out.println(jobSequencingProblem(jobs));
    }

//    TC: O(n logn) + O(n)*O(maxDeadline).
//    SC: O(maxDeadline)
    public static int jobSequencingProblem(int[][] jobs){
//        jobId, deadline, profit.
        int n = jobs.length;
        int maxDeadline = 0;
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));

        for(int i=0;i<n;i++)
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);

//        slot 0 -> will be ignored -> as no day 0.
        int[] daySlots = new int[maxDeadline + 1];
        int maxProfit = 0;
        Arrays.fill(daySlots, -1);

        for (int[] job: jobs){
            int jobId = job[0];
            int deadline = job[1];
            int profit = job[2];

//          TC: O(maxDeadline
//          Trying to get free slot and assign the job
            for(int i=deadline;i>=1;i--){
//                we don't care if the latter ones can find a slot -> as maximum profit ones already ahead.
                if(daySlots[i] == -1){
                    daySlots[i] = jobId;
                    maxProfit += profit;
                    break;
                }

            }
        }

        return maxProfit;
    }
}
