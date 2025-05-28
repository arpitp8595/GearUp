package src.TwoPointers;

import java.util.PriorityQueue;

public class MaximumNumberOfRobots {
    public static void main(String[] args) {
        int[] chargeTimes = {3,6,1,3,4};
        int[] runningCosts = {2,1,3,4,5};
        int budget = 25;
        System.out.println("Maximum Robots required: "+maximumRobots(chargeTimes, runningCosts, budget)); //O/P: 3
    }

    //https://www.youtube.com/watch?v=sRZFiWxuUiE
    //O(NlogN)
    //O(N)
    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // Max-heap to keep track of the maximum chargeTime in the current window
        // The comparator (a,b)->b-a ensures elements are ordered in descending order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)->b-a);

        long sum = 0; // Sum of running costs in the current window
        int left = 0;    // Left pointer of the sliding window (start)
        int right = 0;    // Right pointer of the sliding window (end)
        int max = 0;  // Result: maximum number of consecutive robots within budget

        // Expand the window by moving the right pointer 'right'
        while (right < chargeTimes.length) {
            // Add the current robot's chargeTime to the max-heap
            maxHeap.add(chargeTimes[right]);
            // Add the current robot's running cost to the sum
            sum += runningCosts[right];

            // Calculate the current cost: max chargeTime + (number of robots * sum of running costs)
            // If within budget, update the maximum number of robots
            if (maxHeap.peek() + maxHeap.size() * sum <= budget) {
                max = Math.max(max, (right - left + 1));
            }
            else {
                // If over budget, shrink the window from the left until within budget or window is empty
                while (!maxHeap.isEmpty() && maxHeap.peek() + maxHeap.size() * sum > budget) {
                    // Remove the leftmost robot's chargeTime from the heap
                    maxHeap.remove(chargeTimes[left]);
                    // Subtract its running cost from the sum
                    sum -= runningCosts[left];
                    // Move the left pointer forward
                    left++;
                }
            }
            // Move the right pointer forward to expand the window
            right++;
        }
        return max;
    }
}
