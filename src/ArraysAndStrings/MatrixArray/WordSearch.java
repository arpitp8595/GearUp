package src.ArraysAndStrings.MatrixArray;
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word1 = "ABCCED";
        System.out.println(exist(board, word1)); // Output: true

        String word2 = "SEE";
        System.out.println(exist(board, word2)); // Output: true

        String word3 = "ABCB";
        System.out.println(exist(board, word3)); // Output: false
    }

    // Time Complexity: [ O(m \times n \times 4^L) ]
    //Space Complexity: O(m \times n)
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // Traverse each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the first character matches, start backtracking
                if (board[i][j] == word.charAt(0) && backtrack(board, word, visited, i, j, 0)) {
                    return true; // Return true if the word is found
                }
            }
        }
        return false; // Return false if the word is not found
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        // Base case: if the entire word is found
        if (index == word.length()) {
            return true;
        }

        // Check for boundaries and if the cell is already visited or does not match the character
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true; // Mark the cell as visited

        // Explore in all four possible directions
        if (backtrack(board, word, visited, i + 1, j, index + 1) || // down
                backtrack(board, word, visited, i - 1, j, index + 1) || // up
                backtrack(board, word, visited, i, j + 1, index + 1) || // right
                backtrack(board, word, visited, i, j - 1, index + 1)) { // left
            return true;
        }

        visited[i][j] = false; // Backtrack, unmark the cell
        return false; // Return false if the word is not found in any direction
    }
}
