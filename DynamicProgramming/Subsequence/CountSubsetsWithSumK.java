package DynamicProgramming.Subsequence;

import java.util.Arrays;

//  TC: O(2^n) -> O(n * target) -> after DP
//  SC: O(n*target) + O(n)

//  So this solution works when there is no 0.
//  In the given question -> constraint was actually, each element is greater than or equal to 1.
//  Where is the PROBLEM in the current code:
//      base-case -> target == 0 -> so it won't go deep in the recursion when target = 0. regardless of the index.
//  So we can update the code to include this condition

//  How to update the problem to include the case of 0?
//  POSSIBLE ONE SOLUTION: Find no of zeros in the array -> so total way to represent is: 2^n.
//  Now answer * 2^n -> total no of ways.

//


//  All these we are doing works for positive integers
//  What happens for negative integers ->
//  because the 2-d array can't have negative indexes -> so how will we solve this

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1};
        int target = 1;
//        we need to take target + 1 -> as we are looking for the target.
        int[][] dp = new int[arr.length][target + 1];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        System.out.println(countSumK(arr.length - 1, arr, target, dp));
//        System.out.println(tabulation(arr, 3));
    }

    public static int countSumK(int index, int[] arr, int taget, int[][] dp){
//        if(taget == 0)
//            return 1;

        if(index == 0){
//            For cases including 0
//            3 cases possible
//            1. arr[0] = 0 and target = 0 -> so 2 ways -> take or not take.
//            2. arr[0] != 0 and target = 0 -> so 1 way -> not take.
//            3. arr[0] = target ->             so 1 way -> take.

            if(taget == 0 && arr[0] == 0)   return 2;
            if(taget == 0 || arr[0] == taget)  return 1;
            return 0;

//            if(arr[index] == taget)
//                return 1;
//            return 0;
        }

        if(dp[index][taget] != -1)
            return dp[index][taget];

        int count = 0;

//        not take
        count += countSumK(index - 1, arr, taget, dp);

//        pick
        if(arr[index] <= taget){
            count += countSumK(index - 1, arr, taget - arr[index], dp);
        }

        return dp[index][taget] = count;
    }

    public static int tabulation(int[] arr, int target) {
        int[][] dp = new int[arr.length][target + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = 1;

//        for index = 0 -> base case already written -> above 2 line -> default value = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= target; j++) {
                int count = 0;

//        not take
                count += dp[i - 1][j];

//        pick
                if (arr[i] <= j) {
                    count += dp[i - 1][j - arr[i]];
                }
                dp[i][j] = count;
            }
        }


            return dp[arr.length - 1][target];
        }

    public static int spaceOptimised(int[] arr, int target) {
        int[] prev = new int[target + 1];

//        for (int i = 0; i < arr.length; i++) {
            prev[0] = 1;
//        }

        if (arr[0] <= target)
            prev[arr[0]] = 1;

        for (int i = 1; i < arr.length; i++) {
            int[] curr = new int[target + 1];
            for (int j = 0; j <= target; j++) {
                int count = 0;

//        not take
                count += prev[j];

//        pick
                if (arr[i] <= j) {
                    count += prev[j - arr[i]];
                }
                curr[j] = count;
            }
            prev = curr;
        }


        return prev[target];
    }

}
