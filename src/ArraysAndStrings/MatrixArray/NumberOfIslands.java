package src.ArraysAndStrings.MatrixArray;

public class NumberOfIslands {
    // Function to count the number of islands in a given 2D grid map
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0; // Initialize the count of islands to 0
        int rows = grid.length; // Number of rows in the grid
        int cols = grid[0].length; // Number of columns in the grid

        // Iterate over each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell contains '1' (part of an island)
                if (grid[i][j] == '1') {
                    count++; // Increment the count of islands
                    // Use depth-first search (DFS) to mark all adjacent land as visited
                    dfs(grid, i, j);
                }
            }
        }
        return count; // Return the total number of islands
    }

    // Helper method to perform depth-first search for marking visited land
    private static void dfs(char[][] grid, int i, int j) {
        // If the current cell is out of grid boundaries or is water ('0'), return
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0'; // Mark the current cell as visited by setting it to '0'

        // Recursively call DFS for all four adjacent cells (down, up, right, left)
        dfs(grid, i + 1, j);  // down
        dfs(grid, i - 1, j);  // up
        dfs(grid, i, j + 1);  // right
        dfs(grid, i, j - 1);  // left
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid)); // Output: 3
    }
}

