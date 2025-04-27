package Recursion;


//  A Subsequence is a contagious or non-contagious sequence which follows order.
//

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        allSubsequence(0, arr, new ArrayList<>());
    }


    public static void allSubsequence(int index, List<Integer> arr, List<Integer> subset){

        if(index >= arr.size()){
            System.out.println(subset);
            return;
        }

        allSubsequence(index + 1, arr, subset);

        subset.add(arr.get(index));
        allSubsequence(index + 1, arr, subset);
        subset.remove( subset.size() - 1);

    }
}
