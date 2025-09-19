package ArraysAndStrings.Algorithm;


// Time Complexity: O(n)
// Used to find the largest sub-array sum.

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] nums = {4,-5,2,-2,7,5};
        int maxSum = Kadanes(nums);
        System.out.println("Maximum Sub-array sum is:" + maxSum);
    }

     static int KadanesAlgo(int[] nums){
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;

        for(int i=0;i<n;i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum,currSum);
            if(currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    static int Kadanes(int[] nums){
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;

        for(int num: nums){
            currSum += num;
            maxSum = Math.max(maxSum,currSum);
            currSum = Math.max(currSum,0);
        }
        return maxSum;
    }
}




