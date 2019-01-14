package practice.linkedlist;

/**
 * Created by sharanya.p on 7/12/2018.
 */
public class CycleLL {

    static Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        CycleLL list = new CycleLL();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }

    void detectAndRemoveLoop(Node node) {
        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;
        Node slow, fast;
        slow = node.next;
        fast = node.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        }

    }

    void printList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

}
