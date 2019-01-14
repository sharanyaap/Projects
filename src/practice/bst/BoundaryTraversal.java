package practice.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 9/14/2018.
 */
public class BoundaryTraversal {

    Node root;

    // Driver program to test above functions
    public static void main(String args[]) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);

    }

    void printBoundary(Node node) {
        if (node != null) {
            System.out.println(node.data);
            printLeftBoundary(node.left);
            printLeaves(node.left);
            printLeaves(node.right);
            printRightBoundary(node.right);
        }
    }

    void printLeftBoundary(Node node) {
        if (node != null) {
            if (node.left != null) {
                System.out.println(node.data);
                printLeftBoundary(node.left);
            } else if (node.right != null) {
                printLeftBoundary(node.right);
                System.out.println(node.data);
            }
        }
    }

    void printLeaves(Node node) {
        if (node != null) {
            printLeaves(node.left);
            if (node.left == null && node.right == null)
                System.out.println(node.data);
            printLeaves(node.right);
        }
    }

    void printRightBoundary(Node node) {
        if (node != null) {
            if (node.right != null) {
                System.out.println(node.data);
                printRightBoundary(node.right);
            } else if (node.left != null) {
                printRightBoundary(node.left);
                System.out.println(node.data);
            }
        }
    }

}
