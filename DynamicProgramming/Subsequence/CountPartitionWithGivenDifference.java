package DynamicProgramming.Subsequence;

//  In Array and subsequence problem with 2 subset
//  It may look like intimidating at first -> like how are we going to keep track of two subset and solve
//  But actually we only need to keep track of 1 subset because -> total sum of array - 1 subset sum = 2nd subset sum
//  So while just solving for one subset, the other one will be given away to us just like that.


//  Question?
//  Given an array and difference D.
//  We need to find the total number of ways we can partition the array to two subset.
//  such that s1 >= s2 and s1 - s2 = D.
//  s1 -> sum of subset 1.
//  s2 -> sum of subset 2.

//  s1 = totalSum - s2
//  s1 - s2 = D
//  totalSum - s2 - s2 = D
//  totalSum - 2 * s2 = D
//  s2 = (totalSum - D)/2.


//  so this problem becomes, looking for subsets with target sum = (totalSum - D)/2;
//  so now we just need to find no of subsets with this target sum.


import java.util.Arrays;

public class CountPartitionWithGivenDifference {
    public static void main(String[] args) {
        System.out.println(countPartitionWithGivenDifference(new int[]{5,2,6,4}, 3));
    }

    public static int countPartitionWithGivenDifference(int[] arr, int d){
        int totalSum = 0;
        for(int num: arr){
            totalSum += num;
        }

        if(totalSum - d <= 0 || ((totalSum - d) % 2 != 0))
            return -1;

        int target = (totalSum - d)/2;

        int[][] dp = new int[arr.length][target + 1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


//        return countSubset(arr.length - 1, arr, target, dp);
        return spaceOptimisation(arr, target);
    }

    public static int countSubset(int index, int[] arr, int target, int[][] dp){

        if(index == 0){

            if(target == 0 && arr[0] == 0)   return 2;
            if(target == 0 || arr[0] == target)  return 1;
            return 0;
        }

        if(dp[index][target] != -1)
            return dp[index][target];

        int count = 0;
        count += countSubset(index - 1, arr, target, dp);
        if(arr[index] <= target)
            count += countSubset(index - 1, arr, target - arr[index], dp);

        return dp[index][target] = count;
    }

    public static int tabulation(int[] arr, int target){
        int[][] dp = new int[arr.length][target + 1];

//        return 0; -> this gets added by default -> as initial value of array in JAVA is 0.

        if(arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

//        if arr[0] = 0 -> dp[0][0] = becomes 1 -> which will contradict the first base case we wrote.
        if(arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;

        for (int i=1;i<arr.length;i++){
            for (int j =0;j<=target;j++){
                int count = 0;
                count += dp[i - 1][j];
                if(arr[i] <= j)
                    count += dp[i - 1][j - arr[i]];

                dp[i][j] = count;
            }

        }

        return dp[arr.length - 1][target];
    }

    public static int spaceOptimisation(int[] arr, int target){
            int[] prev = new int[target + 1];

//        return 0; -> this gets added by default -> as initial value of array in JAVA is 0.

            if(arr[0] == 0)
                prev[0] = 2;
            else
                prev[0] = 1;

//        if arr[0] = 0 -> dp[0][0] = becomes 1 -> which will contradict the first base case we wrote.
            if(arr[0] != 0 && arr[0] <= target)
                prev[arr[0]] = 1;

            for (int i=1;i<arr.length;i++){
                int[] curr = new int[target + 1];
                for (int j =0;j<=target;j++){
                    int count = 0;
                    count += prev[j];
                    if(arr[i] <= j)
                        count += prev[j - arr[i]];

                    curr[j] = count;
                }
                prev = curr;
            }

            return prev[target];

    }
}
