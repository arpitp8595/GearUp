package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSTraversal {
    public static void bfs(GraphImplementation.Graph g, int source) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //Step 1
        queue.offer(source);
        visited.add(source);

        //Step 2
        while(!queue.isEmpty()) {
            int currentElement = queue.poll();
            System.out.println(currentElement);

            List<Integer> neighbouringNodes = g.getConnectedNodes(currentElement);
            for (Integer node: neighbouringNodes) {
                if (!visited.contains(node)) {
                    queue.add(node);
                    visited.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphImplementation.Graph graph = new GraphImplementation.Graph();
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

        System.out.println("Graph Structure: "+graph.adjList);

        bfs(graph, 1);

    }
}
