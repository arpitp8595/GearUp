package src.FastAndSlowPointers;

class LLNode {
    int val;
    LLNode llnext;
    LLNode(int x) {
        val = x;
        llnext = null;
    }
    LLNode(){}
}

public class FindMiddleOfLinkedList {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        LLNode second = new LLNode(2);
        LLNode third = new LLNode(3);
        LLNode fourth = new LLNode(4);
        LLNode fifth = new LLNode(5);

        head.llnext = second;
        second.llnext = third;
        third.llnext = fourth;
        fourth.llnext = fifth;

        System.out.println("Middle of LinkedList: " +getMiddle(head));
        System.out.println("Remove middle node of LinkedList: ");
        deleteMiddleNode(head);//printing the entire linkedList as well
    }

    private static void deleteMiddleNode(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;
        LLNode temp = null;
        while (fast != null && fast.llnext != null) {
            fast = fast.llnext.llnext;
            temp = slow;
            slow = slow.llnext;
        }
        temp.llnext = slow.llnext;
        printLinkedList(head);
        //return head;
    }

    private static void printLinkedList(LLNode head) {
        if (head == null ){
            System.out.println("LL is empty.  ");
            return ;
        }
        System.out.print("LinkedList: ");
        LLNode current = head;
        while (current != null) {
            System.out.print(" "+current.val);
            current = current.llnext;
        }
    }



    private static int getMiddle(LLNode head) {
        LLNode slow = head;
        LLNode fast = head;
        while (fast != null && fast.llnext != null) {
            slow = slow.llnext;
            fast = fast.llnext.llnext;
        }
        return slow.val;
    }
}
