package ArraysAndStrings.Algorithm;

//   Majority Element leetcode 169
//   Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. You may assume that the array is non-empty and the majority element always exists in the array.
//   Moore's Voting Algorithm
//   TC: O(n)
//   SC: O(1)

public class MooresVotingAlgorithm {
    public static void main(String[] args) {

    }

    private static int mooresVotingAlgorithm(int[] arr){
        int candidate = -1;
        int count = 0;

        for(int num: arr){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
