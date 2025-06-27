package src.LinkedList;

import static src.LinkedList.MergeTwoSortedList.printList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(10);

        System.out.println("List One: ");
        printList(head);
        System.out.println("List Two: ");
        printList(head1);
        System.out.println("Result Node after sum: ");
        printList(addTwoNumbers(head, head1));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify edge cases
        ListNode current = dummyHead; // Pointer to build the result list
        int carry = 0; // Stores the carry-over during addition

        // Traverse both lists until all digits are processed
        while (l1 != null || l2 != null || carry != 0) {
            // Extract values from the current nodes (or 0 if null)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Compute sum and carry
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10); // Add digit to result
            current = current.next;

            // Move to next nodes (if available)
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Skip dummy node
    }
}
