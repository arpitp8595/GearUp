package src.SlidingWindow;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        System.out.println("Distinct Elements available in Kth window element: "+ Arrays.toString(getDistinctElements(nums, k)));
    }

    public static int[] getDistinctElements(int[] nums, int k) {
        // Handle edge cases: empty array or window size 0
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }

        // Initialize result array - number of windows is n-k+1
        int[] result = new int[n - k + 1];

        // Deque to store indices of elements in the current window
        // We'll maintain it in decreasing order of their values
        Deque<Integer> win = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Step 1: Remove indices that are outside the current window
            // Elements at these indices are no longer in the window
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();  // Remove from front
            }

            // Step 2: Remove indices of elements smaller than current element
            // Since they can't be the maximum in any window containing current element
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();  // Remove from back
            }

            // Step 3: Add current element's index to the deque
            win.offerLast(i);

            // Step 4: If we've processed at least k elements, record the maximum
            // The maximum is always at the front of the deque
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }

    private static int[] getDistinctElements1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int l = 0;
        for (int r=k-1; r<n; r++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
            for (int i = l; i <= r; i++) {
                maxHeap.offer(nums[i]);
            }
            result[r-k+1] = maxHeap.poll(); l++;
        }
        return result;
    }
}