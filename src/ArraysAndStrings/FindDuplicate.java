package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,4};
        System.out.println("Duplicate number: "+findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<=nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
            else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
