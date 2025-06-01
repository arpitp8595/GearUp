package src.TreeAndBinarySearchTree;

import java.util.*;

public class BoundaryOfBinaryTree {
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
        assert root != null;
        System.out.println("Boundary Elements of Tree: "+boundaryOfBinaryTree(root));
    }

    //https://www.youtube.com/watch?v=0ca1nvR0be4&t=420s
    //O(N) O(N)
    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        Stack<Integer> rights = new Stack<>();
        boundary.add(root.val); // Add root first

        if (root.left == null && root.right == null) {
            return boundary; // If only root exists, return it
        }

        getLeft(root.left, boundary);     // Get left boundary
        getLeaves(root, boundary);        // Get all leaves
        getRights(root.right, rights);    // Get right boundary (stored in reverse)

        // Pop from stack to reverse the right boundary
        while (!rights.empty()) {
            boundary.add(rights.pop());
        }

        return boundary;
    }

    private static void getLeft(TreeNode node, List<Integer> lefts) {
        while (node != null && (node.left != null || node.right != null)) {
            lefts.add(node.val); // Add non-leaf nodes
            if (node.left == null) {
                node = node.right; // If no left child, go right
            } else {
                node = node.left;  // Prefer leftmost path
            }
        }
    }

    private static void getRights(TreeNode node, Stack<Integer> rights) {
        while (node != null && (node.left != null || node.right != null)) {
            rights.push(node.val); // Push to stack (for later reversal)
            if (node.right == null) {
                node = node.left;  // If no right child, go left
            } else {
                node = node.right; // Prefer rightmost path
            }
        }
    }

    private static void getLeaves(TreeNode root, List<Integer> boundary) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            boundary.add(root.val); // Add leaf nodes
            return;
        }
        getLeaves(root.left, boundary);  // DFS left subtree
        getLeaves(root.right, boundary); // DFS right subtree
    }
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Assign left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Assign right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
