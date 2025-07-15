package DynamicProgramming.Strings;

//  Brute force will be to generate all and compare the length and find the longest common subsequence.
//  But it is Exponential time.

//  So What is the optimised approach?
//  Same way as the DP approach, we start from the end and compare.
//  We have done right shifting -> so be aware of that -> it is only noted when doing the character comparison
//  Otherwise, the recursion call and everything happens in the normal way.

//  To understand, draw the DP array and backtrack -> only way to understand how code works.

//  First need to find the length of longest common subsequence.
//  If character same, then diagonal backward -> here add that character to the answer.
//  Or else, move in the direction of maximum.
//  If the value is same, take any one of it -> as using this DP method we can only print one answer.

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(printLongestCommonSubsequence("bbbaaaba", "bbababbb"));
    }

    public static String printLongestCommonSubsequence(String s1, String s2){
//        find the length of LCM subsequence.
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        int length =  dp[n][m];
        char[] ans = new char[length];
        int index = length - 1;

        int i = n;
        int j = m;

        while (i > 0 && j > 0){
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                ans[index--] = s1.charAt(i - 1);
                i = i - 1;
                j = j - 1;
            }else if(dp[i - 1][j] > dp[i][j - 1])
                i = i -1;
            else
                j = j - 1;

        }

        return Arrays.toString(ans);
    }


}
