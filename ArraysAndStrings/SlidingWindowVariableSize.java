package ArraysAndStrings;


// ?. Find the length of the longest subarray with a sum less than or equal to a given number k

public class SlidingWindowVariableSize {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 0, 1, 1, 0};
        int sum = 4;
        int result = longestSubarrayWithSumAtMostK(arr, sum);
        System.out.println("Longest subarray with sum ≤ " + sum + " is of length: " + result);
    }

    static int longestSubarrayWithSumAtMostK(int[] arr, int k){
        int maxLength = 0;
        int currSum = 0;
        int left = 0;
        int right = 0;

        while(right < arr.length){
            currSum += arr[right];

//            fails constraint and we shrink the window.
            while(currSum > k && left <= right){
                currSum -= arr[left];
                left++;
            }

            maxLength = Math.max(maxLength, (right - left) + 1);
            right++;
        }

        return maxLength;
    }

}
