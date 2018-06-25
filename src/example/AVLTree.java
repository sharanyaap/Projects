package example;

/**
 * Created by sharanya.p on 11/20/2017.
 */
public class AVLTree {

    // A utility function to get height of the tree
    int height(BST N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int getBalance(BST bst) {
        if (bst == null)
            return 0;
        return height(bst.left) - height(bst.right);
    }
}

class BST {
    int key;
    int height;
    BST left, right;

    BST(int n){
        key = n;
        height = 1;
    }
}
