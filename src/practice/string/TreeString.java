package practice.string;

/**
 * Created by sharanya.p on 1/13/2019.
 * <p>
 * https://www.geeksforgeeks.org/product-nodes-k-th-level-tree-represented-string/
 */
public class TreeString {
    public static void main(String args[]) {
        String s = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        System.out.println(new TreeString().solve(s, k));
    }

    private int solve(String s, int k) {
        int res = 1;
        int level = -1;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                level++;
            } else if (cs[i] == ')') {
                level--;
            } else if (level == k) {
                res = res * (s.charAt(i) - '0');
            }
        }
        return res;
    }

}
