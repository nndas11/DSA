package BinarySearch.TwoDArray;

//  Median of Row-wise sorted matrix.
//  Each row is sorted but the columns are not sorted.
//  Find the median of the matrix in O(32 * n * log(m)) time
//  where n is the number of rows and m is the number of columns.
//  The idea is to use binary search on the range of elements in the matrix.

//  here also both n amd m are odd -> so the median will be the middle element.

//  Brute Force Approach:
//  1. Store all the elements of the matrix in a 1-d array.
//  2. Sort the array.
//  3. Return the middle element of the array.
//  The time complexity is O(n * m log(n * m)) and space complexity is O(n * m).


public class MedianRowWiseSortedMatrix {
    public static void main(String[] args) {
        System.out.println(medianRowWiseSortedMatrix(new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        }, 3, 3)); // Output: 5}));
    }

    public static int medianRowWiseSortedMatrix(int[][] matrix, int n, int m) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        int requiredCount = (n * m) / 2; //  as both n and m are odd, so the median will be the middle element.

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallEqual(matrix, n, m, mid);
            if (smallEqual <= requiredCount)
                low = mid + 1;
            else
                high = mid - 1; // mid is too large, so we need to search in the left half


        }

        return low;
    }

    private static int countSmallEqual(int[][] matrix, int n, int m, int mid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i], m, mid);
        }
        return count;
    }

    private static int upperBound(int[] matrix, int n, int x) {
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid] <= x) {
                l = mid + 1; // mov // move to the left side
            } else {
               r = mid - 1;
            }

        }
        return l; // l will be the index of the first element greater than x
    }
}
