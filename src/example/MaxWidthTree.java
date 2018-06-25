package example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 1/9/2018.
 */
public class MaxWidthTree {

    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.right = new node(8);
        root.right.right.left = new node(6);
        root.right.right.right = new node(7);

                /*   Constructed Binary tree is:
                1
              /   \
            2      3
          /  \      \
         4    5      8
                   /   \
                  6     7    */

        System.out.println("Maximum width = " + maxwidth(root));
    }

    /* A binary tree node has data, pointer to
       left child and a pointer to right child */
    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
        }
    }

    public static int maxwidth(node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;

        Queue<node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            max = Math.max(q.size(), max);
            node node = q.remove();
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        return max;
    }

}
