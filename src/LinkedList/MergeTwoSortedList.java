package src.LinkedList;

public class MergeTwoSortedList {
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

        System.out.println("First List: "); printList(head);

        System.out.println("Second List: "); printList(head1);

        System.out.println("Merged Lists: ");
        printList(mergeSortedList(head, head1));
    }

    //O(n + m) O(1)
    static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode mergedLL = new ListNode(-1);  // dummy node
        ListNode temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        // Attach the remaining elements of head1 or head2
        //temp.next = (head1 != null) ? head1 : head2;
        if(head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return mergedLL.next;
    }

    public static void printList(ListNode head) {
        // A loop that runs till head is null
        while (head != null) {
            // Printing data of current node
            System.out.print(head.val + " -> ");
            // Moving to the next node
            head = head.next;
        }
        System.out.println("null");
    }
}
