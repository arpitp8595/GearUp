package src.ArraysAndStrings.MatrixArray;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        // Example usage

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board)); // Output: true
    }

    //Time Complexity: O(9x9) <==> O(81) <==> O(1)
    //Space complexity: O(1)
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>(); // HashSet to track already seen numbers

        // Traverse each row and column in the 9x9 grid
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j]; // Get the current cell value

                // If the cell is not empty, check for duplicate entries
                if (number != '.') {
                    // Check row, column, and 3x3 box constraints
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + (i / 3) + "-" + (j / 3))) {
                        return false; // If duplicate is found, return false
                    }
                }
            }
        }
        return true; // Return true if the board is valid
    }

}

