package src.SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        SelectionSort sorter = new SelectionSort();
        int[] arr={64, 25, 12, 22, 11};
        sorter.selectionSort(arr);
        System.out.println("Done.!");
    }
//Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly selecting the smallest (or largest) element from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.

//First we find the smallest element and swap it with the first element. This way we get the smallest element at its correct position.
//Then we find the smallest among remaining elements (or second smallest) and swap it with the second element.
//We keep doing this until we get all elements moved to correct position.
    public void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i=0; i<len-1; i++) {
            int min_idx = i;

            for (int j=i+1; j<len; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
        System.out.println("Selection Sort: "+ Arrays.toString(arr));
    }
}
