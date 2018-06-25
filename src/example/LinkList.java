package example;

/**
 * Created by sharanya.p on 10/16/2017.
 */
public class LinkList {
    public static void main(String arg[]){
        LinkList linkList = new LinkList();
        Node node = new Node();
        node.data = 1;
        node.next = null;

        linkList.Insert(node , 2);
        linkList.Insert(node , 3);

        node = linkList.InsertNth(node, 10, 3);
        while (node != null){
            System.out.println(node.data);
            node= node.next;
        }
    }

    public Node InsertNth(Node head, int data, int position) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(null == head && position == 0){
            head = new Node();
            head.data = data;
            head.next = null;
        } else if(0 == position && head != null){
            Node node = new Node();
            node.data = data;
            node.next = head;
            head = node;
        }
        else {
            Node node = new Node();
            node.data = data;
            int i = 1;
            Node prev = null;
            Node next = head;
            while(i <= position){
                prev = next;
                next = next.next;
                i++;
            }
            prev.next = node;
            node.next = next;
        }
        return head;
    }

    public Node Insert(Node head,int data) {
// This is a "method-only" submission.
// You only need to complete this method.
        if(null == head){
            head = new Node();
            head.data = data;
            head.next = null;
        }
        else if(head.next == null){
            Node last = new Node();
            last.data = data;
            last.next = null;
            head.next = last;
        }
        else {
            Insert(head.next, data);
        }
        return head;
    }
}
class Node{
    int data;
    Node next;
}
