package src.ArraysAndStrings.MatrixArray;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        // Example usage
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid1)); // Output: 4

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(grid2)); // Output: -1

        int[][] grid3 = {
                {0, 2}
        };
        System.out.println(orangesRotting(grid3)); // Output: 0
    }

    //O(m \times n)
    //O(m \times n)
    public static int orangesRotting(int[][] grid) {
        // Edge case: If the grid is empty, return -1
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize by finding all rotten oranges and counting fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) return 0;

        int minutesElapsed = -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up

        // Perform BFS to rot adjacent fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutesElapsed++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutesElapsed : -1;
    }

    public int orangesRotting2(int[][] grid) {
        // Edge case: If the grid is empty, return -1
        if(grid == null || grid.length == 0) return -1;

        // Step 1: Traverse the grid and start spreading rot from all rotten oranges
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                // If we find a rotten orange, spread the rot to adjacent cells
                if(grid[i][j] == 2)
                    rotAdjacent(grid, i, j, 2);
            }
        }

        // Step 2: Find the maximum time taken and check if there are any fresh oranges left
        int minutes = 2;  // Start from 2 since rotten oranges start at 2
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1; // If any fresh orange remains, return -1
                minutes = Math.max(minutes, cell); // Keep track of max time taken
            }
        }

        return minutes - 2; // Subtract 2 to adjust the initial time count
    }

    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        // Base Case: Check if we are out of bounds or in an invalid cell
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0  // Empty cell, stop recursion
                || (1 < grid[i][j] && grid[i][j] < minutes) // Already rotten in fewer minutes
        ) return;

        // Spread the rot
        grid[i][j] = minutes;

        // Recursively rot adjacent oranges
        rotAdjacent(grid, i - 1, j, minutes + 1); // Up
        rotAdjacent(grid, i + 1, j, minutes + 1); // Down
        rotAdjacent(grid, i, j - 1, minutes + 1); // Left
        rotAdjacent(grid, i, j + 1, minutes + 1); // Right
    }
}