package practice.tree;

/**
 * Created by sharanya.p on 11/26/2018.
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 */
public class MorrisTraversal {

    Node root;

    public static void main(String[] args) {
        /* Constructed binary tree is
               1
             /   \
            2      3
          /  \
        4     5
        */
        MorrisTraversal tree = new MorrisTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.MorrisTraversal(tree.root);
    }

    private void MorrisTraversal(Node node) {
        Node current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.data);
                current = current.right;
            } else {
                Node lr = current.left;
                while (lr.right != null && lr.right != current) {
                    lr = lr.right;
                }
                if (lr.right == null) {
                    lr.right = current;
                    current = current.left;
                } else {
                    lr.right = null;
                    System.out.println(current.data);
                    current = current.right;
                }
            }
        }
    }

}
