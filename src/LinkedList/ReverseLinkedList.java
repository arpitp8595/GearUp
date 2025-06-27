package src.LinkedList;

import static src.LinkedList.MergeTwoSortedList.mergeSortedList;

public class ReverseLinkedList {
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

        System.out.println("Merged Lists: ");
        printList(mergeSortedList(head, head1));

        System.out.println("Print LL: ");
        printList(head);
        System.out.println("\n");
        System.out.println("Size of LinkedList: "+getSize(head));
        System.out.println("\n");
        System.out.println("Print Reversed LL: ");
        reverseLinkedList(head);
        System.out.println("\n");

    }

    public static void printList(ListNode head) {
           // A loop that runs till head is null
            while (head != null) {
                // Printing data of current node
                System.out.print(head.val + "-->");
                // Moving to the next node
                head = head.next;
            }
        System.out.println("null");
    }

    //O(N) O(1)
    public static void reverseLinkedList(ListNode head) {
        // Initialize three pointers: curr, prev and next
        ListNode curr = head, prev = null;
        // Traverse all the nodes of Linked List
        while (curr != null) {
            // Store curr.next
            ListNode temp = curr.next;
            // Reverse current node's next pointer
            curr.next = prev;
            // Move pointers one position ahead
            prev = curr;
            curr = temp;
        }
        printList(prev);
    }

    static int size = 0;
    public static int getSize(ListNode head) {
        if (head == null) {
            return size;
        }
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}