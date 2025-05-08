package DynamicProgramming;

import java.util.Arrays;

//  ?. Minimum energy required for the frog to jump to the n - 1 th step. It can jump 1 or 2 steps at maximum.

//  Time Complexity: O(n).
//  Space Complexity: O(n).

//  We can optimize this further.
//  Whenever there is n-1 and n-2 --------> WE CAN ALWAYS DO SPACE OPTIMIZATION.

//  1. Convert the problem to index-based. -> n -> min energy taken to jump from 0 to nth step.
//  2. Do everything we can do on the index -> here we can jump 1 and 2 steps.
//  3. Do the operation -> Here we need minimum.
//  4. Convert to DP -> memoization.



//  Base case -> to jump from 0 to 0th index -> 0.

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(6, heights));
    }


//    Memoization -> TOP - DOWN Approach.
    public static int frogJump(int n, int[] heights){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJumpHelperTabulationSpaceOptimized(n-1, heights);
    }

    public static int frogJumpHelperMemoization(int n, int[] heights, int[] dp){
        if(n == 0)
            return 0;

        if(dp[n] != -1)
            return dp[n];

        int left = frogJumpHelperMemoization(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;

        if(n > 1)
            right = frogJumpHelperMemoization(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);

        dp[n] = Math.min(left, right);
        return dp[n];
    }



//    Tabulation -> Bottom - Up Approach.
    public static int frogJumpHelperTabulation(int n, int[] heights, int[] dp){
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

            dp[i] = Math.min(left, right);
        }
        return dp[n];
    }

    public static int frogJumpHelperTabulationSpaceOptimized(int n, int[] heights){
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<=n;i++){
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1)
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int curr = Math.min(left, right);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
