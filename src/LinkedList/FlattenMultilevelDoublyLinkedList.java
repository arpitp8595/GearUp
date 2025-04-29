package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenMultilevelDoublyLinkedList {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }

    public static void main(String[] args) {
        // Level 1: 1 ↔ 2 ↔ 3 ↔ 4 ↔ 5 ↔ 6
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;

        // Level 2: 7 ↔ 8 ↔ 9 ↔ 10 (child of node2)
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node2.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;

        // Level 3: 11 ↔ 12 (child of node8)
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;
/*
        1 ↔ 2 ↔ 3 ↔ 4 ↔ 5 ↔ 6
              ↘
                 7 ↔ 8 ↔ 9 ↔ 10
                       ↘
                         11 ↔ 12
*/
        // Flatten the list
        Node flattenedHead = flatten(head);

        // Print the flattened list
        printList(flattenedHead);
    }

    // Flattening method (from LeetCode solution)
    public static Node flatten(Node head) {
        if (head == null) return null;
        Node current = head;
        Deque<Node> stack = new ArrayDeque<>();

        while (current != null) {
            if (current.child != null) {
                if (current.next != null) {
                    stack.push(current.next);
                }
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
            if (current.next == null && !stack.isEmpty()) {
                current.next = stack.pop();
                current.next.prev = current;
            }
            current = current.next;
        }
        return head;
    }

    // Helper method to print the list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" ↔ ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
