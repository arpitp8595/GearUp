package Graph;

import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numOfIslands(grid)); // Output: 3
    }

    //https://youtu.be/dX6RZYxw41E?si=9TUMrWMPLUMAkGcY


    public static int numOfIslands(char[][] grid){
        N = grid.length;
        M = grid.length;
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
        for (int k=0; k<directions.length; k++) {
            int newI = i + directions[k][0];
            int newJ = j + directions[k][1];

            if (isSafe(newI, newJ) && grid[newI][newJ] == '1' && !visited[newI][newJ]){
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
