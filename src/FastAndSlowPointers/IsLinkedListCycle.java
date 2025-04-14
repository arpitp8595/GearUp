package FastAndSlowPointers;

public class IsLinkedListCycle {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Create a linked list using Node class
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        // Uncomment the line below to make the linked list cyclic
        //fourth.next = second;
        System.out.println("Is cyclic: "+isLinkedListCyclic(head));
    }

    private static boolean isLinkedListCyclic(Node head) {
        Node slow = head;
        Node fast = head;

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
