package DynamicProgramming;


import java.util.Arrays;

//  Only need a small modification to convert the problem from subsequence to a non-adjacent problem.
public class MaxSumOfNonAdjacentElements {
    public static void main(String[] args) {
        System.out.println("Maximum Sum of Non-adjacent Elements is:" + maxSumOfNonAdjacentElements(new int[]{1,2,3}, 2));
        int[] dp = new int[3];
        Arrays.fill(dp, -1);
        System.out.println("Maximum Sum of Non-adjacent Elements is:" + maxSumOfNonAdjacentElementsDPTabulationSpaceOptimised(new int[]{1,2,3}, dp,2));
    }

//    TC: O(2^n)
    public static int maxSumOfNonAdjacentElements(int[] arr, int index){
        if(index == 0)
            return arr[index];
        if(index < 0)
            return 0;

        int pick = arr[index] + maxSumOfNonAdjacentElements(arr, index - 2);
        int nonPick = maxSumOfNonAdjacentElements(arr, index - 1);

        return Math.max(pick, nonPick);
    }

//    TC: O(n)
    public static int maxSumOfNonAdjacentElementsDPOptimised(int[] arr, int[] dp, int index){
        if(index == 0)
            return arr[index];
        if(index < 0)
            return 0;

        if(dp[index] != -1)
            return dp[index];


        int pick = arr[index] + maxSumOfNonAdjacentElementsDPOptimised(arr, dp, index - 2);
        int nonPick = maxSumOfNonAdjacentElementsDPOptimised(arr, dp, index - 1);

        dp[index] = Math.max(pick, nonPick);
        return dp[index];
    }

    public static int maxSumOfNonAdjacentElementsDPTabulation(int[] arr, int[] dp, int n){
        dp[0] = arr[0];

        for(int i=1;i<=n;i++){
            int pick = arr[i] + ((i - 2) < 0 ? 0 : dp[i - 2]);
            int nonPick = dp[i-1];

            dp[i] = Math.max(pick, nonPick);
        }
       ;

        return dp[n];
    }

    public static int maxSumOfNonAdjacentElementsDPTabulationSpaceOptimised(int[] arr, int[] dp, int n){
        int prev2 =  0;
        int prev1 = arr[0];

        for(int i=1;i<=n;i++){
            int pick = arr[i] + ((i - 2) < 0 ? 0 : prev2);
            int nonPick = prev1;

            int curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        ;

        return  prev1;
    }
}
