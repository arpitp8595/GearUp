package ArraysAndStrings;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("Maximum sum of the subarray: " +getMaxSum(arr));
    }

    public static int getMaxSum(int[] arr) {
        int MaxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i=0; i<arr.length; i++) {
            currentSum += arr[i];

        }
        return MaxSum;
    }
}
