package practice.bst;

import java.util.Arrays;

/**
 * Created by sharanya.p on 9/14/2018.
 * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 */
public class ConstructBST {

    Node root = null;

    public static void main(String[] args) {
        int[] preOrder = new int[]{10, 5, 1, 7, 40, 50};
        ConstructBST constructBST = new ConstructBST();
        Node node = constructBST.root;
        constructBST.constructBST(preOrder);
    }

    public Node constructBST(int[] preOrder) {
        if (preOrder == null || preOrder.length == 0)
            return null;
        root = new Node(preOrder[0]);
        int[] left;
        int[] right;
        int i = 1;
        for (; i < preOrder.length; i++) {
            if (preOrder[i] > preOrder[0]) {
                break;
            }
        }
        left = Arrays.copyOfRange(preOrder, 1, i);
        root.left = constructBST(left);
        right = Arrays.copyOfRange(preOrder, i, preOrder.length);
        root.right = constructBST(right);
        return root;
    }


}
