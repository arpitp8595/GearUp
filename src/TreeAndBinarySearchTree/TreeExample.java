package TreeAndBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeExample {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(){}
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }

    private static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root); q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+ " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int diameter = 0;

    private static int diameterOfBinaryTree(Node root) {
        helper(root);
        return diameter;
    }

    private static int helper(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        int currentDepth = leftDepth + rightDepth;
        diameter = Math.max(diameter, currentDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int getLCA(Node root, Node p, Node q) {
        if (root.data > p.data && root.data > q.data) {
            return getLCA(root.left, p, q);
        } if (root.data < p.data && root.data < q.data) {
            return getLCA(root.right, p , q);
        }
        return root.data;
    }


    public static void main(String[] args) {
/*
                 1
                / \
               2   3
              / \
             4   5
                /
               6
*/
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        System.out.println("preOrder");
        preOrder(root);
        System.out.println();
        System.out.println("inOrder");
        inOrder(root);
        System.out.println();
        System.out.println("postOrder");
        postOrder(root);
        System.out.println();
        System.out.println("levelOrder");
        levelOrder(root);
        System.out.println("Diameter of Tree: "+diameterOfBinaryTree(root));

        //6,2,8,0,4,7,9,null,null,3,5
        int[] BSTNodes = {6,2,8,0,4,7,9,-1,-1,3,5};
        Node bstRoot = BinaryTree.buildTree(BSTNodes);
        //System.out.println("LCA of Binary Search Tree: "+getLCA(bstRoot, new Node(4),new Node(6)));

    }
}
