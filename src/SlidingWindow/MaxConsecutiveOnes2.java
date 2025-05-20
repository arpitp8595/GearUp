package SlidingWindow;

public class MaxConsecutiveOnes2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; int k = 2;
        System.out.println("Result: "+longestOnes(nums, k));
    }
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
// if you can flip at most k 0's.
    public static int longestOnes(int[] nums, int k) {
        int left = 0, maxLength = 0, zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
