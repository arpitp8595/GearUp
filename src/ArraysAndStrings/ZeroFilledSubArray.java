package ArraysAndStrings;

public class ZeroFilledSubArray {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        System.out.println("Total number of Sub-arrays: "+zeroFilledSubarray(nums));
    }

    //Given an integer array nums, return the number of subarrays filled with 0.
    //Input: nums = [1,3,0,0,2,0,0,4]
    //Output: 6
    //Explanation:
    //There are 4 occurrences of [0] as a subarray.
    //There are 2 occurrences of [0,0] as a subarray.
    //There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

    private static long zeroFilledSubarray(int[] nums) { //O(N) O(1)
        long totalZeroSubarrays = 0; // Total count of zero-filled subarrays
        long countOfCurrentZeroSubarrays = 0; // Count of consecutive zero-filled subarrays

        // Iterate through each number in the array
        for (int num : nums) {
            if (num == 0) {
                // If the number is zero, increment the current zero subarray count
                countOfCurrentZeroSubarrays++;
                // Add the current zero subarray count to the total
                totalZeroSubarrays += countOfCurrentZeroSubarrays;
            } else {
                // If the number is not zero, reset the current zero subarray count
                countOfCurrentZeroSubarrays = 0;
            }
        }
        // Return the total count of zero-filled subarrays
        return totalZeroSubarrays;
    }

}
