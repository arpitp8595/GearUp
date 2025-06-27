package src.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[] {
                createList(new int[]{1, 4, 5}),
                createList(new int[]{1, 3, 4}),
                createList(new int[]{2, 6})
        };

        // Call mergeKLists
        ListNode result = mergeKLists(lists);

        // Print result
        System.out.print("Merged List: ");
        printList(result);

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Use a min-heap to always extract the smallest current node
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Step 1: Add the head of each non-null list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy head to simplify result list building
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Step 2: Build the result list by always picking the smallest node
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If there are more nodes in the list, add next to heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
    // ✅ Utility method to create a list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // ✅ Utility method to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

}
