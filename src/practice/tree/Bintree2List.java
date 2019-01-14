package practice.tree;

/**
 * Created by sharanya.p on 9/14/2018.
 */
public class Bintree2List {

    Node root;

    /* Driver program to test above functions*/
    public static void main(String[] args) {
        Bintree2List tree = new Bintree2List();

        // Let us create the tree shown in above diagram
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // Convert to DLL
        Node head = tree.bintree2list(tree.root);

        // Print the converted list
        tree.printList(head);
    }

    Node bintree2list(Node node) {
        // Base case
        if (node == null)
            return node;

        // Convert to DLL using bintree2listUtil()
        node = bintree2listUtil(node);

        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null)
            node = node.left;

        return node;
    }

    Node bintree2listUtil(Node node) {
        if (node == null)
            return node;
        if (node.left != null) {
            // Convert the left subtree
            Node left = bintree2listUtil(node.left);

            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);

            // Make root as next of the predecessor
            left.right = node;

            // Make predecssor as previous of root
            node.left = left;

        }
        // Convert the right subtree and link to root
        if (node.right != null)
        {
            // Convert the right subtree
            Node right = bintree2listUtil(node.right);

            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);

            // Make root as previous of successor
            right.left = node;

            // Make successor as next of root
            node.right = right;
        }

        return node;
    }

    /* Function to print nodes in a given doubly linked list */
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

}

