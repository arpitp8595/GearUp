package LinkedList;

import static LinkedList.MergeTwoSortedList.printList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Resulted Swapped List: ");
        printList(swapPairs(head));
    }

    //O(N) O(1)
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy; // Tracks the node before the current pair

        while (prev.next != null && prev.next.next != null) {
            // Nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap nodes
            prev.next = second;         // Step 1: Link prev to second
            first.next = second.next;   // Step 2: Link first to next pair
            second.next = first;        // Step 3: Link second to first

            // Move prev to the end of the current pair
            prev = first;
        }

        return dummy.next; // New head after swaps
    }
}
