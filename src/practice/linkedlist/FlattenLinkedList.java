package practice.linkedlist;

/**
 * Created by sharanya.p on 8/12/2018.
 */
public class FlattenLinkedList {

    Node head;  // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    /* Utility function to insert a node at begining of the
       linked list */
    Node push(Node head_ref, int data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
        System.out.println();
    }


    Node flatten(Node root) {
        // Base Cases
        if (root == null || root.right == null)
            return root;

        Node node = root;
        Node up = root.right;

        while (node.down != null || node.right != null) {
            if (node.down != null) {
                if (up != null && node.down.data < up.data) {
                    node.right = node.down;
                    node.down = null;
                    node.right.right = up;
                } else {
                    while (up != null && node != null && node.down != null && up.right != null && node.down.data > up.data && up.right.data < node.down.data) {
                        up = up.right;
                    }
                    node.down.right = up.right;
                    up.right = node.down;
                    node.down = null;
                }
            }
            node = node.right;
            up = node.right;
            printList();
        }

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        FlattenLinkedList L = new FlattenLinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 28);

        L.printList();

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }

}
