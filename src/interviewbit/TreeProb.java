package interviewbit;


import java.util.*;

public class TreeProb {

    public static void main(String[] args) {
        TreeProb treeProb = new TreeProb();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        treeProb.inorderTraversal(treeNode);

        treeNode = new TreeNode(3);
        treeNode.right = new TreeNode(20);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeProb.zigzagLevelOrder(treeNode);


        ArrayList<Integer> inorder = new ArrayList() {{
            add(4);
            add(8);
            add(2);
            add(5);
            add(1);
            add(6);
            add(3);
            add(7);
        }};

        ArrayList<Integer> postorder = new ArrayList() {{
            add(8);
            add(4);
            add(5);
            add(2);
            add(6);
            add(7);
            add(3);
            add(1);
        }};
        TreeNode node = treeProb.buildTree(inorder, postorder);
        System.out.println(node);

        treeProb.invertTree(node);
        System.out.println(node);

        treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(6);
        treeProb.flatten(treeNode);

        treeProb.recoverTree(treeNode);

        ArrayList<Integer> heights = new ArrayList<Integer>();
        heights.add(5);
        heights.add(3);
        heights.add(2);
        heights.add(6);
        heights.add(1);
        heights.add(4);
        ArrayList<Integer> infronts = new ArrayList<Integer>();
        infronts.add(0);
        infronts.add(1);
        infronts.add(2);
        infronts.add(0);
        infronts.add(3);
        infronts.add(2);

        ArrayList<Integer> result = treeProb.order(heights, infronts);
        System.out.println(result);
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (heights == null || infronts == null || heights.size() != infronts.size())
            return result;
        int n = heights.size();
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++)
            persons[i] = new Person(heights.get(i), infronts.get(i));
        Arrays.sort(persons, new Person());
        //System.out.println("Persons after sorting");
        //for (Person p : persons)
            //System.out.println(p.height + " " + p.infront);
        Person[] temp = new Person[n];
        for (Person p : persons) {
            int count = 0;
            //System.out.println("For person h = " + p.height + " and infront = " + p.infront);
            for (int i = 0; i < n; i++) {
                //System.out.println("\t at i = " + i);
                if (count == p.infront) {
                    while (temp[i] != null && i < n - 1)
                        i++;
                    //System.out.println("\t Putting " + p.height + " in temp at position " + i);
                    temp[i] = p;
                    break;
                }
                if (temp[i] == null) {

                    count++;
                    //System.out.println("\t Incremented count to " + count);
                }

            }
        }
        for(int i = 0; i < n; i++)
            result.add(temp[i].height);
        return result;
    }

    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        recoverTreeHelper(A);
        if (first != null)
            res.add(first.val);
        if (second != null)
            res.add(second.val);
        Collections.sort(res);
        return res;
    }

    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTreeHelper(TreeNode node) {
        if (node == null)
            return;
        else {
            recoverTreeHelper(node.left);
            if (pre == null) {
                pre = node;
            } else {
                if (pre.val > node.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = node;
                }
                pre = node;
            }
            recoverTreeHelper(node.right);
        }
    }

    public TreeNode flatten(TreeNode a) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);
        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            node.right = popped;
            node.left = null;
            node = node.right;
            if (popped.right != null)
                stack.push(popped.right);
            if (popped.left != null)
                stack.push(popped.left);
        }
        return result.right;
    }

    public TreeNode invertTree(TreeNode A) {
        if (A == null)
            return A;
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);

        A.left = right;
        A.right = left;
        return A;
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (inorder == null || postorder == null || inorder.size() == 0 || postorder.size() == 0 || inorder.size() != postorder.size())
            return null;
        return buildTree(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() - 1);
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode node = new TreeNode(postorder.get(postEnd));
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder.get(i) == node.val) {
                inIndex = i;
                break;
            }
        }

        node.left = buildTree(inorder, postorder, inStart, inIndex - 1, postStart, postStart + inIndex - (inStart + 1));
        node.right = buildTree(inorder, postorder, inIndex + 1, inEnd, postStart + inIndex - inStart, postEnd - 1);
        return node;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = A;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = a;
        ArrayList<Integer> levelList;
        stack1.push(node);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            levelList = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                levelList.add(temp.val);
                //res.add(levelList);
                // Note that is right is pushed before left
                if (temp.left != null)
                    stack2.push(temp.left);

                if (temp.right != null)
                    stack2.push(temp.right);
            }
            if (!levelList.isEmpty())
                res.add(levelList);
            levelList = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.peek();
                stack2.pop();
                //System.out.print(temp.data + " ");
                levelList.add(temp.val);
                // Note that is left is pushed before right
                if (temp.right != null)
                    stack1.push(temp.right);
                if (temp.left != null)
                    stack1.push(temp.left);
            }
            if (!levelList.isEmpty())
                res.add(levelList);
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

class Person implements Comparator<Person> {
    int height;
    int infront;

    public Person() {
    }

    public Person(int height, int infront) {
        this.height = height;
        this.infront = infront;
    }

    public int compare(Person p1, Person p2) {
        return p1.height - p2.height;
    }
}
