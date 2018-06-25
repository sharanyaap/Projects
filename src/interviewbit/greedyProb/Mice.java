package interviewbit.greedyProb;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sharanya.p on 2/28/2018.
 */
public class Mice {

    public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.isEmpty() || B.isEmpty() || A.size() != B.size())
            return 0;
        Collections.sort(A);
        Collections.sort(B);
        int maxDiff = 0;
        for (int i = 0; i < A.size(); i++) {
            maxDiff = Math.max(Math.abs(A.get(i) - B.get(i)), maxDiff);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-49);
        a.add(58);
        a.add(72);
        a.add(-78);
        a.add(9);
        a.add(65);
        a.add(-42);
        a.add(-3);


        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(30);
        b.add(-13);
        b.add(-70);
        b.add(58);
        b.add(-34);
        b.add(79);
        b.add(-36);
        b.add(27);


        System.out.println(mice(a, b));
    }
}
