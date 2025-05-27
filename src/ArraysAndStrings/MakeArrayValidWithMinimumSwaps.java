package ArraysAndStrings;

public class MakeArrayValidWithMinimumSwaps {
    public static void main(String[] args) {
    int[] nums = {3, 1, 5, 4, 2};
    System.out.println("Minimum Swaps required to make an array valid: "+minimumSwaps(nums));
    }
    /**
     * Calculates the minimum number of swaps needed to bring:
     * 1. The smallest element to the start of the array
     * 2. The largest element to the end of the array
     * TC: O(n) - Single pass through the array
     * SC: O(1) - Uses constant extra space
     */
    public static int minimumSwaps(int[] nums) {
        // Initialize tracking variables:
        // max: stores the largest value found (start with minimum possible)
        // min: stores the smallest value found (start with maximum possible)
        // maxIndex: stores the position of the largest value
        // minIndex: stores the position of the smallest value
        int max = -1, min = Integer.MAX_VALUE, maxIndex = 0, minIndex = 0;

        // First pass through the array to identify:
        // - The smallest element and its position
        // - The largest element and its position
        for(int i = 0; i < nums.length; i++) {
            // Check for new minimum value
            if(nums[i] < min) {
                min = nums[i];      // Update smallest value found
                minIndex = i;       // Update position of smallest value
            }
            // Check for new maximum value (using >= to get the rightmost max if duplicates exist)
            if(nums[i] >= max) {
                max = nums[i];      // Update largest value found
                maxIndex = i;       // Update position of largest value
            }
        }

        // Special case handling:
        // If the smallest element is to the right of the largest element,
        // moving the largest element to the end will shift the smallest element's position left by 1
        if(minIndex > maxIndex) {
            minIndex--;  // Adjust the position of the smallest element accordingly
        }

        // Calculate total swaps needed:
        // - (nums.length - maxIndex - 1): swaps needed to move max to end
        // - minIndex: swaps needed to move min to start
        return (nums.length - maxIndex - 1) + minIndex;
    }
}
