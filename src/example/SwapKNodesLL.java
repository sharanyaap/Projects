package example;

/**
 * Created by sharanya.p on 10/25/2017.
 */
public class SwapKNodesLL {

    public static void main(String[] args) {
        SwapKNodesLL swapKNodesLL = new SwapKNodesLL();
        Node head = null;
        LinkList linkList = new LinkList();
        head = linkList.Insert(head, 1);
        head = linkList.Insert(head, 2);
        head = linkList.Insert(head, 3);
        head = linkList.Insert(head, 4);
        head = linkList.Insert(head, 5);
        head = linkList.Insert(head, 6);
        head = linkList.Insert(head, 7);
        head = linkList.Insert(head, 8);
        head = swapKNodesLL.reverseKnodes(head, 4);
        Node tmp = head;
        while (tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }

    }

    int hasKnodes(Node head, int K) {
        int i = 0;
        for (i = 0; head != null && (i < K); i++, head = head.next) ;
        if (i == K)
            return 1;
        return 0;
    }

    private Node getKplusoneNode(int K, Node head){
        Node kthNode;
        int i = 0;
        if (head == null)
            return head;
        for (i = 0, kthNode = head; kthNode != null && (i<K);i++, kthNode = kthNode.next);
        if (i == K && kthNode != null){
            return kthNode;
        }
        return head.next;
    }

    private Node reverseKnodes(Node head, int K) {
        Node cur = head, temp, next, newHead;
        int i;
        if (K == 0 || K == 1)
            return head;
        if (hasKnodes(head, K-1) == 1)
            newHead = getKplusoneNode(K-1, cur);
        else
            newHead = head;
        while (cur!=null && hasKnodes(cur, K)== 1){
            temp = getKplusoneNode(K, cur);
            i =0;
            while (i<K){
                next = cur.next;
                cur.next = temp;
                temp = cur;
                cur = next;
                i++;
            }
        }
        return newHead;
    }

}
