package interviewbit.graphProb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 3/1/2018.
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.left.left = new TreeNode(15);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(node));
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            currentLevelNum--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNum++;
            }
            list.add(node.val);
            if (currentLevelNum == 0) {
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                //result.add(new ArrayList<Integer>(list));
                res.add(list);
                list.clear();
            }

        }
        return res;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
