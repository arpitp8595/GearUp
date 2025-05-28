package src.BinarySearch;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("Index of target element is: "+getIndexofTarget(nums, target));
    }

    private static int getIndexofTarget(int[] nums, int target) {
        int length = nums.length, s = 0, e = length-1;
        while (s<=e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] < target) {
                s = mid + 1;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
