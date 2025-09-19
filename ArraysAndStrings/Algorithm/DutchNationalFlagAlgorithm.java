package ArraysAndStrings.Algorithm;

//  Sort an array of 0s, 1s and 2s in a single traversal.
//  Dutch National Flag Algorithm.
//  TC: O(n)
//  SC: O(1)

//  Cannot guarantee the order of elements.

public class DutchNationalFlagAlgorithm {
    public static void main(String[] args) {

    }

    private static void dutchNationalFlagAlgorithm(int[] arr, int pivot){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high){
            if(arr[mid] < pivot){
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == pivot){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
