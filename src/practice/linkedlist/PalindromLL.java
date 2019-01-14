package practice.linkedlist;

/**
 * Created by sharanya.p on 8/12/2018.
 */
public class PalindromLL {

    Node head;  // head of list
    Node left;

    /* Linked list Node*/
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    boolean checkPal(Node right) {
        if (right == null)
            return true;
        boolean isp = checkPal(right.next);
        if (!isp)
            return false;
        /* Check values at current left and right */
        boolean isp1 = (right.data == (left).data);

        /* Move left to next node */
        left = left.next;

        return isp1;
    }

    public static void main(String[] args) {
        PalindromLL palindromLL = new PalindromLL();
        palindromLL.head = palindromLL.new Node(8);
        palindromLL.head.next = palindromLL.new Node(9);
        palindromLL.head.next.next = palindromLL.new Node(9);
        palindromLL.head.next.next.next = palindromLL.new Node(8);

        palindromLL.left = palindromLL.head;
        System.out.println(palindromLL.checkPal(palindromLL.head));
    }

}
