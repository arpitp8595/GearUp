package src.TreeAndBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static src.TreeAndBinarySearchTree.KthSmallestElementInBST.KthSmallestElementOfBST;

public class TreeWithIterativeApproach {

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
        //invertTree(root);
        System.out.println("\n");
        System.out.println("Kth Smallest element: " +KthSmallestElementOfBST(root, 3));
/*
                  4
                /   \
               2     7
              / \   / \
             1   3 6   9
*/
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
/*
                  1
                /   \
               2     2
              / \   / \
             3   4 4   3
*/
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(3);


        System.out.println("Original Tree: ");
        //printPreOrder(root);
        System.out.println("\n");
        System.out.println("Invert Tree: " );
        //invertTree1(root);
        System.out.println("\n");
        System.out.println("Kth smallest element: "+KthSmallestElementOfBST(root, 3));
        System.out.println("Are trees symmetric? : "+isSymmetric(root2));

        System.out.println("Depth of the tree: "+ maxDepth(root));
    }

    private static boolean isSymmetric(TreeNode root1) {

        if (root1 == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1.left);
        stack.push(root1.right);

        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();

            if (node1 == null && node2 == null) {
                continue;
            }
            if ((node1 == null) ||(node2 == null) || node1.val != node2.val) {
                return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void invertTree1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right!=null) {
                stack.push(node.right);
            }
            if (node.left!=null) {
                stack.push(node.left);
            }
        }
        printPreOrder(root);
    }

    //Preorder (Root → Left → Right) using Stack
    public void iterativePreOrder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " "); // process the node

            // Push right first, so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //Inorder (Left → Root → Right) using Stack
    public void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " "); // process the node
            curr = curr.right;
        }
    }

    //Postorder (Left → Right → Root) using Two Stacks
    public void iterativePostOrder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return depth;
    }
}
