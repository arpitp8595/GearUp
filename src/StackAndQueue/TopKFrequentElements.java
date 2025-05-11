package StackAndQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3}; int k = 2;
        System.out.println("Top K Frequent Elements are: "+ Arrays.toString(topKFrequent(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Edge case, if k equals the length of nums, return nums directly
        if (k == nums.length)
            return nums;

        int res[] = new int[k];  // Array to store result
        HashMap<Integer, Integer> hm = new HashMap<>(); // To store frequency of elements

        // Step 2: Count frequency of each number
        for (int n : nums)
            hm.put(n, hm.getOrDefault(n, 0) + 1);

        // Step 3: Create a max-heap (priority queue) sorted by frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));

        // Step 4: Insert all elements from hashmap into the max-heap
        for (int i : hm.keySet())
            pq.offer(i);

        // Step 5: Extract top k elements from heap and store in result array
        for (int i = 0; i < k; i++)
            res[i] = pq.poll();

        return res; // Return the k most frequent elements
    }
}
