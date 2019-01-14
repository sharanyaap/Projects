package practice.sort;

/**
 * Created by sharanya.p on 11/29/2018.
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {4, 7, 2, 6, 1, 8, 2, 5, 2, 4};
        new CountingSort().sort(arr);
    }

    private void sort(int[] arr) {
        int[] res = new int[arr.length];
        int[] carr = new int[10];

        for (int i = 0; i <= 9; i++) {
            carr[i] = 0;
        }

        for (int j = 0; j < arr.length; j++) {
            ++carr[arr[j]];
        }

        for (int j = 1; j <= 9; j++) {
            carr[j] += carr[j - 1];
        }

        for (int j = 0; j < arr.length; j++) {
            res[carr[arr[j]] - 1] = arr[j];
            --carr[arr[j]];
        }

        for (int j = 1; j < arr.length; j++) {
            System.out.println(res[j]);
        }
    }

}
