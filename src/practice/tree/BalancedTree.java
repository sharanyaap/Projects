package practice.tree;

/**
 * Created by sharanya.p on 11/26/2018.
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */
public class BalancedTree {

    Node root;

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int lh, rh;
        lh = height(node);
        rh = height(node);
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
        return false;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


}
