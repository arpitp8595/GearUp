package SlidingWindow;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Result: "+minSubArrayLen(target, nums));
    }

    //https://leetcode.com/problems/minimum-size-subarray-sum/solutions/5908815/video-sliding-window-solution-by-niits-ywp6/
    public static int minSubArrayLen(int target, int[] nums) { //O(N) O(1)
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int curSum = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];

            while (curSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                curSum -= nums[left];
                left++;
            }
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
