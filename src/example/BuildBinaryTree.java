package example;

/**
 * Created by sharanya.p on 11/2/2017.
 */
public class BuildBinaryTree {

    public static int preOrderIndex = 0;

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
        Tree tree = buildBinaryTree.buildBinaryTree(inOrder, preOrder, 0, inOrder.length - 1);
        System.out.println(tree);
    }

    private Tree buildBinaryTree(int[] inorder, int[] preorder, int startInOrder, int endInOrder) {
        if (startInOrder > endInOrder)
            return null;
        Tree newNode = new Tree();
        newNode.data = preorder[preOrderIndex];
        preOrderIndex++;
        //Call search
        int inOrderRoot = searchNodeIndex(inorder, newNode.data, startInOrder, endInOrder);
        newNode.left = buildBinaryTree(inorder, preorder, startInOrder, inOrderRoot - 1);
        newNode.right = buildBinaryTree(inorder, preorder, inOrderRoot + 1, endInOrder);
        return newNode;
    }

    private int searchNodeIndex(int[] inOrder, int data, int startInOrder, int endInOrder) {
        if (startInOrder > endInOrder)
            return 0;
        for (int i = startInOrder; i <= endInOrder; i++) {
            if (inOrder[i] == data)
                return i;
        }
        return 0;
    }

}

class Tree {
    int data;
    Tree left;
    Tree right;
}
