package src.TwoPointers.leetcodeEasy;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Final Result: " + Arrays.toString(moveZeroes(nums)));
    }

    private static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1};
        }

        int lastNonZeroIndex = 0;
        // First pass: move all non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
            }
        }

        // Second pass: fill remaining positions with 0
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
