package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sharanya.p on 1/22/2018.
 */
public class BitManipulation {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList() {{
            add(9);
            add(5);
            add(3);
        }};
        BitManipulation bit = new BitManipulation();
        System.out.println(bit.minXOR(list));

        list = new ArrayList() {{
            add(0);
            add(2);
            add(5);
            add(7);
        }};
        System.out.println(bit.minXOR(list));

        list = new ArrayList() {{
            add(0);
            add(4);
            add(7);
            add(9);
        }};
        System.out.println(bit.minXOR(list));

        list = new ArrayList() {{
            add(1);
            add(1);
            add(3);
            add(3);
            add(6);
            add(6);
            add(8);
            add(8);
            add(2);
        }};
        System.out.println(bit.singleNumber(list));
    }

    public int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result = result ^ A.get(i);
        }
        return result;
    }

    public int numSetBits(long a) {
        int result = 0;
        while (a > 0) {
            if (a % 2 == 1) {
                result++;
            }
            a = a / 2;
        }
        return result;
    }

    private int minXOR(ArrayList<Integer> A) {
        Collections.sort(A);
        int minXOR = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++) {
            int xor = A.get(i) ^ A.get(i + 1);
            if (xor < minXOR) {
                minXOR = xor;
            }
        }
        return minXOR;
    }

}
