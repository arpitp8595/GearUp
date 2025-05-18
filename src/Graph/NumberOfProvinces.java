package Graph;

import java.util.HashSet;
import java.util.Set;

import static Graph.DFSTraversal.dfsTraversal;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Total Number of Provinces: "+findCircleNum(nums));
    }

    //LC 547 Number of Provinces
    public static int findCircleNum(int[][] isConnected) {

        GraphImplementation.Graph graph = new GraphImplementation.Graph();
        int n = isConnected.length;
        int count = 0;
        for (int i=0; i<isConnected.length; i++) {
            for (int j=0; j<isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.addEdge(i+1, j+1);
                }

            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)){
                dfsTraversal(graph, i, visited);
                count++;
            }
        }
        return count;
    }
}
