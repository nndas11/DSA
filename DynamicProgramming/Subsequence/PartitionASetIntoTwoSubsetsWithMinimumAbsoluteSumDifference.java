package DynamicProgramming.Subsequence;


//  Leetcode question has negative elements in the array -> so this solution won't work.

//  So here we know the totalSum, we need to find diff between s1 and s2.
//  If we find s1, then s2 = totalSum - s1 only.

//  So the DP - array, dp[i][j] -> here means whether from 0 - i index there is a j target subset is present or not.
//  so we need to check in the whole array
//  so the last row, we can check whether each target from 1 to totalSum is present or not and find the absolute minimum difference.

public class PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    public static void main(String[] args) {
        System.out.println("Minimum Absolute Difference is: " + partitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference(new int[]{1,2,3,4}));
    }

    public static int partitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference(int[] nums){
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums)
            totalSum += num;

        int minDiff = Integer.MAX_VALUE;

        int target = totalSum/2;
        boolean[][] dp = new boolean[n][target + 1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target)
            dp[0][nums[0]] = true;

        for(int i=1;i<n;i++){
            for(int j = 1;j<=target;j++){
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if(nums[i] <= j)
                    take = dp[i - 1][j - nums[i]];
                dp[i][j] = notTake || take;

                if(i == n - 1 && dp[i][j])
                    minDiff = Math.min(minDiff, Math.abs(j - (totalSum - j)));
            }
        }


        return minDiff;
    }
}
