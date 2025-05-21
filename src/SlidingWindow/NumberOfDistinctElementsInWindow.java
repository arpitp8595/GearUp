package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctElementsInWindow {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        System.out.println("Total Distinct Elements available in Kth window element: "+ Arrays.toString(getDistinctElements(nums, k)));
    }

    private static int[] getDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int l = 0;
        for (int r=k-1; r<n; r++) {
            Set<Integer> set = new HashSet<>();
            for (int i = l; i <= r; i++) {
                set.add(nums[i]);
            }
            result[r-k+1] = set.size(); l++;
        }
        return result;
    }

    private static int[] getDistinctElements1(int[] nums, int k) {
        int n = nums.length;
        // Edge case for invalid k
        if (k <= 0 || k > n) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Initialize the frequency map for the first window
        for (int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        result[0] = freqMap.size(); // Store the distinct count for the first window

        // Slide the window from the start to the end of the array
        for (int r = k; r < n; r++) {
            // Remove the element going out of the window
            int leftElement = nums[r - k];
            freqMap.put(leftElement, freqMap.get(leftElement) - 1);
            if (freqMap.get(leftElement) == 0) {
                freqMap.remove(leftElement); // Remove the element if its count is 0
            }

            // Add the new element in the window
            int rightElement = nums[r];
            freqMap.put(rightElement, freqMap.getOrDefault(rightElement, 0) + 1);

            // Store the count of distinct elements in the result array
            result[r - k + 1] = freqMap.size();
        }
        return result;
    }
}