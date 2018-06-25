package example;

/**
 * Created by sharanya.p on 8/23/2017.
 */
public class NewYearChaos {

    public static void main(String[] args) {
        NewYearChaos newYearChaos = new NewYearChaos();
        int[] in = {2, 5, 1, 3, 4};
        System.out.print(newYearChaos.solve(in));
    }

    private int solve(int[] in) {
        int soln = 0;
        for (int i = in.length - 1; i > 0; i--) {
            if (in[i] < in[i - 1]) {
                soln += in[i - 1] - i;
            }
        }
        return soln;
    }
}
