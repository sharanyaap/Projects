package practice.bst;

import java.util.*;

/**
 * Created by sharanya.p on 9/14/2018.
 */
public class BottomView {

    Node root;

    public static void main(String[] args) {
        BottomView tree = new BottomView();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.bottomView();
    }

    public void bottomView() {
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        int hd = 0;
        root.hd = hd;
        q.add(root);
        while (!q.isEmpty()) {
            Node tmp = q.remove();
            hd = tmp.hd;
            map.put(hd, tmp.data);
            if (tmp.left != null) {
                tmp.left.hd = hd - 1;
                q.add(tmp.left);
            }
            if (tmp.right != null) {
                tmp.right.hd = hd + 1;
                q.add(tmp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getValue());
        }
    }

}
