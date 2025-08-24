package DynamicProgramming.Subsequence;

//  Bitonic subsequence can be just increasing and then decreasing or just increasing or just decreasing.

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestBitonicSubsequence(new int[]{0, 10, 2, 5, 2}));
    }

    public static int longestBitonicSubsequence(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(arr[prev] < arr[i] && dp[prev] + 1 > dp[i])
                    dp[i] = dp[prev] + 1;
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for(int i=n-1;i>=0;i--){
            for(int prev=n-1;prev >i;prev--){
                if(arr[prev] < arr[i] && dp2[prev] + 1 > dp2[i])
                    dp2[i] = dp2[prev] + 1;
            }
        }

        int maxLength = 0;

//        rewrite in the same array to save space
        for(int i=0;i<n;i++){
            dp[i] = dp[i] + dp2[i] - 1;
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
