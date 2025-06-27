package src.TreeAndBinarySearchTree;

import java.util.Stack;
import static src.TreeAndBinarySearchTree.TreeWithIterativeApproach.printPreOrder;

public class InvertBinaryTree {

    public static void main(String[] args) {

/*
                 5
                / \
               3   6
              / \
             2   4
            /
           1
*/

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        System.out.println("Original Tree: ");
        printPreOrder(root);
        System.out.println("\n");
        System.out.println("Invert Tree: ");
        invertTree(root);
        printPreOrder(root);
    }

    public static void invertTree(TreeNode root) {
        // Step 1: Create a stack to simulate DFS traversal
        Stack<TreeNode> stack = new Stack<>();

        // Step 2: Base case – if root is null, return (nothing to invert)
        if (root != null) {
            stack.push(root); // Start DFS with the root node
        }

        // Step 3: Loop through all nodes in the stack
        while (!stack.isEmpty()) {
            // Pop the current node from the stack
            TreeNode current = stack.pop();

            // Optional: Debug print
            // System.out.println("Visiting node: " + current.val);

            // Step 4: Push left and right children onto the stack (if they exist)
            // Order matters: push left first, then right – because it's LIFO (stack)
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }

            // Step 5: Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
        }
    }
    
}
