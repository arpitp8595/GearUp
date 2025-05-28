package src.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IsGraphCyclic {
    public static void main(String[] args) {
        GraphImplementation.Graph graph = new GraphImplementation.Graph();
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);

        System.out.println("Is graph cyclic? : "+detectCycleUsingBFS(graph));
    }

    public static boolean detectCycleUsingBFS(GraphImplementation.Graph graph) {
        Set<Integer> visited = new HashSet<>();
        for (int node: graph.adjList.keySet()) {
            if (!visited.contains(node)) {
                if (isCycle(graph, node, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(GraphImplementation.Graph graph, int start, Set<Integer> visited) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // {cuurentNode, parentNode}
        visited.add(start);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbour: graph.getConnectedNodes(node)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(new int[]{neighbour, node});
                } else if (neighbour != parent) {
                    return true; //cycle detected
                }
            }
        }
        return false;
    }
}
