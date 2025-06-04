package src.TreeAndBinarySearchTree;

//### Complexity Analysis
//
//**Time Complexity**:
//        - The in-order traversal visits each node exactly once.
//- In the worst case (unbalanced tree), the traversal takes **O(N)** time, where **N** is the number of nodes in the tree.
//        - In a balanced tree, the traversal takes **O(H + k)**, where **H** is the height of the tree and **k** is the position of the kth smallest element.
//
//        **Space Complexity**:
//        - The recursion stack requires space proportional to the height of the tree.
//        - In the worst case (unbalanced tree), the space complexity is **O(N)**.
//        - In a balanced tree, the space complexity is **O(H)**, where **H** is the height of the tree.


// Code Explanation
/*
This program finds the kth smallest element in a Binary Search Tree (BST) using an in-order traversal approach.
The in-order traversal processes nodes in ascending order for a BST. Here's the step-by-step explanation:

1. **TreeNode Class**:
   - Represents a node in the BST with `val`, `left`, and `right` attributes.

2. **KthSmallestInBST Class**:
   - Contains the logic to find the kth smallest element.
   - Uses a private counter (`count`) to track the number of nodes visited during traversal.
   - Uses a private variable (`result`) to store the kth smallest value once found.

3. **kthSmallest Method**:
   - Initiates the in-order traversal starting from the root node.
   - Returns the value of the kth smallest element.

4. **inOrderTraversal Method**:
   - Recursively traverses the left subtree, processes the current node, and then traverses the right subtree.
   - Increments the counter (`count`) for each visited node.
   - If `count == k`, the current node's value is stored in `result` and the traversal stops.

5. **Main Method**:
   - Demonstrates the functionality by creating a sample BST and finding the kth smallest element.
   - The sample BST is:
         3
        / \
       1   4
        \
         2
   - For `k = 2`, the output is `2` (the second-smallest element).
*/

import com.sun.source.tree.Tree;

import java.util.Stack;

// Code Implementation
public class KthSmallestElementInBST {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) return;

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Process the current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }

    //Find Kth element with iterative approach
    public static int KthSmallestElementOfBST(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k==0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElementInBST finder = new KthSmallestElementInBST();
        int k = 2;
        System.out.println("The " + k + "th smallest element is: " + finder.kthSmallest(root, k));
        System.out.println("The " + k + "th smallest element is: " + KthSmallestElementOfBST(root, k));

    }
}
