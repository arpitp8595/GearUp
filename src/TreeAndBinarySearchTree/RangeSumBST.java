package src.TreeAndBinarySearchTree;

import java.util.Stack;

import static src.TreeAndBinarySearchTree.VerticalOrderTraversal.constructTree;

public class RangeSumBST {

    public static void main(String[] args) {

/*
             10
            /  \
           5    15
          / \   / \
         3   7 13  18
        /   /
       1   6
*/

        int[] nodes = {10,5,15,3,7,13,18,1,-1,6};
        int low = 6; int high = 10;
        TreeNode root = constructTree(nodes);
        System.out.println("Total sum of the give range is: "+getRangeSum(root, low, high)); // O/P: 23


        // Example usage
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(18);

        int lowInt = 7;
        int highInt = 15;

        System.out.println("Total sum of the give range is:  "+getRangeWithIterativeApproach(treeNode, lowInt, highInt)); // Output: 45 (7 + 10 + 13 + 15)
    }

    private static int getRangeSum(TreeNode root, int low, int high) {
        int result = 0;

        if (root == null) {
            return result;
        }

        int currSum = (root.val >= low && root.val <= high) ? root.val : 0;

        int leftSum = getRangeSum(root.left, low, high);
        int rightSum = getRangeSum(root.right, low, high);

        return currSum + leftSum + rightSum;
    }

    private static int getRangeWithIterativeApproach(TreeNode root, int low, int high) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.val >= low && node.val <= high) {
                    result += node.val;
                }
                if (node.val > low) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }

}
