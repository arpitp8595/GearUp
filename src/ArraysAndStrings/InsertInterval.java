package src.ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {14, 16}};
        int[] newInterval = {4, 8}; //another set of input: {11, 12};
        int[][] finalIntervals = insertIntervals(intervals, newInterval);
        for (int[] interval: finalIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        int length = intervals.length;

        // Loop through intervals
        while (i < length) {
            if (intervals[i][1] < start) {
                // Non-overlapping interval before newInterval
                result.add(intervals[i]);
            } else if (intervals[i][0] > end) {
                // Non-overlapping interval after newInterval
                break;
            } else {
                // Overlapping interval, merge it
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            i++;
        }

        // Add the merged interval
        result.add(new int[]{start, end});

        // Add the remaining intervals
        while (i < length) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}