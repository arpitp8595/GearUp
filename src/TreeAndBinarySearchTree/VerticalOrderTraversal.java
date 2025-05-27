package src.TreeAndBinarySearchTree;

import java.util.*;

class Pair<T, I extends Number> {

    private TreeNode node;
    private Integer idx;

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public Pair(TreeNode node, Integer idx) {
        this.node = node;
        this.idx = idx;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}


//Prace More: https://leetcode.com/problem-list/binary-tree/

public class VerticalOrderTraversal {

    private static int index;

    public static void main(String[] args) {
        //int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] nodes = {3,9,20,-1,-1,15,7};
        TreeNode root = constructTree(nodes);

        System.out.println("Print Vertical Order: ");
        verticalOrder(root);
    }

    private static void verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getNode();
            int idx = pair.getIdx();

            if (!result.containsKey(idx)) {
                result.put(idx, new ArrayList<>());
            }
            result.get(idx).add(node.val);

            if(node.left != null) {
                queue.offer(new Pair<>(node.left, idx - 1));
            }

            if(node.right != null) {
                queue.offer(new Pair<>(node.right, idx + 1));
            }
        }
        for (List<Integer> list: result.values()) {
            System.out.print(list+" ");
        }
    }

    public static TreeNode constructTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        TreeNode newNode = new TreeNode(nodes[index]);
        newNode.left = constructTree(nodes);
        newNode.right = constructTree(nodes);

        return newNode;
    }
}
