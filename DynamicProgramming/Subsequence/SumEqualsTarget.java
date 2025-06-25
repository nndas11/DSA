package DynamicProgramming.Subsequence;

//  f(n-1, target) -> always start from this -> meaning from 0 to n - 1 is the target present.
//  to convert DP -> Identify the dependent variables -> those things for which the state is changing.
//  curr[0] = true; -> always in Subsequence.


import java.util.Arrays;

public class SumEqualsTarget {
    public static void main(String[] args) {
        System.out.println(spaceOptimisation(new int[]{1,2,3,4}, 3));
    }


    public static boolean sumEqualsTarget(int[] arr, int target){
        int[][] dp = new int[arr.length][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp(arr.length - 1, target, arr, dp);
    }

    public static boolean dp(int index, int target, int[] arr, int[][] dp){

        if(target == 0)
            return true;

        if(index == 0)
            return arr[0] == target;

        if(dp[index][target] != -1)
            return dp[index][target] == 1;

        boolean notTake = dp(index - 1, target, arr, dp);
        boolean take = false;
        if(arr[index] <= target)
            take = dp(index - 1, target - arr[index], arr, dp);

        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public static boolean tabulation(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length][target+1];

        for(int i=0;i<arr.length;i++){
            dp[i][0] = true;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i=1;i<arr.length;i++){
            for (int j=1;j<=target;j++){
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if(arr[i] <= target)
                    take = dp[i - 1][target - arr[i]];

                dp[i][j] = (take || notTake);
            }
        }
        return dp[arr.length-1][target];
    }

        public static boolean spaceOptimisation(int[] arr, int target){
            boolean[] prev = new boolean[target+1];

//            for(int i=0;i<arr.length;i++){
                prev[0] = true;
//            }

            if (arr[0] <= target)
                prev[arr[0]] = true;

            for (int i=1;i<arr.length;i++){
                boolean[] curr = new boolean[target+1];
                curr[0] = true;
                for (int j=1;j<=target;j++){
                    boolean notTake = prev[target];
                    boolean take = false;
                    if(arr[i] <= target)
                        take = prev[target - arr[i]];

                    curr[j] = (take || notTake);
                }
                prev = curr;
            }
            return prev[target];
        }

}
