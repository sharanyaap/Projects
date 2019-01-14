package practice.linkedlist;

/**
 * Created by sharanya.p on 7/11/2018.
 */
public class ReverseLL {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        ReverseLL llist = new ReverseLL();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List");
        llist.printList();

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }

    void push(int n) {
        Node node = new Node(n);
        /* 3. Make next of new Node as head */
        node.next = head;

        /* 4. Move the head to point to new Node */
        head = node;
    }

    void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    Node reverse(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curr, Node prev) {

        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return head;
        }

        Node next1 = curr.next;
        curr.next = prev;
        reverseUtil(next1, curr);
        return head;

    }

}
