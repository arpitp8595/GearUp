package src.Queue;

import src.TreeAndBinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static src.TreeAndBinarySearchTree.BoundaryOfBinaryTree.buildTree;

public class BSTLevelOrderTraversal {
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
        System.out.println("Level Order Traversal of Tree: "+levelOrderTraversal(root));
    }


    //O(N) O(N)
    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // Queue for holding nodes of each level
        Queue<TreeNode> q = new LinkedList<>();
        // Resultant list to hold lists of each level
        List<List<Integer>> res = new ArrayList<>();
        // If root is null, return empty result
        if (root == null) return res;

        // Initialize the queue with root node
        q.add(root);

        // While there are nodes to process in the queue
        while (!q.isEmpty()) {
            // Number of nodes at current level
            int size = q.size();
            // List to store node values at current level
            List<Integer> curList = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Remove the front node from the queue
                TreeNode rem = q.remove();

                // Add the left child to the queue if it exists
                if (rem.left != null) {
                    q.add(rem.left);
                }
                // Add the right child to the queue if it exists
                if (rem.right != null) {
                    q.add(rem.right);
                }
                // Add the value of the removed node to the current level list
                curList.add(rem.val);
            }
            // Add current level list to the result
            res.add(curList);
        }
        // Return the result containing all levels
        return res;
    }
}
