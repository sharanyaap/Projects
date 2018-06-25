package interviewbit.greedyProb;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by sharanya.p on 2/28/2018.
 */
public class Majority {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(3);

        System.out.println(majorityElementEfficient(a));
    }

    public static int majorityElementEfficient(ArrayList<Integer> A) {
        if (A.isEmpty()){
            return 0;
        }
        if (A.size()==1){
            return A.get(0);
        }
        int res = 0;
        Collections.sort(A);
        int count = 1;
        int maxCnt = 0;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i - 1).equals(A.get(i))) {
                count++;
                if (count > maxCnt) {
                    maxCnt = count;
                    res = A.get(i);
                }
            } else {
                count = 1;
            }
        }
        return res;
    }
}
