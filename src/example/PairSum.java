package example;

/**
 * Created by sharanya.p on 1/11/2018.
 */
public class PairSum {
    private static final int MAX = 100000; // Max size of Hashmap

    public static void main(String[] args) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printpairs(A, n);
    }

    static void printpairs(int A[], int n) {

        boolean[] map = new boolean[MAX];

        for (int i = 0; i < A.length; i++) {
            int temp = n - A[i];
            if (temp >= 0 && map[temp]) {

            }
            map[A[i]] = true;
        }
    }

}
