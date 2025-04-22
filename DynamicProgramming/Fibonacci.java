package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibonacciBottomUp(5));
        System.out.println(fibonacciTopDown(5));
        System.out.println(fibonacciOptimized(5));
    }

    public static int fibonacciBottomUp(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibonacciTopDown(int n){
        if(n <= 1)
            return n;

        if(memo.containsKey(n))
            return memo.get(n);

        int result = fibonacciTopDown(n - 1) + fibonacciTopDown(n - 2);
        memo.put(n, result);
        return result;
    }

    public static int fibonacciOptimized(int n) {
        if (n <= 1) return n;

        int prev1 = 1, prev2 = 0;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

}
