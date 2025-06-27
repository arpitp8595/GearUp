package src.PrefixSuffix;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println("Pivot Index is: "+getPivotIndex(nums));
    }

    private static int getPivotIndex(int[] nums) {
        int rightSum = 0, leftSum = 0;
        for (int n: nums) {
            rightSum += n;
        }

        for (int i=0; i< nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
