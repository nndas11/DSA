package ArraysAndStrings;


//  We have to find the number of pairs where the left element is greater than the right element.
//  i < j -> a[i] > a[j].

//  Brute force -> Just do two for-loops to generate all pairs and take the count.
//  TC: O(n2)

//  Optimal Solution -> Using Merge sort with the modified code.
//  We add logic into the merge sort before merging each part.
//  Merge sort just need to include 1 line of code.
//  TC: O(n log n).
//  SC: O(n) -> temporary array.

import java.util.ArrayList;

public class CountInversion {

//    public static int count = 0;

    public static void main(String[] args) {

        System.out.println("Total Numbers of Inversions are: " + countInversionOptimal(new int[]{5, 3, 2, 4, 1}));
    }

    public static int countInversionBruteForce(int[] num){
        int count = 0;

        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i] > num[j])
                    count++;
            }
        }

        return count;
    }

    public static int countInversionOptimal(int[] num){
        return mergeSort(num, 0, num.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right){
        int count  = 0;
        if(left >= right)
            return count;

        int mid = (left + right)/2;

        count += mergeSort(arr, left, mid); //   left half
        count += mergeSort(arr, mid + 1, right); //  right half
        count += merge(arr, left, mid, right);   // merge the sorted halves
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        int count = 0;

        //  Sort the elements into the temp array.
        while (left <= mid && right <= high){
            //  left smaller.
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;

            // left bigger
            }else {
                count += mid - left + 1;

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

        return count;
    }
}
