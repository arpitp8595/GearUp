package src.Graph;

import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numOfIslands(grid)); // Output: 4
    }

    public static int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] directions1 = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // Base case: out of bounds or water
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') return;

        // Mark as visited
        grid[i][j] = '0';

        for (int[] dir : directions1) {
            dfs(grid, i + dir[0], j + dir[1], rows, cols);
        }
    }

    //https://youtu.be/dX6RZYxw41E?si=9TUMrWMPLUMAkGcY
    public static int numOfIslands1(char[][] grid){
        N = grid.length;
        M = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[N][M];
        for (boolean[] v: visited) {
            Arrays.fill(v, false);
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfsTraversal(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static void dfsTraversal(char[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (isSafe(newI, newJ) && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                dfsTraversal(grid, newI, newJ, visited);
            }
        }
    }

    static int N;
    static int M;
    private static boolean isSafe(int newI, int newJ) {
        return (newI>=0 && newI<N && newJ>=0 && newJ<M);
    }
}
