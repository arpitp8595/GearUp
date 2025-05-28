package src.TwoPointers;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15}; int target = 9;
        System.out.println("Two Sum 2: "+ Arrays.toString(twoSum2(nums, target)));
    }
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers
// such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
// where 1 <= index1 < index2 <= numbers.length.
    public static int[] twoSum2(int[] nums, int target) {
        int lp = 0; int rp = nums.length-1;
        while(lp < rp) {
            if (nums[lp] + nums[rp] == target) {
                return new int[] {lp+1, rp+1};
            } else if(nums[lp] + nums[rp] < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return new int[]{-1, -1};
    }
}
