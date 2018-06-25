package interviewbit.greedyProb;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 2/26/2018.
 */
public class Bulbs {

    public static int bulbs(ArrayList<Integer> A) {
        // int[] dp = new int[A.size()];

        // for(int i = 0; i < A.size(); i++) {
        //     dp[i] = A.get(i);
        // }
        int switchCount = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                switchCount++;
                for (int j = i; j < A.size(); j++) {
                    if (A.get(j) == 0) {
                        A.set(j, 1);
                    } else {
                        A.set(j, 0);
                    }
                }
            }
        }
        return switchCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);
        A.add(1);
        A.add(1);
        A.add(1);
        System.out.println(bulbs(A));

        //System.out.println(Integer.parseInt(args[0]));
    }

}
