package practice.greedy;

/**
 * Created by sharanya.p on 8/17/2018.
 */
public class CoinChange {

    private int cnt = 0;

    public static void main(String[] args) {
        // All denominations of Indian Currency
        int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.findChange(deno, 70, deno.length - 1));

    }

    int findChange(int[] deno, int val, int k) {
        if (val == 0)
            return cnt;
        int i;
        for (i = k; i >= 0; i--) {
            if (deno[i] <= val) {
                val = val - deno[i];
                cnt++;
                break;
            }
        }
        return findChange(deno, val, i);
    }


}
