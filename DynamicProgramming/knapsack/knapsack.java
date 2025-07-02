package DynamicProgramming.knapsack;

//  If we have n number of items.
//  Each item has a weight and value.
//  The theif has a bag with capacity of "w" weight.
//  We need to maximize the value he could steal.

//  Greedy approach won't work because the law of uniformity is not there.

//  So second approach would be to try all possible combination -> recursion with backtracking.
//  And find the best total combination.

//  So this is actually the subsequence problem only.

//  Always think of base-case -> in terms of single element.

//  This comes under DP with subsequence
//  f(ind, bagWeight)
//  pick or not pick
//  Max on all possibilities.

//  Always tabulation -> gives us a lot of insights.


//  TC: 2^n
//  SC: O(n)

//  AFTER MEMOIZATION
//  TC: O(n*m).
//  SC: O(n*m) + O(n).

//  With tabulation, we can remove the stack space in the space complexity.

import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        int n= 3;
        int[] value = {30, 40, 60};
        int[] weight = {3, 2, 5};

//        System.out.println(knapsack(value, weight, 6, n));

        System.out.println(spaceOptimised2(value, weight, 6));
    }

    public static int knapsack(int[] value, int[] weight, int bagWeight, int n){
        int[][] dp = new int[n][bagWeight + 1];
        for (int[] row: dp){
            Arrays.fill(row, -1);
        }

        return dp(n - 1, bagWeight, value, weight, dp);
    }

    public static int dp(int index, int W, int[] value, int[] weight, int[][] dp){

        if(index == 0){
            if (weight[0] <= W)
                return value[0];
            return 0;
        }

        if (dp[index][W] != -1)
            return dp[index][W];

        int notTake = dp(index - 1, W, value, weight, dp);
        int take = Integer.MIN_VALUE;

        if(weight[index] <= W){
            take = value[index] + dp(index - 1, W -weight[index], value, weight, dp);
        }

        return dp[index][W] = Math.max(take, notTake);

    }

    public static int tabulation(int[] value, int[] weight, int W){
        int[][] dp = new int[value.length][W + 1];

        for (int i=weight[0];i<=W;i++){
               dp[0][i] = value[0];
        }

        for (int i=1;i<value.length;i++){
            for (int j=0;j<=W;j++){
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= j){
                    take = value[i] + dp[i - 1][W - weight[i]];
                }

                dp[i][j] = Math.max(take, notTake);
            }
        }


        return dp[value.length - 1][W];
    }

    public static int spaceOptimised(int[] value, int[] weight, int W){
        int[] prev = new int[W + 1];

        for (int i=weight[0];i<=W;i++){
            prev[i] = value[0];
        }

        for (int i=1;i<value.length;i++){
//            int[] curr = new int[W + 1];
            for (int j=0;j<=W;j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= j){
                    take = value[i] + prev[W - weight[i]];
                }

                prev[j] = Math.max(take, notTake);
            }
//            prev = curr;
        }


        return prev[W];
    }

//    We can further space optimise this.
//    Using only one array instead of two.
//    Just fill the weight in the reverse way.

    public static int spaceOptimised2(int[] value, int[] weight, int W){
        int[] prev = new int[W + 1];

        for (int i=weight[0];i<=W;i++){
            prev[i] = value[0];
        }

        for (int i=1;i<value.length;i++){
            int[] curr = new int[W + 1];
            for (int j=W;j>=0;j--){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                if(weight[i] <= j){
                    take = value[i] + prev[W - weight[i]];
                }

                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }


        return prev[W];
    }
}
