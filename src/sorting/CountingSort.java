package sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharanya.p on 5/3/2018.
 */
public class CountingSort {

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        /*Integer arr[] = {4, 6, 7, 1, 2, 8};*/
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };
        /*List<Integer> res = */
        countingSort.sort(arr);
        /*for (Integer i : res) {
            System.out.println(i);
        }*/
        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]);
    }

    public void sort(char arr[]) {
        int n = arr.length;
        char[] output = new char[arr.length];
        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < arr.length; ++i)
            ++count[arr[i]];
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }
}
