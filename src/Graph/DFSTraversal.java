package src.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFSTraversal {

    static void dfsTraversal(GraphImplementation.Graph g, int source, Set<Integer> visited) {
        System.out.println(source);
        visited.add(source);
        List<Integer> neighbouringNodes = g.getConnectedNodes(source);
        for (int node: neighbouringNodes) {
            if (!visited.contains(node)) {
                dfsTraversal(g, node, visited);
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
        dfsTraversal(graph, 1, new HashSet<>());

        System.out.println("Disconnected Graph: ");
        GraphImplementation.Graph disconnectedGraph = new GraphImplementation.Graph();
        disconnectedGraph.addEdge(1,2);
        disconnectedGraph.addEdge(2,3);
        disconnectedGraph.addEdge(1,3);
        disconnectedGraph.addEdge(2,4);
        disconnectedGraph.addEdge(3,4);
        disconnectedGraph.addEdge(3,5);
        disconnectedGraph.addEdge(4,5);

        disconnectedGraph.addEdge(6,7); disconnectedGraph.addEdge(6,8);

        disconnectedGraph.addEdge(9,10);

        Set<Integer> disSet = new HashSet<>();
        for(int i=1; i<=10; i++) {
            if (!disSet.contains(i)) {
                dfsTraversal(disconnectedGraph, i, disSet);
            }
        }

    }
}
