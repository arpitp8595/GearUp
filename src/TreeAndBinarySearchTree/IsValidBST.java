package src.TreeAndBinarySearchTree;

import static src.TreeAndBinarySearchTree.VerticalOrderTraversal.constructTree;

public class IsValidBST {
    public static void main(String[] args) {

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //int[] nodes = {3,9,20,-1,-1,15,7};
        TreeNode root = constructTree(nodes);
        System.out.println("Is Tree Valid BST: "+isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        return isValid(root.left, minValue, root.val) || isValid(root.right, maxValue, root.val);
    }
}
