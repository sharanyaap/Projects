package practice.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 1/15/2019.
 * https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
 */
public class DiagonalTraversal {

    Node node;

    public static void main(String[] args) {
        DiagonalTraversal diagonalTraversal = new DiagonalTraversal();
        diagonalTraversal.node = new Node(8);
        diagonalTraversal.node.left = new Node(3);
        diagonalTraversal.node.right = new Node(10);
        diagonalTraversal.node.left.left = new Node(1);
        diagonalTraversal.node.left.right = new Node(6);
        diagonalTraversal.node.right.right = new Node(14);
        diagonalTraversal.node.right.left = new Node(13);
        diagonalTraversal.node.left.right.left = new Node(4);
        diagonalTraversal.node.left.right.right = new Node(7);
        diagonalTraversal.diagonalTraversal(diagonalTraversal.node);
    }

    public void diagonalTraversal(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            while (node != null) {
                System.out.println(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node = node.right;
                } else {
                    node = null;
                }
            }
        }
    }

}
