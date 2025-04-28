package LinkedList;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("LinkedList before removing Nth node: ");
        printLinkedList(head);
        System.out.print("\n");
        System.out.print("LinkedList before removing Nth node: ");
        printLinkedList(removeNthFromEndElement(head, 3));
    }

    //O(N) O(1)
    private static ListNode removeNthFromEndElement(ListNode head, int n) {
        ListNode dummy = new ListNode(-1); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast ahead by n steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // Move both until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Remove the nth node from the end
        slow.next = slow.next.next;
        return dummy.next; // Return the modified list (skip dummy)
    }

    public static void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.println("LinkedList is empty.!");
        }
        while (head != null) {
            System.out.print(head.val+"-->");
            head = head.next;
        }
        System.out.print("null");
    }
}
