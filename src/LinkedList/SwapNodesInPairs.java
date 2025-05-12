package LinkedList;

import static LinkedList.MergeTwoSortedList.printList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Original List: ");
        printList(head);
        System.out.println("Resulted Swapped List: ");
        printList(swapPairs(head));
    }

    //O(N) O(1)
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy; // Tracks the node before the current pair

        // Iterate through the list in pairs
        while (prev.next != null && prev.next.next != null) {
            // Identify the nodes to be swapped
            ListNode first = prev.next;
            ListNode second = first.next;

            // Perform the swapping
            first.next = second.next; // Connect the first node to the node after the second node
            second.next = first;      // Connect the second node to the first node
            prev.next = second;       // Connect the previous node to the second node

            // Move prev to the end of the swapped pair
            prev = first;
        }
        return dummy.next; // Return the new head after swaps
    }
}
