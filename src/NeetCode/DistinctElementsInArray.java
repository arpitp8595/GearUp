package src.NeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistinctElementsInArray {
    public static void main(String[] args) {
        int[] numbers={0,5,5,4,3,1,4,5,4,5};
        System.out.println("Result: " + Arrays.toString(getDistinct(numbers)));
    }

    private static Object[] getDistinct(int[] numbers) {
        Set<Integer> set=new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        return set.toArray();
    }
}
