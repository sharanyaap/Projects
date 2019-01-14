package practice.dp;

/**
 * Created by sharanya.p on 7/17/2018.
 */
public class LIS {

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is "
                + lis(arr, n) + "n");
    }

    static int lis(int[] arr, int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
        }
        int max = 1;
        /* Pick maximum of all LIS values */
        for (int i = 0; i   < n; i++)
            if (max < res[i])
                max = res[i];
        return max + 1;
    }

}
