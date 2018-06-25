package example;

import java.util.Stack;

/**
 * Created by sharanya.p on 1/9/2018.
 */
public class LevelOrderSpiral {

    TreeNode root;

    public static void main(String[] args) {
        LevelOrderSpiral levelOrderSpiral = new LevelOrderSpiral();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);
        levelOrderSpiral.root = tree;
        System.out.println("Spiral Order traversal of Binary Tree is ");
        levelOrderSpiral.printSpiral(tree);
    }

    public void printSpiral(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                TreeNode node = s1.peek();
                s1.pop();
                System.out.println(" " + node.data);
                if (node.left != null)
                    s2.push(node.left);
                if (node.right != null)
                    s2.push(node.right);
            }

            while (!s2.empty()) {
                TreeNode node = s2.peek();
                s2.pop();
                System.out.println(" " + node.data);
                if (node.right != null)
                    s1.push(node.right);
                if (node.left != null)
                    s1.push(node.left);
            }

        }


    }

    int getMaxWidth(TreeNode node) {
        int width;
        int h = height(node);

        // Create an array that will store count of nodes at each level
        int count[] = new int[10];

        int level = 0;

        // Fill the count array using preorder traversal
        getMaxWidthRecur(node, count, level);

        // Return the maximum value from count array
        return getMax(count, h);
    }

    /* UTILITY FUNCTIONS */

    /* Compute the "height" of a tree -- the number of
     nodes along the longest path from the root node
     down to the farthest leaf node.*/
    int height(TreeNode node) {
        if (node == null)
            return 0;
        else {
            /* compute the height of each subtree */
            int lHeight = height(node.left);
            int rHeight = height(node.right);

            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }

    // Return the maximum value from count array
    int getMax(int arr[], int n) {
        int max = arr[0];
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    // A function that fills count array with count of nodes at every
    // level of given binary tree
    void getMaxWidthRecur(TreeNode node, int count[], int level) {
        if (node != null) {
            count[level]++;
            getMaxWidthRecur(node.left, count, level + 1);
            getMaxWidthRecur(node.right, count, level + 1);
        }
    }

}

class TreeNode {
    public int data;

    public TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

}
