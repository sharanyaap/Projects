package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sharanya.p on 2/4/2018.
 */
public class HeapsAndMaps {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(10);
        a.next.next = new ListNode(20);

        ListNode b = new ListNode(4);
        b.next = new ListNode(11);
        b.next.next = new ListNode(13);

        ListNode c = new ListNode(3);
        c.next = new ListNode(8);
        c.next.next = new ListNode(9);

        ArrayList<ListNode> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(c);

        HeapsAndMaps maps = new HeapsAndMaps();
        ListNode res = maps.mergeKLists(arr);
        while (res != null){
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a.size() == 0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val)
                    return 1;
                else if (a.val < b.val)
                    return -1;
                else
                    return 0;
            }
        });

        //Add first node of each list to the queue
        for (ListNode node : a) {
            if (node != null)
                q.add(node);
        }

        ListNode head = new ListNode(0);
        ListNode p = head;
        while (q.size() > 0) {
            ListNode temp = q.poll(); // removes the first / head from queue
            p.next = temp;
            if (temp.next != null)
                q.add(temp.next);
            p = p.next;
        }
        return head.next;
    }
}
