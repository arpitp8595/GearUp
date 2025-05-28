package src.FastAndSlowPointers;


  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
     ListNode(){}
 }

public class LinkedlistCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = second;

        System.out.println("Is Cyclic: "+isCycle(head));

        System.out.println("Detect Cycle2: "+detectCycle2(head).val);
    }

    private static boolean isCycle(ListNode head) {
        ListNode slow = head;
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

    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
    //while loop is not used here because initially slow and
    //fast pointer will be equal only, so the loop won't run.
        do {
    //slow moving one step ahead and fast moving two steps ahead
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

    //if a cycle exists, then the number is not a happy number
    //and slow will have a value other than 1
        return slow == 1;
    }

    //Finding the square of the digits of a number
    public int square(int num) {

        int ans = 0;

        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }
}
