package src.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("Three Sum: "+ getThreeSum(nums));
    }

    private static List<List<Integer>> getThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Skip the element if it's the same as the previous one to avoid duplicates
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // Initialize two pointers
            int j = i + 1;
            int k = nums.length - 1;
            // While the left pointer is less than the right pointer
            while (j < k) {
                // Calculate the sum of the three numbers
                int total = nums[i] + nums[j] + nums[k];

                // If the sum is greater than zero, move the right pointer leftward
                if (total > 0) {
                    k--;
                }
                // If the sum is less than zero, move the left pointer rightward
                else if (total < 0) {
                    j++;
                }
                // If the sum is equal to zero, we've found a triplet
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // Move the left pointer rightward to the next different number to avoid duplicates
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
