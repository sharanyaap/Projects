package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 1/7/2018.
 */
public class LargeSumContArray {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(solve(arr));

        List<Integer> A = new ArrayList() {{
            add(-2);
            add(1);
            add(-3);
            add(4);
            add(-1);
            add(2);
            add(1);
            add(-5);
            add(4);
        }};

        System.out.println(maxSubArray(A));

        A = new ArrayList() {{
            add(-500);
            add(-163);
            add(-20);
        }};

        System.out.println(maxSubArray(A));

    }

    public static int solve(int arr[]) {
        int maxsofar = 0, maxendinghere = 0;
        for (int i :
                arr) {
            maxendinghere = maxendinghere + i;
            if (maxendinghere < 0)
                maxendinghere = 0;
            else if (maxendinghere > maxsofar)
                maxsofar = maxendinghere;
        }
        return maxsofar;
    }

    public static int maxSubArray(final List<Integer> A) {
        int maxSoFar = -2147483648;
        int maxTillNow = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0 && maxTillNow <= 0) {
                maxTillNow = 0;
            } else if (A.get(i) <=0 && maxTillNow <=0 && A.get(i) >= maxTillNow ){
                maxTillNow = 0;
            }
            maxTillNow += A.get(i);
            if (maxSoFar <= maxTillNow) {
                maxSoFar = maxTillNow;
            }
        }
        return maxSoFar;
    }

}
