package src.LinkedList;

import static src.LinkedList.MergeTwoSortedList.printList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 2;
        System.out.println("Resulted Swapped List: ");
        printList(reverseKGroup(head, n));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy; // Tracks the end of the previous reversed group
        ListNode curr = head;

        while (curr != null) {
            // Step 1: Check if there are at least k nodes remaining
            ListNode groupStart = curr;
            ListNode groupEnd = curr;
            int count = 1;
            while (groupEnd != null && count < k) {
                groupEnd = groupEnd.next;
                count++;
            }
            if (groupEnd == null) break; // Less than k nodes left

            // Step 2: Reverse the current k-group
            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null; // Temporarily break the list
            reverseList(groupStart); // Reverse the group
            // Reconnect: prevGroupEnd → new head (groupEnd), groupStart → nextGroupStart
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            // Step 3: Update pointers for the next iteration
            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper function to reverse a linked list
    private static void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
