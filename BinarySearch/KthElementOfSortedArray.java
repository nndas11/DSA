package BinarySearch;

public class KthElementOfSortedArray {
    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{2,3,6,7,9}, new int[]{1,4,8,10}, 5));
    }

//    Similar to median of two sorted arrays
    private static int kthElement(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;

        if(n > m) {
            return kthElement(arr2, arr1, k); // Ensure arr1 is the smaller array
        }


//        this is difficult part to understand
//        if k is less than the size of smaller array, then we can take 0 elements from the larger array
//        if k is more than the size of larger array, then we have to take at least k - size of larger array elements from the smaller array
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while(low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 < n)   r1 = arr1[mid1];
            if(mid2 < m)   r2 = arr2[mid2];

            if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1];
            if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if(l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1; // This line should never be reached
    }
}
