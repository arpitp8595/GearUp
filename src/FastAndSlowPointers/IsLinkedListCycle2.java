package src.FastAndSlowPointers;

public class IsLinkedListCycle2 {
    public static void main(String[] args) {
        // Create a linked list using Node class
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        // Uncomment the line below to make the linked list cyclic
        fourth.next = second;
        System.out.println("Cycle present at node value: "+isLinkedListCyclic2(head).val);
    }

    private static ListNode isLinkedListCyclic2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow.next == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
