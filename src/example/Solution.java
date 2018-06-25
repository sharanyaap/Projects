package example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sharanya.p on 1/14/2018.
 */
public class Solution {

    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        Long maxSoFar = 0l;
        Long maxTillNow = 0l;
        int startInd = 0;
        int tempStartInd = 0;
        int endInd = 0;
        boolean restart = false;
        boolean cameHere = false;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                maxTillNow += A.get(i);
            } else {
                maxTillNow = 0l;
                restart = true;
                tempStartInd = i + 1;
            }
            if ((restart && maxSoFar < maxTillNow) || (!restart && maxSoFar <= maxTillNow)) {
                if (restart) {
                    restart = false;
                    startInd = tempStartInd;
                }
                maxSoFar = maxTillNow;
                endInd = i;
                cameHere = true;
            }
        }
        if (cameHere && endInd >= startInd) {
            for (int j = startInd; j <= endInd; j++) {
                res.add(A.get(j));
            }
        }
        return res;
    }


    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        while (B > A.size()) {
            B = B - A.size();
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            if (i + B >= A.size()) {
                ret.add(A.get((i + B) - A.size()));
            } else {
                ret.add(A.get(i + B));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> A = new ArrayList<>();
        /*A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);*/

        /*A.add(-1);
        A.add(-1);
        A.add(-1);
        A.add(-1);*/

        /*A.add(-846930886);
        A.add(-1714636915);
        A.add(424238335);
        A.add(-1649760492);*/

        /*A.add(1967513926);
        A.add(1540383426);
        A.add(-1714636915);
        A.add(-1714636915);*/

        /*A.add(-1469348094);
        A.add(1036140795);
        A.add(2040651434);
        A.add(-317097467);
        A.add(1376710097);
        A.add(1330573317);
        A.add(1687926652);

        solution.maxset(A);*/

        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        // solution.rotateArray(A, 9);

        ArrayList<Integer> i1 = new ArrayList() {{
            add(1);
            add(2);
        }};
        ArrayList<Integer> i2 = new ArrayList() {{
            add(3);
            add(4);
        }};
        ArrayList<Integer> i3 = new ArrayList() {{
            add(5);
            add(6);
        }};
        List<ArrayList<Integer>> in = new ArrayList<>();
        in.add(i1);
        in.add(i2);
        in.add(i3);
        solution.spiralOrder(in);
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int t = 0, b = A.size() - 1, r = A.get(0).size() - 1, l = 0;
        String dir = "r";
        boolean done = true;
        while (done) {
            done = false;
            if (dir.equalsIgnoreCase("r")) {
                while (j >= l && j <= r) {
                    res.add(A.get(i).get(j));
                    j++;
                    done = true;
                }
                dir = "d";
                t++;
                i++;
                j--;
            } else if (dir.equalsIgnoreCase("d")) {
                while (i >= t && i <= b) {
                    res.add(A.get(i++).get(j));
                    done = true;
                }
                dir = "l";
                r--;
                i--;
                j--;
            } else if (dir.equalsIgnoreCase("l")) {
                while (j >= l && j <= r) {
                    res.add(A.get(i).get(j));
                    j--;
                    done = true;
                }
                b--;
                i--;
                j++;
                dir = "u";
            } else {
                while (i >= t && i <= b) {
                    res.add(A.get(i).get(j));
                    i--;
                    done = true;
                }
                dir = "r";
                l++;
                j++;
                i++;
            }
        }

        return res;
    }

}
