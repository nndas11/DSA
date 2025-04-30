package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SubsetSum {
    static HashSet<Integer> result = new HashSet<>();
    public static void main(String[] args) {
        int[] arr = {3,1,4};
        List<Integer> ans = new ArrayList<>();
        subsetSum(0, arr, ans, 0);
        System.out.println(ans);
        Collections.sort(ans);
        System.out.println(result);
    }

    public static void subsetSum(int index, int[] arr, List<Integer> ans, int sum){
        if(index == arr.length){
            result.add(sum);
            return;
        }

//        take element
        subsetSum(index + 1, arr, ans, sum + arr[index]);

//        not taking
        subsetSum(index + 1, arr, ans, sum);
    }
}
