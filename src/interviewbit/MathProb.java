package interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by sharanya.p on 1/15/2018.
 */
public class MathProb {

    public int solve2(ArrayList<Integer> A, int B, int C) {
        int res = 0;
        int d = A.size();
        if (B > C || d == 0){
            return res;
        }
        return res;
    }

    public int isPrime(int A) {
        if (A == 0 || A == 1) {
            return 0;
        }
        int upperLimit = (int) (Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a * a < A; a++) {
            for (int b = 0; b * b < A; b++) {
                if (a * a + b * b == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    boolean found = false;
                    for (ArrayList<Integer> integer : ans) {
                        if (integer.contains(a) && integer.contains(b))
                            found = true;
                    }
                    if (!found) {
                        ans.add(newEntry);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public int isPower(int A) {
        if (A == 1) {
            return 1;
        }
        int ispower = 0;
        for (int i = 2; i <= Math.sqrt(A); i++) {
            int y = 2;
            double val = Math.pow(i, y);
            while (val <= A && val > 0) {
                if (val == A)
                    return 1;
                y++;
                val = Math.pow(i, y);
            }
        }
        return ispower;
    }

    public int isPalindrome(int A) {
        if (A == 0)
            return 1;
        if (A >= 1) {
            int divisor = 1;
            while (A / divisor >= 10) {
                divisor *= 10;
            }
            while (A != 0) {

                int leading = A / divisor;
                int tailing = A % 10;
                if (leading != tailing)
                    return 0;
                A = (A % divisor) / 10;
                divisor = divisor / 100;
            }
            return 1;
        }
        return 0;
    }

    int titleToNumber(String s) {
        int res = 0;
        for (char a : s.toCharArray()) {
            res *= 26;
            res += a - 'A' + 1;
        }
        return res;
    }

    int gcd(int a, int b) {
        // Everything divides 0
        if (a == 0 || b == 0)
            return 0;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

    int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int res = 0;
        Stack<ArrayList<Integer>> s = new Stack<>();
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList();
        list.add(i);
        list.add(j);
        s.push(list);
        int r = A.size();
        int c = A.get(0).size();
        while (!s.isEmpty() && i < r && j < c) {
            ArrayList<Integer> pop = s.pop();
            i = pop.get(0);
            j = pop.get(1);
            if (i + 1 < r) {
                if (A.get(i + 1).get(j) == 0) {
                    list = new ArrayList();
                    list.add(i + 1);
                    list.add(j);
                    s.push(list);
                } else {
                    res += 1;
                }
            }
            if (j + 1 < c) {
                if (A.get(i).get(j + 1) == 0) {
                    list = new ArrayList();
                    list.add(i);
                    list.add(j + 1);
                    s.push(list);
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    public void arrange(ArrayList<Integer> a) {

        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) + ((a.get(a.get(i)) % a.size()) * a.size()));
        }

        // Second Step: Divide all values by n
        for (int i = 0; i < a.size(); i++)
            a.set(i, a.get(i) / a.size());
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        int res = 0;
        int[] c = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            c[i] = A.get(i);
        }
        res = printAllKLengthRec(c, "", A.size(), B, res, C, B);
        return res;
    }

    // The main recursive method to print all possible strings of length k
    int printAllKLengthRec(int set[], String prefix, int n, int k, int res, int C, int ksize) {

        // Base case: k is 0, print prefix
        if (k == 0) {
            Integer val = Integer.valueOf(prefix);
            if (val.toString().length() == ksize && val < C) {
                System.out.println(prefix);
                res += 1;
            }
            return res;
        }

        // One by one add all characters from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i) {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because we have added a new character
            res = printAllKLengthRec(set, newPrefix, n, k - 1, res, C, ksize);
        }
        return res;
    }

    public static void main(String[] args) {
        MathProb mathProb = new MathProb();
        /*System.out.println(mathProb.isPrime(4));

        System.out.println(mathProb.squareSum(5));

        System.out.println(mathProb.isPower(1024000000));

        System.out.println(mathProb.isPalindrome(1));

        System.out.println(mathProb.titleToNumber("CDA"));

        System.out.println(mathProb.gcd(1, 0));*/

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> r1 = new ArrayList() {{
            add(0);
            add(0);
            add(0);
            add(0);
        }};
        ArrayList<Integer> r2 = new ArrayList() {{
            add(0);
            add(1);
            add(1);
            add(0);
        }};
        ArrayList<Integer> r3 = new ArrayList() {{
            add(0);
            add(0);
            add(0);
            add(0);
        }};
        a.add(r1);
        a.add(r2);
        a.add(r3);
        mathProb.uniquePathsWithObstacles(a);


        ArrayList<Integer> list = new ArrayList() {{
            add(3);
            add(2);
            add(0);
            add(1);
        }};

        mathProb.arrange(list);

        list = new ArrayList() {{
            add(0);
            add(1);
            add(2);
            add(5);
        }};
        System.out.println(mathProb.solve(list, 2, 21));
    }
}
