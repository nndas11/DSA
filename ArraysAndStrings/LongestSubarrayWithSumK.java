package ArraysAndStrings;

//  Given an array of integers and an integer k, find the length of the longest subarray that sums to k.
//  If no such subarray exists, return 0.

//  Brute Force: Subarray Problem -> so generate all subarrays and check for sum.
//  TC: O(n^2)
//  SC: O(1)


import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        System.out.println(longestSubarrayWithSumK(new int[]{1, -1, 5, -2, 3}, 3));
    }

    private static int longestSubarrayWithSumK(int[] arr, int k){
        return optimal(arr, k);

    }

    private static int bruteForce(int[] arr, int k){
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum == k){
                    maxLength = Math.max(maxLength, (j - i + 1) );
                }
            }
        }


        return maxLength;
    }

    private static int optimal(int[] arr, int k){
        int n = arr.length;
        int maxLength = 0;
        int prefixSum = 0;

//         prefix sum + hashmap approach can be used here.
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // to handle the case when prefixSum itself is k.

        for(int i=0;i<n;i++){
            prefixSum += arr[i];
            if(map.containsKey((prefixSum - k)))
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));

            map.putIfAbsent(prefixSum, i); // only put if not already present to maintain the longest length.
        }
        return maxLength;
    }
}
