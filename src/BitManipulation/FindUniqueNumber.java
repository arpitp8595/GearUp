package src.BitManipulation;

public class FindUniqueNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2,4,8};
        System.out.println("Unique Number is: "+getUnique(nums));
    }

    private static int getUnique(int[] nums) {
        int result = 0;
        for (int i=0;i< nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
