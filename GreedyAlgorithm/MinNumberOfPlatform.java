package GreedyAlgorithm;

//  Given the arrival and departure time of each time.
//  We need to find the minimum number of platforms needed to accommodate it.
//  maximum number of guests present at the same time given arrival and departure times — which is a classic interval overlap problem.


//  So here, a new platform will be needed when we have an intersection.
//  Brute Force:
//  here we try to find the intersection against each train.
//  Nested loop and takes O(n2) time.


//  Optimal Way:
//  sort the times, and we use counter which gets increased on arrival and departed on departure.
//  the max value of the counter is our answer.
//  So we can sort them add in a separate data structure with identification for arrival and departure -> but this takes extra space.
//  Without extra space -> sort and use two pointers.

import java.util.Arrays;

public class MinNumberOfPlatform {
    public static void main(String[] args) {
        int[] arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println(bruteForce(arrival, departure));
    }

    private static int bruteForce(int[] arrival, int[] departure){
        int ans = 0;
        int n = arrival.length;

        for(int i=0;i<n;i++){
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && arrival[j] < departure[i] && departure[j] > arrival[i]) {
                    // guest j overlaps with guest i
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

    private static int helper(int[] arrival, int[] departure){
        int ans = 0;
        int count = 0;
        int n = arrival.length;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0;
        int j = 0;

        while(i < n && j < n){
            if(arrival[i] < departure[j]){
                count++;
                i++;
            }else {
                count--;
                j++;
            }
            ans = Math.max(ans, count);

        }

        return ans;
    }
}
