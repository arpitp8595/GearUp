package LinkedList;

import java.util.Objects;

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
        System.out.println("Intersected at :" + Objects.requireNonNull(resultNode).val);
    }

    //O(m + n) O(1)
    private static ListNode getIntersectionNodeInList(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        // Align the longer list
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Traverse both lists until intersection or end (null)
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            // If either list ends, no intersection
//            if (headA == null || headB == null) {
//                return null;
//            }
        }
        return headA; // Returns intersection node or null
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
