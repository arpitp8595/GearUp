package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 22, 2, 7, 11, 15,7};
        int target = 9;
        System.out.println("Result: "+ Arrays.toString(getTwoSum(arr, target)));
    }

    public static int[] getTwoSum(int[] arr, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int diff = target-arr[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(arr[diff]), arr[i]};
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }
}
