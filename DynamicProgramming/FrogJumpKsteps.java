package DynamicProgramming;

//  ?. Minimum energy required for the frog to jump to the n - 1 th step. It can jump at-most k steps.
//  if k = 4, then 1, 2 ,3, 4.

//  Variation of previous question -> just need to use for loop.

import java.util.Arrays;

public class FrogJumpKsteps {
    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJumpKSteps(6, 1, heights));
    }

    public static int frogJumpKSteps(int n, int k, int[] heights){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpKStepsHelperTabulation(n - 1, k, heights, dp);
    }

    public static int frogJumpKStepsHelperRecursions(int n, int k, int[] heights){

        if(n == 0)
            return 0;

        int minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n - i >= 0){
                int jump =  frogJumpKStepsHelperRecursions(n - i, k, heights) + Math.abs(heights[n] - heights[n - i]);
                minSteps = Math.min(minSteps, jump);
            }
        }

        return minSteps;
    }

//    TC -> O(n) * k
//    SC -> O(n) + O(n) -> recursion stack and dp

    public static int frogJumpKStepsHelperMemoization(int n, int k, int[] heights, int[] dp){
        if(n == 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];

        int minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n - i >= 0){
                int jump =  frogJumpKStepsHelperRecursions(n - i, k, heights) + Math.abs(heights[n] - heights[n - i]);
                minSteps = Math.min(minSteps, jump);
            }
        }
        dp[n] = minSteps;
        return dp[n];
    }

    public static int frogJumpKStepsHelperTabulation(int n, int k, int[] heights, int[] dp){
        dp[0] = 0;

        for(int j=1;j<=n;j++){
            int minSteps = Integer.MAX_VALUE;
            for(int i=1;i<=k;i++){
                if(j - i >= 0){
                    int jump = dp[j - i] + Math.abs(heights[j] - heights[j - i]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[j] = minSteps;
        }
        return dp[n];
    }
}
