package BinarySearch.answersBS;

//  Given N ans M
//  Find the Nth root of M?

//  In Binary Search, we just need to check weather element is greater, equal to or greater than.

public class NthRoot {
    public static void main(String[] args) {
        System.out.println(nthRootOfM(3, 27));
    }

    private static int nthRootOfM(int n, int m){
        int l = 0;
        int r = m - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            long ans = helper(mid, n, m);

            if(ans == 0)
                return mid;
            else if(ans == 2)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

//    checking with m is done here itself.
//    When the answer goes above m, we can return as we only need to check weather greater than, less than or equal to x.
//    This will help us with overflow case, as if we go on multiplying it can be a very large no.
    private static long helper(int mid, int n, int m){
        long ans = 1;
        for(int i =1;i<=n;i++){
            ans = ans * mid;
            if(ans > m)
                return 2;
        }
        if(ans == m)
            return 0;
        return 1;
    }
}
