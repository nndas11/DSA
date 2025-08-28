package BinarySearch.answersBS.MinOnMaxOrMaxOnMin;




//  Aggressive Cows
//  Problem Statement: You are given an array of integers stalls where stalls[i] represents the
//  position of the ith stall. You are also given an integer cows. You want to place cows
//  in the stalls such that the minimum distance between any two cows is as large as possible.
//  Return the largest minimum distance possible between any two cows.

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        System.out.println(aggressiveCows(new int[]{0,3,4,7,10, 9}, 4));
    }


//    So while finding the min distance, we only need to check for adjacent cows. As they will only have the minimum distance as they are the closest.
//    To find the maximum of search space -> consider case of 2 cows, they will be placed at the extreme ends, so max distance will be max - min.
    public static int aggressiveCows(int[] stalls, int cows){
        int n = stalls.length;
        Arrays.sort((stalls));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int stall : stalls) {
            max = Math.max(max, stall);
            min = Math.min(min, stall);
        }

        int l = 1; // minimum distance can be 1
        int r = max - min; // maximum distance can be max - min
        int ans = 0;

        while(l <= r){
            int mid = l +(r - l)/2;
            if(isPossible(stalls, cows, mid)){
                ans = mid;
                l = mid + 1; // try for a larger minimum distance
            } else {
                r = mid - 1; // try for a smaller minimum distance
            }
        }
        return  ans;
    }

    public static boolean isPossible(int[] stalls, int cows, int minDist){
//        do it greedily
        int count = 1; // place the first cow in the first stall.
        int lastPos = stalls[0];

        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - lastPos >= minDist){
                count++;
                lastPos = stalls[i];
            }

            if(count == cows)
                    return true;
        }

        return false;
    }
}
