package src.TreeAndBinarySearchTree;

import static src.TreeAndBinarySearchTree.BoundaryOfBinaryTree.buildTree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        /*
             1
            / \
           2   3
          / \   \
         4   5   6
        */
        Integer[] nodes = {1, 2, 3, 4, 5, null, 6};
        TreeNode root = buildTree(nodes);
        System.out.println("Diameter of a tree: "+diameterOfBinaryTree(root)); //output: 3
    }
    private static int maxDiameter = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root); // This triggers DFS traversal
        return maxDiameter;
    }

    // Helper method to compute height of a tree
    private static int depth(TreeNode node) {
        if (node == null) return 0;

        // Recursively get height of left and right subtree
        int left = depth(node.left);
        int right = depth(node.right);

        // Update maxDiameter if the path through current node is longer
        maxDiameter = Math.max(maxDiameter, left + right);

        // Return height of current node
        return 1 + Math.max(left, right);
    }
}
