package src;

public class LinkedListRaw {

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static int size;

    public void addFisrt(int data) {
        size++;
        //step1 = create a new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        //step2 : newNode next = head
        newNode.next = head;

        //step3: head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        size++;
        //Step1: create a new node
        Node newNode = new Node(data);

        //Step2: tail.next = newNode
        tail.next = newNode;

        //Step3: tail = newNode
        tail = newNode;

    }

    public void add(int indx, int data) {
        size++;
        if (indx == 0) {
            addFisrt(data);
            return ;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i < indx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if (size == 0) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public void print(){
        if (head == null ){
            System.out.println("LL is empty.  ");
            return ;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        System.out.println("Key not found.!");
        return -1;
    }

    public int helper(Node head, int key) {
        if (null == head) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if (slow == fast) {
                return true; //cycle exist
            }
        }
        return false; // cycle doesn't exist
    }

    //Remove Cycle
    public static void removecycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        slow = head;
        Node prev = null; //last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -> last.next = null
        prev.next = null;
    }

    public Node mergeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left and right MS
        Node righHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righHead);

        //merge
        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2) {

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    public static void main(String[] args) {

        LinkedListRaw ll = new LinkedListRaw();

        ll.print();
        ll.addFisrt(1);
        //ll.print();
        ll.addFisrt(2);
        //ll.print();
        ll.addLast(5);
        //ll.print();
        ll.addFisrt(4);
        //ll.print();
        ll.add(2,7);
        System.out.println("Size: "+size);
        ll.head = ll.mergeSort(ll.head);
        ll.print();

        //ll.removeFirst();
        //ll.print();

        //ll.removeLast();
        //ll.print();
        System.out.println("Size: "+size);

        System.out.println(ll.itrSearch(4));
        System.out.println(ll.recSearch(50));

        ll.reverse();
        ll.print();

        ll.deleteNthFromEnd(3);
        ll.print();

        //detect loop/cycle in LinkedList
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = temp;
        System.out.println("Is cyclic: "+isCycle());

        //1->2->->3->4->2
        //Remove Cycle in LinkedList
        removecycle();
        ll.print();
        System.out.println("Is cyclic: "+isCycle());
    }
}
