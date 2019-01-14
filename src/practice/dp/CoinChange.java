package practice.dp;

/**
 * Created by sharanya.p on 10/7/2018.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] in = {1, 2, 3};
        CoinChange change = new CoinChange();
        System.out.println(change.solve(in, in.length, 4));
    }

    int solve(int[] s, int m, int n) {
        int[] tab = new int[n + 1];
        tab[0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = s[i]; j <= n; j++)
                tab[j] += tab[j - s[i]];

        return tab[n];
    }

}
