package src.NeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] ary = new int[]{4,8,20,10,-4,12,6};
        int target = 16;
        System.out.println("Result: "+ Arrays.toString(getTwoSum(ary, target)));
    }

    private static int[] getTwoSum(int[] ary, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<ary.length; i++) {
            int diff = target - ary[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(ary[i], i);
            }
        }
        return new int[]{-1, -1};
    }

}
