package example;

/**
 * Created by sharanya.p on 10/21/2017.
 */
public class StringNBits {

    private int[] A = new int[4];

    public static void main(String[] args) {
        StringNBits stringNBits = new StringNBits();
        stringNBits.solve(4);
    }

    private void solve(int n) {
        if (n < 1) {
            System.out.println(A[0] + " " + A[1] + " " + A[2] + " " + A[3]);
        } else {
            A[n - 1] = 0;
            solve(n - 1);
            A[n - 1] = 1;
            solve(n - 1);
        }
    }
}
