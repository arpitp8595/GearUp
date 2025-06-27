package src.Graph;


import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
public class CloneGraph {
    public static void main(String[] args) {
        // Create a closed graph with 4 nodes forming a square
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect nodes to form a closed loop (square)
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraph = cloneGraph.cloneGraph(node1);

        if (isCyclic(node1)) {
            // Print original and cloned graph (simplified verification)
            System.out.println("Original graph first node: ");
            printGraph(node1);
            System.out.println("Cloned graph first node: ");
            printGraph(clonedGraph);
        } else {
            System.out.println("Please provide a cyclic graph.");
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        cloneUtil(node, map);
        return map.get(node);
    }

    private void cloneUtil(Node node, HashMap<Node, Node> visited) {
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        for (Node neighbour: node.neighbors) {
            if (!visited.containsKey(neighbour)) {
                cloneUtil(neighbour, visited);
            } else {
                newNode.neighbors.add(visited.get(neighbour));
            }
        }
    }

    //printGraph(Node node)
    //Uses BFS (Breadth-First Search) to traverse the graph.
    //Prints each node along with its neighbors.
    //Ensures no duplicates by tracking visited nodes.
    public static void printGraph(Node node) {
        if (node == null) {
            System.out.println("Graph is empty!");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Node " + current.val + " -> Neighbors: [");

            for (Node neighbor : current.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            System.out.println("]");
        }
    }

    //isCyclic(Node node)
    //Uses DFS (Depth-First Search) to detect cycles.
    //If a visited neighbor is found that is not the parent node, a cycle exists.
    //Returns true if cyclic, false otherwise.
    public static boolean isCyclic(Node node) {
        if (node == null) {
            return false;
        }

        Set<Node> visited = new HashSet<>();
        return hasCycle(node, visited, null);
    }

    private static boolean hasCycle(Node node, Set<Node> visited, Node parent) {
        visited.add(node);

        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and not the parent, it's a cycle
                return true;
            }
        }
        return false;
    }
}
