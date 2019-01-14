package practice.sort;

import java.util.Arrays;

/**
 * Created by sharanya.p on 11/29/2018.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int arr[] = {7, 4, 6, 2, 3, 1, 9};
        new InsertionSort().sort(arr);
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }


}
