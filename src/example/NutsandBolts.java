package example;

/**
 * Created by sharanya.p on 8/28/2017.
 */
public class NutsandBolts {

    public static void main(String[] args) {
        NutsandBolts nutsandBolts = new NutsandBolts();
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        nutsandBolts.solve(ints, 0, ints.length - 1);
        // 1 7 2 8 3 9 4 10
    }

    private void solve(int[] ints, int l, int r) {
        if (l + 1 >= r)
            return;
        int mid;
        int midl;
        mid = ((r - l + 1) / 2) + l;
        midl = ((mid - l) / 2) + l;
        System.out.println("");
        System.out.println("midl " + midl);
        System.out.println("mid " + mid);

        for (int i = midl, j = mid; i < mid; i++, j++) {
            int t = ints[i];
            ints[i] = ints[j];
            ints[j] = t;
        }

        for (int k : ints) {
            System.out.print(k + " ");
        }

        solve(ints, l, mid - 1);
        solve(ints, mid, r);

    }

}
