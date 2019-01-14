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
        Node n = node;
        while (n != null) {
            if (n.left == null) {
                System.out.println(n.data + "  ");
                n = n.right;
            } else {
                Node temp = n.left;
                while (temp.right != null && temp.right != n) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = n;
                    n = n.left;
                } else {
                    temp.right = null;
                    System.out.println(n.data + "  ");
                    n = n.right;
                }
            }
        }
    }

}
