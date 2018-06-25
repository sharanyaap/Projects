package interviewbit.dynamicProg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 2/15/2018.
 */
public class DynamicProb {

    public static void main(String[] args) {
        System.out.println("Using Fibonacci : " + countWays(3));


        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(8);
        a.add(4);
        a.add(12);
        a.add(2);
        a.add(10);
        a.add(6);
        a.add(14);
        a.add(1);
        a.add(9);
        a.add(5);
        a.add(13);
        a.add(3);
        a.add(11);
        a.add(7);
        a.add(15);
        System.out.println(lisDynamic(a));

        a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(4);
        System.out.println(canJumpDP(a));
    }

    public static int canJumpDP(List<Integer> a) {
        int next = a.size() - 1;

        for (int i = a.size() - 2; i >= 0; i--) {
            System.out.println("Next : " + next + " i : " + i);
            System.out.println("Check if a.get(i) " + a.get(i) + " >= " + (next - i));
            if (a.get(i) >= next - i)
                next = i;
        }
        return next == 0 ? 1 : 0;
    }

    //Dynamic Programming
    public static int lisDynamic(final List<Integer> a) {
        if (a == null || a.size() == 0)
            return 0;
        if (a.size() == 1)
            return 1;
        int[] lis = new int[a.size()];
        int n = a.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a.get(i) > a.get(j) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
            for (int k = 0; k < n; k++)
                System.out.print(lis[k] + " ");
            System.out.println();
        }

        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i]);


        System.out.println();
        return max;
    }

    static int[] fib = new int[100];

    public static int countWays(int a) {
        return fibonacci(a + 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        if (fib[n] != 0)
            return fib[n];
        fib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return fib[n];
    }

}
