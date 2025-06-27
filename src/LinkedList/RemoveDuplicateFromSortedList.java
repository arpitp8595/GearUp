package src.LinkedList;

import java.util.LinkedList;

import static src.LinkedList.MergeTwoSortedList.printList;

public class RemoveDuplicateFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        System.out.println("Original List: "); printList(head);

        System.out.println("Linked list after removing duplicate: ");
        printList(removeDuplicates(head));
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, return the head as is.
        }
        ListNode current = head; // Initialize the current pointer to start at the head of the list.
        while (current.next != null) { // Traverse the list until the end.
            if (current.val == current.next.val) {
                // If the current value is the same as the next value, bypass the next node.
                current.next = current.next.next;
            } else {
                // If the current value is different from the next value, move to the next node.
                current = current.next;
            }
        }
        return head; // Return the original head of the list.
    }
}
