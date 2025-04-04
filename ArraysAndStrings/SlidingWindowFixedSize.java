package ArraysAndStrings;


// ?. Max Sum of Subarray of Size K

public class SlidingWindowFixedSize {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int maxSum = maxSumSizeK(arr, 3);
        System.out.println(maxSum);
    }

    static int maxSumSizeK(int[] nums, int k){
        int maxSum = 0;
        int windowSum = 0;

        for(int i=0;i<k;i++){
            windowSum += nums[i];
        }

        maxSum = Math.max(windowSum,maxSum);

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i];
            windowSum -= nums[i-k];
            maxSum = Math.max(maxSum,windowSum);
        }

        return maxSum;
    }
}
