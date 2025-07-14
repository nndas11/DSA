package DynamicProgramming.Strings;

//  Substring -> characters are consecutive.



public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(space("abcd", "abvd"));
    }


//    Here we do not carry the answer forward -> as it is substring.
//    Each is independent of others.
//    So if the characters are matching -> we check whether the previous character were matching or not and add the result
//    same as subsequence
//    The difference is when characters are not matching -> here we don't need to split like the subsequence -> just put 0.
//    Here we take the maximum value in the matrix.
//    TC: O(n*m)
    public static int longestCommonSubstring(String s1, String s2){
        int[][] dp = new int[s2.length() + 1][s2.length() + 1];

        int len = 0;

        for (int i=1;i<=s1.length();i++){
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;
                len = Math.max(len, dp[i][j]);

            }
        }
        return len;
    }

    public static int space(String s1, String s2){
        int[] prev = new int[s2.length() + 1];

        int len = 0;

        for (int i=1;i<=s1.length();i++){
            int[] curr = new int[s2.length() + 1];
            for (int j=1;j<=s2.length();j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = 0;
                len = Math.max(len, curr[j]);
            }
            prev = curr;
        }
        return len;
    }
}
