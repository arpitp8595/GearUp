package src.Queue;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Kth Largest Element in an Array: "+getKthLargestElement1(nums, k));
    }

    private static int getKthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num: nums) {
            minHeap.offer(num);
        }

        for (int i=minHeap.size(); i>k; i--) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    private static int getKthLargestElement1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int i: nums) {
            maxHeap.offer(i);
        }

        int result = 0;
        for(int i=0; i<k; i++){
            result = maxHeap.poll();
        }
        return result;
    }
}
