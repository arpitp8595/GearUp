package src.TwoPointers.leetcodeEasy;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}; int m = 3;
        int[] nums2 = {2,5,6}; int n = 3;
        mergeArrays(nums1, m, nums2, n);
    }

    public static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }

        System.out.println("Result: "+Arrays.toString(nums1));
    }


}
