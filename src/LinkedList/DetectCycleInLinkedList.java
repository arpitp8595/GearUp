package LinkedList;

public class DetectCycleInLinkedList {
    public static void main(String[] args) {
        //detect loop/cycle in LinkedList
        ListNode head = new ListNode(1);
        ListNode temp = new ListNode(2);
        head.next = temp;
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = temp;

        //non-cyclic linkedList
        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(10);

        System.out.println("Is cyclic: "+isCycle(head));

    }

    private static boolean isCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
