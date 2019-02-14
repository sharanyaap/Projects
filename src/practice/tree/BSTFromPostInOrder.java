package practice.tree;

/**
 * Created by sharanya.p on 1/15/2019.
 */
public class BSTFromPostInOrder {

    public static void main(String[] args) {
        BSTFromPostInOrder tree = new BSTFromPostInOrder();
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n = in.length;
        Node root = tree.buildTree(in, post, n);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }

    public Node buildTree(int in[], int post[], int n) {
        return null;
    }

    public Node buildTreeUtil() {
        return null;
    }

    /* This funtcion is here just to test  */
    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


}
