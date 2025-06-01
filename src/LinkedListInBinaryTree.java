package src;

import src.LinkedList.ListNode;
import src.TreeAndBinarySearchTree.TreeNode;

public class LinkedListInBinaryTree {
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

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        System.out.println("Does Tree contain linked list (is subPath) ? "+isSubPath(head, root));
    }

    private static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfsTraverse(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean dfsTraverse(ListNode head, TreeNode root) {
        if (head.next == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return head.val == root.val && (dfsTraverse(head.next, root.left) || dfsTraverse(head.next, root.right));
    }
}
