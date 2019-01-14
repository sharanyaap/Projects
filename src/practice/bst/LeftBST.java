package practice.bst;

/**
 * Created by sharanya.p on 8/15/2018.
 */
public class LeftBST {

    Node root;
    static int max_level = 0;

    // A wrapper over leftViewUtil()
    void leftView() {
        leftViewUtil(root, 1);
    }

    void leftViewUtil(Node node, int level) {
        if (node == null)
            return;
        if (max_level < level) {
            System.out.println(node.data);
            max_level += 1;
        }
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    /* testing for example nodes */
    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        LeftBST tree = new LeftBST();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView();
    }


}
// Java program to print left view of binary tree

