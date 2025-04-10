package BinarySearch;


//  Binary Search finding the breaking point.
//  This is the condition based binary search.
//  Here we need to make L = R

public class ConditionBased {
    public static void main(String[] args) {
        boolean[] arr = new boolean[]{false,false,true,true,true};
        System.out.println(conditionBasedBinarySearch(arr));
    }

//    We are trying to find the index of first True.
    public static int conditionBasedBinarySearch(boolean[] arr){
        int l = 0;
        int r = arr.length;

        while(l < r){
            int m = l + (r-l)/2;
            if(arr[m] == true){
                r = m;
            }else{
                l = m + 1;
            }
        }

        return l;
    }
}
