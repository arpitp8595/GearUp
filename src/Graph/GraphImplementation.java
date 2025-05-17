package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImplementation {

    static class Graph {
        Map<Integer, List<Integer>> adjList;

        Graph() {
            adjList = new HashMap<>();
        }

        void addEdge(int u, int v) {

            //Undirected
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);

            //Directed
            //adjList.get(u).add(v);
        }
        List<Integer> getConnectedNodes(int u) {
            return adjList.getOrDefault(u, new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.addEdge(4,1);
        graph.addEdge(3,4);

        System.out.println("Graph Structure: "+graph.adjList);

    }
}
