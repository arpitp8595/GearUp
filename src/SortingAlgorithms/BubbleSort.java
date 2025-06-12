package src.SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sorter.bubbleSort(arr);
        System.out.println("Done.!");
    }

//We sort the array using multiple passes. After the first pass, the maximum element goes to end (its correct position). Same way, after second pass, the second-largest element goes to second last position and so on.
//In every pass, we process only those elements that have already not moved to correct position. After k passes, the largest k elements must have been moved to the last k positions.
//In a pass, we consider remaining elements and compare all adjacent and swap if larger element is before a smaller element. If we keep doing this, we get the largest (among the remaining elements) at its correct position.
    /*Time Complexity
        Best: O(n)
        Average: O(n^2)
        Worst: O(n^2)
      Space Complexity
        O(1)*/

    public void bubbleSort(int[] arr) {
        int n=arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
    }
}
