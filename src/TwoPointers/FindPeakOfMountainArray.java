package TwoPointers;

public class FindPeakOfMountainArray {
    public static void main(String[] args) {
        int[] nums = {0,1,10,5,2};
        System.out.print("Peak(Index) of an Array: "+getThePeak(nums));
    }

    private static int getThePeak(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n -1;
        while (s<e) {
            int mid = s + (e-s) / 2;
            if (nums[mid+1] > nums[mid]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}
