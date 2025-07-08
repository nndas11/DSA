package DynamicProgramming.Subsequence;

public class RodCuttingProblem {
    public static void main(String[] args) {

    }

    public static int rodCuttingProblem(int n, int[] prices){
        return 0;
    }

    public static int dp(int index, int n, int[] prices, int[][] dp){

        if(index == 0){
            return n * prices[0]; // -> n/1
        }

        if(dp[index][n] != -1)
            return dp[index][n];


        int notTake = dp(index - 1, n, prices, dp);
        int take = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if(rodLength <= n){
            take = prices[index]  + dp(index, n - rodLength, prices, dp);
        }
        return dp[index][n] = Math.max(take, notTake);
    }

    public static int tabulation(int n, int[] pieces){
        int[][] dp = new int[pieces.length][n + 1];

        for (int i=0;i<=n;i++){
            dp[0][i] = i * pieces[0];
        }

        for (int i=1;i<pieces.length;i++){
            for (int j=0;j<=n;j++){
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(rodLength <= n){
                    take =  pieces[i]  + dp[i][j - rodLength];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[pieces.length - 1][n];
    }

    public static int space(int n, int[] pieces){
        int[] prev = new int[n + 1];

        for (int i=0;i<=n;i++){
            prev[i] = i * pieces[0];
        }

        for (int i=1;i<pieces.length;i++){
            int[] curr = new int[n + 1];
            for (int j=0;j<=n;j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(rodLength <= n){
                    take =  pieces[i]  + curr[j - rodLength];
                }
                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[n];
    }

    public static int sp(int n, int[] pieces){
        int[] prev = new int[n + 1];

        for (int i=0;i<=n;i++){
            prev[i] = i * pieces[0];
        }

        for (int i=1;i<pieces.length;i++){

            for (int j=0;j<=n;j++){
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(rodLength <= n){
                    take =  pieces[i]  + prev[j - rodLength];
                }
                prev[j] = Math.max(take, notTake);
            }

        }

        return prev[n];
    }
}
