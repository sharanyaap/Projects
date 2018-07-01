package practice.stack;

import java.util.Stack;

/**
 * Created by sharanya.p on 6/30/2018.
 */
public class PoisonousPlants {

    public static void main(String[] args) {
        int[] p = {6, 5, 8, 4, 7, 10, 9};
        System.out.println(poisonousPlants(p));

        p = new int[]{1, 1, 1, 1, 1};
        System.out.println(poisonousPlants(p));

        p = new int[]{1, 2, 3, 4, 5};
        System.out.println(poisonousPlants(p));
    }


    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        int n;

        /*while (true) {*/
        n = p.length - 1;
        boolean notpoi = true;
        while (n >= 0) {
            if (n == 0) {
                s.push(p[n--]);
            } else if (p[n] < p[n - 1]) {
                while (!s.isEmpty() && p[n] < s.peek()) {
                    s.pop();
                    res++;
                }
                s.push(p[n--]);
                notpoi = false;
            } else {
                n--;
            }
        }
            /*if (!poi) {
                break;
            }*/
            /*p = new int[s.size()];
            int j = 0;
            while (!s.isEmpty()) {
                p[j++] = s.pop();
            }*/
        if (!notpoi) {
            res++;
        }

        /*}*/


        return res;
    }


}
