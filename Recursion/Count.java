package Recursion;


//  pseudo code
//  int f(){
//      base case
//            return 1 -> condition satisfied
//            return 0 -> condition not satisfied
//      l = f()         s = 0                   -> this if there is a lot recursion calls -> example is N-Queen Problem.
//      r = f()         for(i i -> n)
//                          s+= f()
//      return l + r;   return s
//  }


import java.util.ArrayList;
import java.util.List;

public class Count {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        System.out.println(countSum(arr, 0, 0, new ArrayList<>(), 2));
    }

    public static int countSum(List<Integer> arr, int index, int currSum, List<Integer> curSubset, int target){
        if(index == arr.size()){
            if(currSum == target){
                return 1;
            }
            return 0;
        }

//        taking element.
//        curSubset.add(arr.get(index));
        int l = countSum(arr, index + 1, currSum + arr.get(index), curSubset, target);
//        curSubset.remove(curSubset.size() - 1);

//        Not taking
        int r = countSum(arr, index + 1, currSum, curSubset, target);
        return l + r;

    }
}
