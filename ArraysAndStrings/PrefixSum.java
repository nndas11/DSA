package ArraysAndStrings;


// A Prefix Sum Array is an array where each element at index i stores the sum of all elements from the start up to index i in the original array.

//  Why Use It?
//  To answer range sum queries efficiently — especially when you need to compute the sum of elements between two indices multiple times.
//  Instead of recalculating the sum every time (which takes O(n)), prefix sums let you answer each query in O(1) after an O(n) preprocessing.


//  Use Cases
//  Fast range sum queries
//  Sub-array sum problems (e.g., “count sub-arrays that sum to k”)
//  Difference arrays (for range updates)
//  2D prefix sums (for matrices)


// ?.  Given an array arr, return the sum of elements from index i to j multiple times efficiently.

public class PrefixSum {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int[] prefixSum = buildPrefixSum(arr);

        int sum1 = rangeSum(prefixSum, 1, 3); // 4+6+8 = 18
        int sum2 = rangeSum(prefixSum, 0, 4); // 2+4+6+8+10 = 30

        System.out.println("Sum from index 1 to 3: " + sum1);
        System.out.println("Sum from index 0 to 4: " + sum2);
    }

//    Prefix sum array.
    public static int[] buildPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        return prefixSum;
    }

    public static int rangeSum(int[] prefixSum, int i, int j) {
        if (i == 0) {
            return prefixSum[j];
        }
        return prefixSum[j] - prefixSum[i - 1];
    }
}
