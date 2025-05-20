package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] nums = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Total Number of Days: "+rottingOranges(nums));
    }

    static int N = 0;
    static int M = 0;

    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public static int rottingOranges(int[][] grid) {
        N = grid.length ; M = grid[0].length ;
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int freshOranges = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        int minutes = -1;
        if (freshOranges == 0) return 0;
        boolean[][] visited = new boolean[N][M];
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int k=0; k<size; k++) {
                Pair currentElement = queue.poll();
                for (int i=0; i<directions.length; i++) {
                    int newI = currentElement.x + directions[i][0];
                    int newJ = currentElement.y + directions[i][1];

                    if (isSafe(newI, newJ) && !visited[newI][newJ] && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2; //make current element rotten
                        freshOranges--;
                        visited[newI][newJ] = true;
                        queue.offer(new Pair(newI, newJ));
                    }
                }
            }

        }
        return freshOranges == 0 ? minutes : -1;
    }
    private static boolean isSafe(int newI, int newJ) {
        return (newI>=0 && newI<N && newJ>=0 && newJ<M);
    }
}
