package practice.bst;

/**
 * Created by sharanya.p on 9/14/2018.
 * https://www.geeksforgeeks.org/kth-largest-element-bst-using-constant-extra-space/
 */
public class KLargestBST {

    Node root;

    public static void main(String[] args) {
        KLargestBST kLargestBST = new KLargestBST();
        kLargestBST.root = new Node(10);
        kLargestBST.root.left = new Node(4);
        kLargestBST.root.right = new Node(20);
        kLargestBST.root.left.left = new Node(2);
        //kLargestBST.root.left.right = new Node(3);
        kLargestBST.root.right.left = new Node(15);
        kLargestBST.root.right.right = new Node(40);
        int val = kLargestBST.KthLargestUsingMorrisTraversal(kLargestBST.root, 2).data;
        System.out.println("Finding K-th largest Node in BST : " + val);
    }

    Node KthLargestUsingMorrisTraversal(Node root, int k) {
        Node curr = root;
        Node Klargest = null;

        // count variable to keep count of visited Nodes
        int count = 0;

        while (curr != null) {
            // if right child is null
            if (curr.right == null) {

                // first increment count and check if count = k
                if (++count == k)
                    Klargest = curr;

                // otherwise move to the left child
                curr = curr.left;
            } else {

                // find inorder successor of current Node
                Node succ = curr.right;

                while (succ.left != null && succ.left != curr)
                    succ = succ.left;

                if (succ.left == null) {

                    // set left child of successor to the
                    // current Node
                    succ.left = curr;

                    // move current to its right
                    curr = curr.right;
                }

                // restoring the tree back to original binary
                //  search tree removing threaded links
                else {

                    succ.left = null;

                    if (++count == k)
                        Klargest = curr;

                    // move current to its left child
                    curr = curr.left;
                }
            }
        }

        return Klargest;
    }

}
