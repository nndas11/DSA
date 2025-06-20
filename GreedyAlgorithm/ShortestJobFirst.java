package GreedyAlgorithm;


//  This is a Scheduling Algorithm.
//  Here in each step we select the process with the shortest execution time.

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        System.out.println("Average Waiting time is: " + shortestJobFirst(new int[]{4, 1, 5, 2, 6, 3}));
    }

    public static int shortestJobFirst(int[] processes){
        Arrays.sort(processes);
        int t = 0, waitTime = 0;

        for(int process: processes){
            waitTime += t;
            t += process;
        }

        return waitTime/processes.length;
    }
}
