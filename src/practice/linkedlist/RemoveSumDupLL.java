package practice.linkedlist;

/**
 * Created by sharanya.p on 8/12/2018.
 */
public class RemoveSumDupLL {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node removeDups() {
        Node node = head;

        while (node != null) {
            int sum = 0;
            boolean found = false;
            Node next = node.next;
            while (next != null) {
                sum += next.data;
                if ((sum * -1) == node.data) {
                    found = true;
                    break;
                }
                next = next.next;
            }
            if (found) {
                if (head == node) {
                    head = next.next;
                    node = head;
                }else{
                    Node temp = head.next;
                    Node prev = head;
                    while (temp != node){
                        prev = temp;
                        temp=temp.next;
                    }
                    prev.next = next.next;
                    node = next.next;
                }
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveSumDupLL removeDupLL = new RemoveSumDupLL();
        removeDupLL.head = removeDupLL.new Node(6);
        removeDupLL.head.next = removeDupLL.new Node(-6);
        removeDupLL.head.next.next = removeDupLL.new Node(8);
        removeDupLL.head.next.next.next = removeDupLL.new Node(4);
        removeDupLL.head.next.next.next.next = removeDupLL.new Node(-12);
        removeDupLL.head.next.next.next.next.next = removeDupLL.new Node(9);
        removeDupLL.head.next.next.next.next.next.next = removeDupLL.new Node(8);
        removeDupLL.head.next.next.next.next.next.next.next = removeDupLL.new Node(-8);

        Node node = removeDupLL.removeDups();

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }

    }

}
