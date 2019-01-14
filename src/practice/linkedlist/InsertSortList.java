package practice.linkedlist;

/**
 * Created by sharanya.p on 7/10/2018.
 */
public class InsertSortList {

    private Node head;

    public static void main(String[] args) {
        InsertSortList llist = new InsertSortList();
        Node new_node;
        new_node = llist.newNode(5);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(10);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(7);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(3);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(1);
        llist.sortedInsert(new_node);
        new_node = llist.newNode(9);
        llist.sortedInsert(new_node);
        System.out.println("Created Linked List");
        llist.printList();

    }

    public void deleteNode(Node head, Node delNode){

    }


    public void sortedInsert(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node prev = head;
            if (node.value < prev.value){
                node.next = head;
                head = node;
            }
            boolean insert = false;
            while (prev.next != null) {
                if (prev.value < node.value && prev.next.value > node.value) {
                    node.next = prev.next;
                    prev.next = node;
                    insert = true;
                    break;
                }
                prev = prev.next;
            }
            if (!insert && prev.value < node.value) {
                prev.next = node;
            }
        }
    }

    public Node newNode(int v) {
        Node n = new Node(v);
        return n;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }

}

class Node {
    int value;
    Node next;

    public Node(int v) {
        this.value = v;
        next = null;
    }
}
