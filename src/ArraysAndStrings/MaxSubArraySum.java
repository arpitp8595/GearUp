package src.ArraysAndStrings;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum of the sub-array: " +getMaxSum(nums));
    }

    //Given an integer array nums, find the subarray with the largest sum, and return its sum
    public static int getMaxSum(int[] nums) {
        // Initialize maxSum to the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;

        // Variable to keep track of the sum of the current subarray
        int currentSum = 0;

        // Iterate through each element of the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the running sum
            currentSum += nums[i];

            // Update maxSum if the currentSum is greater than maxSum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // If currentSum becomes negative, reset it to 0
            // because a negative sum will not contribute to a maximum subarray
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum sum found
        return maxSum;
    }
}
