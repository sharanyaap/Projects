package practice.linkedlist;

/**
 * Created by sharanya.p on 7/11/2018.
 */
public class Merge2LL {

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
        Merge2LL llist1 = new Merge2LL();
        Merge2LL llist2 = new Merge2LL();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);

        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);

        System.out.println("Second Linked List:");

        llist1.merge(llist2);

        System.out.println("Modified first linked list:");
        llist1.printList();

        System.out.println("Modified second linked list:");
        llist2.printList();
    }

    void merge(Merge2LL list2){
        Node cur = this.head;
        Node prev = null;
        Node cur2 = list2.head;
        while (cur != null){
            prev = cur2.next;
            cur2.next = cur.next;
            cur.next =cur2;
            cur = cur.next.next;
            cur2 = prev;
        }
        list2.head = cur2;
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

}
