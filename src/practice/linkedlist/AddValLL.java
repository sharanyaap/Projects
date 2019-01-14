package practice.linkedlist;

/**
 * Created by sharanya.p on 8/12/2018.
 */
public class AddValLL {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public int addWithCarry(Node node) {
        if (node == null)
            return 1;
        int res = node.data + addWithCarry(node.next);
        node.data = res % 10;
        return res / 10;
    }

    public Node addOne(Node head) {
        int carry = addWithCarry(head);
        if (carry == 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        AddValLL addValLL = new AddValLL();
        addValLL.head = addValLL.new Node(9);
        addValLL.head.next = addValLL.new Node(9);
        addValLL.head.next.next = addValLL.new Node(9);
        addValLL.head.next.next.next = addValLL.new Node(9);

        Node node = addValLL.addOne(addValLL.head);

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

}
