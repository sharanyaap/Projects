package practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 9/9/2018.
 */
public class CompleteBT {

    Tree root;

    public static void main(String[] args) {
        CompleteBT completeBT = new CompleteBT();
        completeBT.root = new Tree(1);
        completeBT.root.left = new Tree(2);
        completeBT.root.right = new Tree(3);
        completeBT.root.left.left = new Tree(4);
        completeBT.root.left.right = new Tree(5);
        //completeBT.root.right.right = new Tree(6);
        System.out.println(completeBT.solve());
    }

    public boolean solve() {

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            if (node.left != null) {
                if (flag) {
                    return false;
                } else {
                    queue.add(node.left);
                }
            } else {
                flag = true;
            }
            if (node.right != null) {
                if (flag) {
                    return false;
                } else {
                    queue.add(node.right);
                }
            } else {
                flag = true;
            }
        }
        return true;
    }

}

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
