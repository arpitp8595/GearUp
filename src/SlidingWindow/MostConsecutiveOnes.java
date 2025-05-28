package src.SlidingWindow;

public class MostConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,0};
        System.out.println("Result: "+findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
