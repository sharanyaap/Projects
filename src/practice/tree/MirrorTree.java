package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 9/14/2018.
 */
public class MirrorTree {

    Node tree;

    public static void main(String[] args) {
        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.tree = new Node(1);
        mirrorTree.tree.left = new Node(2);
        mirrorTree.tree.right = new Node(2);
        mirrorTree.tree.left.left = new Node(3);
        mirrorTree.tree.left.right = new Node(4);
        mirrorTree.tree.right.left = new Node(3);
        mirrorTree.tree.right.right = new Node(3);
        System.out.println(mirrorTree.isMirror(mirrorTree.tree, mirrorTree.tree));
    }

    public boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null && node1.data == node2.data)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));
        return false;
    }

}