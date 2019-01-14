package practice.bst;

/**
 * Created by sharanya.p on 9/14/2018.
 */ /* Class containing left and right child of current
node and key value*/
class Node {
    int data;
    Node left, right;
    int hd;

    public Node(int item) {
        data = item;
        left = right = null;
        hd = Integer.MAX_VALUE;
    }
}
