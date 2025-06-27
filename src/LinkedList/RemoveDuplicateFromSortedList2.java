package src.LinkedList;

import static src.LinkedList.MergeTwoSortedList.printList;

public class RemoveDuplicateFromSortedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Delete Duplicates: ");
        printList(deleteDupliates(head));

    }

    // Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
    // leaving only distinct numbers from the original list. Return the linked list sorted as well.
    private static ListNode deleteDupliates(ListNode head) {
        // Dummy node before the head to simplify deletion logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // Prev always points to the last node before the sequence of duplicates
        ListNode prev = dummy;
        while (head != null) {
            // Detect duplicates: current node has same value as next
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Bypass all duplicates
                prev.next = head.next;
            } else {
                // No duplicate detected: move prev to current
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }
        return dummy.next;
    }
}
