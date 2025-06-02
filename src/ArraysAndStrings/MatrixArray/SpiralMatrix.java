package src.ArraysAndStrings.MatrixArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println("Output of SpiralMatrix: "+getSpiralMatrix(matrix));
        //Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    //O(m*n) O(1)
    private static List<Integer> getSpiralMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right on top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom on right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Only if there's a row left to traverse
            if (top <= bottom) {
                // Traverse from right to left on bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Only if there's a column left to traverse
            if (left <= right) {
                // Traverse from bottom to top on left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}