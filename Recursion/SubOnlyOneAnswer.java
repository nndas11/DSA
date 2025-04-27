package Recursion;

//  Technique to print only one answer

//  In the base case, ->  when the condition we are looking is satisfied, then we "return true".
//  Otherwise, we return false.

//  Also, the function call should be in an if-condition block.
//  So, when satisfied, we return true.
//  This makes sure only one answer is taken.
//  Otherwise, we return false.

// Print one combination only.
//  Question -> Combination sum with only one answer needed.

import java.util.ArrayList;
import java.util.List;

public class SubOnlyOneAnswer {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        oneAnswerSum(arr, 0, 0, new ArrayList<>(), 2);
    }

    public static boolean oneAnswerSum(List<Integer> arr, int index, int currSum, List<Integer> curSubset, int target){
        if(index == arr.size()){
            if(currSum == target){
                System.out.println(curSubset);
                return true;
            }
            return false;
        }

//        taking element.
        curSubset.add(arr.get(index));
        if(oneAnswerSum(arr, index + 1, currSum + arr.get(index), curSubset, target))
            return true;
        curSubset.remove(curSubset.size() - 1);

//        Not taking
        if(oneAnswerSum(arr, index + 1, currSum, curSubset, target))
            return true;
        return false;

    }
}
