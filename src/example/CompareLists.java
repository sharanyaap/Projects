package example;

/**
 * Created by sharanya.p on 10/16/2017.
 */
public class CompareLists {

    public static void main(String args[]){
        CompareLists lists = new CompareLists();
        Node headA = new Node();
        headA.data = 1;
        headA.next = null;
        lists.Insert(headA, 2);
        lists.Insert(headA, 3);
        lists.Insert(headA, 4);


        Node headB = new Node();
        headB.data = 1;
        headB.next = null;
        lists.Insert(headB, 2);
        lists.Insert(headB, 3);
        lists.Insert(headB, 4);


        System.out.println(lists.CompareLists(headA, headB));
    }

    int CompareLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if(headA == headB || (headA == null && headB == null)){
            return 1;
        }else if(headA.data == headB.data && headA.next == null && headB.next == null){
            return 1;
        }
        else if(headA.data == headB.data && headA.next != null && headB.next != null){
            return CompareLists(headA.next, headB.next);
        }
        return 0;
    }


    Node Insert(Node head,int data) {
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
