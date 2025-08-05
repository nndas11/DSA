package BinarySearch;

//  If answer not found, we are returning length of array.

public class LowerUpperBound {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 8, 10, 10, 11, 11};
        System.out.println(lowerBound(arr, 10));
    }


//    lower-bound -> Need to find the smallest index such that arr[index] >= target.
//    arr can contain same element multiple times.
//    So many leetcode questions are internally lower-bound only -> eg:- search insert position.
    private static int lowerBound(int[] arr, int target){
        int ans = arr.length;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] >= target){
                ans = mid;
                r = mid - 1;
            }else
                l = mid + 1;
        }

        return ans;
    }

//    upper-bound -> the smallest index such that arr[ind] > target.
    private static int upperBound(int[] arr, int target){
        int ans = arr.length;

        int l = 0;
        int r = arr.length - 1;

        while (l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] > target){
                ans = mid;
                r = mid - 1;
            }else
                l = mid + 1;
        }

        return ans;
    }
}
