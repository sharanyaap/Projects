package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by sharanya.p on 1/23/2018.
 */
public class TwoPointer {

    public static void main(String[] args) {
        TwoPointer twoPointer = new TwoPointer();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(0);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(2);
        a.add(0);
        a.add(1);
        a.add(5000);
        a.add(5000);
        a.add(5000);
        Collections.sort(a);
        System.out.println(twoPointer.removeDuplicates(a));

        a = new ArrayList<Integer>();
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(-4);
        System.out.println(twoPointer.threeSumClosest(a, 1));

        a = new ArrayList<Integer>();
        a.add(1);
        a.add(1);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(0);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(1);
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = twoPointer.maxone(a, 1);
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + " ");

        List<Integer> A = new ArrayList() {{
            add(10000000);
        }};
        List<Integer> B = new ArrayList() {{
            add(10000000);
        }};
        System.out.println(twoPointer.intersect(A, B));


        a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.add(8);
        a.add(10);
        List<Integer> b = new ArrayList<Integer>();
        b.add(6);
        b.add(9);
        b.add(15);
        List<Integer> c = new ArrayList<Integer>();
        c.add(2);
        c.add(3);
        c.add(6);
        c.add(6);
        System.out.println(twoPointer.minimize(a, b, c));
        System.out.println(twoPointer.minimizeBetter(a, b, c));

        Integer arr[] = new Integer[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        List<Integer> l = Arrays.asList(arr);

        arr = new Integer[]{1, 5, 4, 3};
        l = Arrays.asList(arr);
        System.out.println(twoPointer.maxArea(l));
    }

    int maxArea(List<Integer> A) {
        int l = 0;
        int r = A.size() - 1;
        int area = 0;
        while (l < r) {
            area = Math.max(Math.min(A.get(l), A.get(r)) * (r - l), area);
            if (A.get(l) < A.get(r)) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }


    int findWater(List<Integer> A) {
        int res = 0;
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        left[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            left[i] = Math.max(left[i - 1], A.get(i));
        }
        right[A.size() - 1] = A.get(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A.get(i));
        }
        for (int i = 0; i < A.size(); i++)
            res += Math.max(left[i], right[i]) - A.get(i);
        return res;
    }

    public int minimize(List<Integer> A, List<Integer> B, List<Integer> C) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                for (int k = 0; k < C.size(); k++) {
                    int max1 = Math.max(Math.abs(A.get(i) - B.get(j)),
                            Math.abs(B.get(j) - C.get(k)));
                    int max2 = Math.max(max1,
                            Math.abs(C.get(k) - A.get(i)));
                    if (max2 < result)
                        result = max2;
                }
            }
        }
        return result;
    }

    public static int minimizeBetter(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i, j, k;
        for (i = 0, j = 0, k = 0; i < A.size() && j < B.size() && k < C.size(); ) {
            min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            diff = Math.min(diff, max - min);
            if (diff == 0)
                break;
            if (A.get(i) == min)
                i++;
            else if (B.get(j) == min)
                j++;
            else
                k++;
        }
        return diff;
    }

    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                result.add(k++, A.get(i));
                i++;
                j++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else if (B.get(j) > A.get(i)) {
                i++;
            }
        }
        return result;
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int maxLength = 0;
        int start = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int curZerosCnt = 0;
        int curStart = 0;
        int curLength = 0;


        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                curZerosCnt++;
            }
            if (A.get(i) == 0 && curZerosCnt > B) {
                int nStart = findLeftMostZeroInclusive(A, curStart);
                curLength -= nStart - curStart - 1;
                curStart = nStart;
                curZerosCnt--;
                continue;
            }
            if (++curLength > maxLength) {
                start = curStart;
                maxLength = curLength;
            }

        }

        // Move from start, flip m zero elements to 1
        int i = start;
        int j = 0;
        for (int p = B; i < A.size() && (p > 0 || j < maxLength); i++) {
            if (A.get(i) == 0) {
                result.add(i);
                j++;
                p--;
            } else {
                result.add(i);
                j++;
            }
        }

        return result;
    }

    private int findLeftMostZeroInclusive(ArrayList<Integer> arr, int curStart) {
        int i = curStart;
        while (arr.get(i) != 0 && arr.size() > i - 1) {
            i++;
        }

        // returning the next element after 0
        return i + 1;
    }

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int result = 0;
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int j = i + 1;
            int k = A.size() - 1;
            while (j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);
                int diff = Math.abs(sum - B);
                if (diff == 0)
                    return sum;
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= B) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        if (a == null || a.isEmpty())
            return 0;
        int j = 1;
        for (int i = 1; i < a.size(); i++) {
            if (!a.get(i).equals(a.get(j - 1))) {
                a.add(j, a.get(i));
                j++;
            }
        }
        return j;
    }
}
