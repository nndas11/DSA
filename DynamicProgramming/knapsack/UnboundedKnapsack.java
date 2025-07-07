package DynamicProgramming.knapsack;

//  How this different from 0/1 knapsack problem?
//  Here we have infinite supply of the coins.
//  Almost similar to leetcode problem -> coin change 1 and 2.

import Graphs.BellmanFordAlgorithm.Main;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int bagWeight = 6;
        int n = 3;
        int[][] dp = new int[n][bagWeight + 1];
        for (int[] row: dp){
            Arrays.fill(row, -1);
        }

    }

    public static int knapsack(int index, int w, int[] value, int[] weight, int[][] dp){

        if(index == 0){
            return value[index] *(w/weight[index]);
        }

        if(dp[index][w] != -1)
            return dp[index][w];


        int notTake = knapsack(index - 1, w, value, weight, dp);
        int take = Integer.MIN_VALUE;
        if(weight[index] <= w){
            take = value[index] + knapsack(index, w - weight[index], value, weight, dp);
        }

        return dp[index][w] = Math.max(take, notTake);
    }

    public static int tabulation( int w, int[] value, int[] weight){
        int[][] dp = new int[value.length][w + 1];

        for(int i=0;i<=w;i++){
            dp[0][i] = value[0] *(i/weight[0]);
        }

        for(int i=1;i<value.length;i++){
            for(int j=0;j<=w;j++){
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    take = value[i] + dp[i][j - weight[i]];
                }

                dp[i][j] =  Math.max(take, notTake);
            }
        }
        return dp[value.length - 1][w];
    }

    public static int spaceOptimisation( int w, int[] value, int[] weight){
        int[] prev = new int[w + 1];

        for(int i=0;i<=w;i++){
            prev[i] = value[0] *(i/weight[0]);
        }

        for(int i=1;i<value.length;i++){
            int[] curr = new int[w + 1];
            for(int j=0;j<=w;j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= j){
                    take = value[i] + curr[j - weight[i]];
                }

                curr[j] =  Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[w];
    }

//    further optimisation with 1 array.
public static int spaceOptimisaation( int w, int[] value, int[] weight){
    int[] prev = new int[w + 1];

    for(int i=0;i<=w;i++){
        prev[i] = value[0] *(i/weight[0]);
    }

    for(int i=1;i<value.length;i++){
        for(int j=0;j<=w;j++){
            int notTake = prev[j];
            int take = Integer.MIN_VALUE;
            if(weight[i] <= j){
                take = value[i] + prev[j - weight[i]];
            }

            prev[j] =  Math.max(take, notTake);
        }
    }
    return prev[w];
}
}
