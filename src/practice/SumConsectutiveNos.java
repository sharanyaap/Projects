package practice;

import java.util.Arrays;

/**
 * Created by sharanya.p on 6/14/2018.
 */
public class SumConsectutiveNos {

    public static void main(String args[]) {
        int[] arr = {5, 0, 9, 0, 0, 2, 5, 0, 5, 5, 5};
        SumConsectutiveNos nos = new SumConsectutiveNos();
        Arrays.stream(arr).mapToObj(i -> Integer.toUnsignedString(i, 16)).forEach(System.out::print);
        int[][] res = nos.solve(arr, 7);
        //Arrays.stream(res).mapToObj(i -> Integer.toUnsignedString(i, 16)).forEach(System.out::print);
        for (int i = 0; i < res.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
        }
    }

    private int[][] solve(int arr[], int sum) {
        int[][] res = new int[arr.length][];
        int i = 0;
        int j = 0;
        int o = 0;
        int isum = arr[i];
        while (j <= i && i < arr.length) {
            checkSum(isum, sum, res, i, j, o, arr);
            if (j == arr.length - 1) {
                break;
            }
            if (i < arr.length - 1) {
                isum += arr[++i];
            }
            if (isum == sum) {
                int a = 0;
                int[] temp = new int[i - j + 1];
                for (int k = j; k <= i; k++) {
                    temp[a++] = arr[k];
                }
                res[o++] = temp;
                isum -= arr[j];
                j++;
            } else if (isum > sum) {
                isum -= arr[j];
                j++;
            }
        }
        return res;
    }

    private boolean checkSum(int isum, int sum, int[][] res, int i, int j, int o, int arr[]) {
        System.out.println("For j " + j + " and i " + i + " sum is " + isum);
        if (isum == sum) {
            int[] temp = new int[i - j + 1];
            int a = 0;
            for (int k = j; k <= i; k++) {
                temp[a++] = arr[k];
            }
            res[o++] = temp;
            return true;
        }
        return false;
    }

}
