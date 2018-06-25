package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 1/17/2018.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.sqrt(2147483647);

        List<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(8);
        A.add(10);
        binarySearch.searchRange(A, 8);


        List<Integer> a = new ArrayList<Integer>();
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(binarySearch.searchRotated(a, 2));

        binarySearch.pow(2,5,3);
    }

    public int pow(int x, int n, int d) {
        long a = x;
        long result = 1;
        while (n > 0) {
            // System.out.println("For n = " + n);
            if (n % 2 == 1) {
                result = result * a;
                result = result % d;
            }

            a = a * a;
            a = a % d;
            n = n >> 1;
            // System.out.println("\t result = " + result + " \n \t a = " + a);
        }
        result = (result + d) % d;
        return (int) result;
    }

    public int searchRotated(final List<Integer> a, int b) {
        int start = 0;
        int end = a.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (a.get(mid) == b)
                return mid;
            if (a.get(start) <= a.get(mid)) {
                if (a.get(start) <= b && b < a.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (a.get(mid) < b && b <= a.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = a.size() - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (b > a.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int low = 0;
        if (b != a.get(start)) {
            res.add(-1);
            res.add(-1);
            return res;
        } else
            low = start;

        start = 0;
        end = a.size() - 1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (b + 1 > a.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int high = 0;
        if (a.get(start) == b) {
            high = start;
        } else {
            high = start - 1;
        }
        res.add(low);
        res.add(high);
        return res;
    }

    public int sqrt(int a) {
        if (a == 0 || a == 1) {
            return a;
        }
        long start = 1;
        long end = a;
        int ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long val = mid * mid;
            if (val == a) {
                return (int) mid;
            }
            if (val < a) {
                start = (int) mid + 1;
                ans = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }
        return ans;
    }

}
