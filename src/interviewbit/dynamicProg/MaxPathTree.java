package interviewbit.dynamicProg;

/**
 * Created by sharanya.p on 2/21/2018.
 */
public class MaxPathTree {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(1);
        tree.right.left = new TreeNode(4);

        MaxPathTree maxPathTree = new MaxPathTree();
        System.out.println(maxPathTree.maxPathSum(tree));
    }

    public int maxPathSum(TreeNode a) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(a, max);
        return max[0];

    }

    public int calculateSum(TreeNode node, int[] max) {
        if (node == null)
            return 0;

        int left = calculateSum(node.left, max);
        int right = calculateSum(node.right, max);

        int current = Math.max(node.val, Math.max(node.val + left, node.val + right));
        max[0] = Math.max(max[0], Math.max(current, left + node.val + right));
        return current;
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
