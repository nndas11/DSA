package Backtracking;

// Backtracking Algorithm Steps:
//  1. Make a decision.
//  2. Recursion.
//  3. Base-case of recursion.
//  4. Undo the decision.

//  Famous Problems:
//  Subsets, Generate Parenthesis


// This is basically used for exhaustive search, like all solutions

import java.util.ArrayList;
import java.util.List;

public class Backtracking {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets(arr, solution, 0, subset);
        System.out.println(solution.toString());
    }

    public static void subsets(int[] arr, List<List<Integer>> solution, int i, List<Integer> subset){
        if(i == arr.length){
            solution.add(new ArrayList<>(subset));
            return;
        }
        subsets(arr,solution, i +1,subset);

        subset.add(arr[i]);
        subsets(arr, solution, i+1, subset);
        subset.remove(subset.size() - 1);
    }
}
