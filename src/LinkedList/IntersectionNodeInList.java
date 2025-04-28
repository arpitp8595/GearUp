package LinkedList;

import static LinkedList.MergeTwoSortedList.printList;

public class IntersectionNodeInList {
    public static void main(String[] args) {
        // Create shared nodes (intersection point)
        ListNode sharedNode = new ListNode(8);
        sharedNode.next = new ListNode(4);
        sharedNode.next.next = new ListNode(5);

        // ListA: 4 → 1 → sharedNode (8 → 4 → 5)
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = sharedNode; // Intersection!

        // ListB: 5 → 6 → 1 → sharedNode (8 → 4 → 5)
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(1);
        head1.next.next.next = sharedNode; // Same intersection!

        System.out.print("Print List A: ");
        printList(head);
        System.out.print("Print List B: ");
        printList(head1);
        ListNode resultNode = getIntersectionNodeInList(head, head1);
        System.out.println("Intersected at :" +resultNode.val);
    }

    //O(m + n) O(1)
    private static ListNode getIntersectionNodeInList(ListNode head, ListNode head1) {
        int lenA = getLen(head);
        int lenB = getLen(head1);

        // Align the longer list
        while (lenA > lenB) {
            head = head.next;
            lenA--;
        }
        while (lenB > lenA) {
            head1 = head1.next;
            lenB--;
        }

        // Traverse both lists until intersection or end (null)
        while (head != head1) {
            head = head.next;
            head1 = head1.next;
            // If either list ends, no intersection
            if (head == null || head1 == null) {
                return null;
            }
        }
        return head; // Returns intersection node or null
    }

    private static int getLen(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
