package src.LinkedList;

import static src.LinkedList.ReverseLinkedList.printList;

public class ReOrderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        System.out.println("Reordered List:");
        printList(reorderList(head));
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return null;

        // Step 1: Find the middle using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // break the list into two parts

        // Step 3: Merge the two halves alternately
        ListNode first = head;
        while (secondHalf != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = tmp1;

            first = tmp1;
            secondHalf = tmp2;
        }
        return head;
    }

    // Helper to reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
