package DynamicProgramming.Subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
    public static void main(String[] args) {
        System.out.println(printLIS(new  int[]{5,4,11,1,16,8}));
    }

    // TC: O(n2).
    // To print LIS -> this solution is needed
//     trace back LIS.
//    To back track, we use another array -> which keep track of the previous index.
    private static int printLIS(int[] nums){
        int n = nums.length;
        int ans = 0;
        int maxIndex = 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for(int i=0;i<n;i++)
            hash[i] = i;



        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev] < nums[i]){
                    if(1 + dp[prev] > dp[i]){
                        dp[i] =  1 + dp[prev];
                        hash[i] = prev;
                    }

                }
            }
            if(dp[i] > ans){
                ans = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(nums[maxIndex]);
        while (hash[maxIndex] != maxIndex){
            maxIndex = hash[maxIndex];
            result.add(nums[maxIndex]);
        }

        Collections.reverse(result);
        System.out.println(result);

        return ans;
    }
}
