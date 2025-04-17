package BinarySearch;

public class BinarySearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println("Index of target: "+getTheIndex(nums, target));
    }

    private static int getTheIndex(int[] nums, int target) {
        int length = nums.length;
        int s = 0, e = length-1;
        while (s < e) {
            int mid = s+ (e-s)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[s] <= nums[mid]) {
                if (nums[s] < target && nums[mid] > target) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            } else {
                if (nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return  nums[s] == target?s:-1;
    }
}
