package example;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sharanya.p on 1/7/2018.
 */
public class GFG {

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23,
                25, 41, 30, 40, 28,
                42, 30, 44, 48, 43,
                50};

        int m = 7;  // Number of students

        int n = arr.length;
        System.out.println("Minimum difference is "
                + findMinDiff(arr, n, m));

    }

    private static int findMinDiff(int[] arr, int n, int m) {
        int res = 99999;
        //MergeSortCountInversion.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        Arrays.sort(arr);
        for (int j: arr
             ) {
            System.out.print(j + " ");
        }
        int first = 0, last = 0;
        for (int i = 0; i < arr.length - m + 1; i++) {
            int diff = arr[i + m - 1] - arr[i];
            System.out.println("diff :: "+ diff);
            if (diff < res) {
                res = diff;
                first = i;
                last = i + m - 1;
            }
        }
        System.out.println("first :: " + arr[first] + " last :: "+ arr[last]);
        return res;
    }
}
