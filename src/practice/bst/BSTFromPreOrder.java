package practice.bst;

/**
 * Created by sharanya.p on 10/21/2018.
 */
public class BSTFromPreOrder {

    public static void main(String[] args) {
        BSTFromPreOrder tree = new BSTFromPreOrder();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        Node root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(root);
    }

    Node constructTree(int[] pre, int n) {
        return constructTreeUtil(pre, 0, n - 1);
    }

    void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.println(node.data);
            printInorder(node.right);
        }
    }

    Node constructTreeUtil(int[] pre, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new Node(pre[low]);
        }
        Node root = new Node(pre[low]);
        int i = low + 1;
        for (; i <= high; i++) {
            if (pre[i] > pre[low]) {
                break;
            }
        }
        root.left = constructTreeUtil(pre, low + 1, i - 1);
        root.right = constructTreeUtil(pre, i, high);
        return root;
    }


}