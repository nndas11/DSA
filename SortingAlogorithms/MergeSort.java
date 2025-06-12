package SortingAlogorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    public static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,8,7};
        mergeSort(arr,0, arr.length - 1);
        System.out.println("Array after merge sorting: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){

        if(left >= right)
            return;

        int mid = (left + right)/2;

        mergeSort(arr, left, mid); //   left half
        mergeSort(arr, mid + 1, right); //  right half
        merge(arr, left, mid, right);   // merge the sorted halves
    }

    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        //  Sort the elements into the temp array.
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }

//          Any pending left elements.
        while (left <= mid){
            temp.add(arr[left++]);
        }

//        Any pending right elements
        while (right <= high){
            temp.add(arr[right++]);
        }

//        Copy the elements back to the arr from temp array.
        for (int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }
}
