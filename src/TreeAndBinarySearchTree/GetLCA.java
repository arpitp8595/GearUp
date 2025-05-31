package src.TreeAndBinarySearchTree;

import java.util.*;

public class GetLCA {
    public static void main(String[] args) {
        // Construct the binary tree from the problem statement example
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        // Set parent references
        root.left.parent = root;
        root.right.parent = root;
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        // Find the LCA of nodes 5 and 1
        Node p = root.left;   // Node 5
        Node q = root.right;  // Node 1
        GetLCA getLCA = new GetLCA();
        Node lca = getLCA.lowestCommonAncestor(p, q);

        // Print the LCA
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));

        // Print the tree
        System.out.println("Tree:");
        printTree(root);
    }

    // Function to print the tree in level order
    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                Node node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelSize--;
            }
            System.out.println(); // New line for each level
        }
    }

    // Function to find the Lowest Common Ancestor
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p; // Initialize pointer p1 to start at node p
        Node p2 = q; // Initialize pointer p2 to start at node q

        // Traverse upwards until p1 and p2 meet
        while (p1 != p2) {
            // If p1 has reached the root (null), switch to start at q; otherwise move upwards
            p1 = (p1 == null) ? q : p1.parent;

            // If p2 has reached the root (null), switch to start at p; otherwise move upwards
            p2 = (p2 == null) ? p : p2.parent;
        }

        // When p1 and p2 meet, return the LCA node
        return p1;
    }
}

// Definition for a Node with a parent reference
class Node {
    int val;
    Node left;
    Node right;
    Node parent;

    Node(int x) {
        val = x;
    }
}


