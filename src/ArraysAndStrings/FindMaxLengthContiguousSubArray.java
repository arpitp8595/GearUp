package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLengthContiguousSubArray {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,1,1,0,0,0,0,0};
        System.out.println("MaxLength of SubArray: "+getMaxLength(nums));
    }

    public static int getMaxLength(int[] nums) {

        int sum = 0; // Initialize the sum to track the cumulative sum
        int subArrayLength = 0; // Initialize the maximum subarray length
        Map<Integer, Integer> map = new HashMap<>(); // Map to store cumulative sum and its index

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 to -1 to treat the problem as the longest subarray with sum zero
            if (nums[i] == 0) {
                nums[i] = -1;
            }

            sum += nums[i]; // Update the cumulative sum

            // If cumulative sum is zero, update subArrayLength to include the whole array up to i
            if (sum == 0) {
                subArrayLength = i + 1;
            } else {
                // If the cumulative sum has been seen before, update the subArrayLength
                if (map.containsKey(sum)) {
                    subArrayLength = Math.max(subArrayLength, i - map.get(sum));
                } else {
                    // Otherwise, record the index of the cumulative sum
                    map.put(sum, i);
                }
            }
        }
        return subArrayLength; // Return the maximum subarray length found
    }
}