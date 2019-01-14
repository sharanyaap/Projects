package practice.linkedlist;

import java.util.UUID;

/**
 * Created by sharanya.p on 7/12/2018.
 */
public class RandomNodeLL {

    static Node head;

    static class Node{
        int data;
        Node next;
        public Node(int d){
            this.data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

        RandomNodeLL list = new RandomNodeLL();
        list.head = new Node(5);
        list.head.next = new Node(20);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(30);

        list.printrandom(head);
    }

    static void printrandom(Node node){
        Node cur = node;
        int result = node.data;
        Math.abs(UUID.randomUUID().getMostSignificantBits());
        for (int n = 2; cur != null ; n++){
            if (Math.random() % n == 0){
                result = cur.data;
            }
            cur = cur.next;
        }
        System.out.println("Randomly selected key is " + result);
    }

}
