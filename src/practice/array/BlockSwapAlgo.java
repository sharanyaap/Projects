package practice.array;

import java.util.Arrays;

/**
 * Created by sharanya.p on 11/10/2018.
 */
public class BlockSwapAlgo {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        BlockSwapAlgo blockSwapAlgo = new BlockSwapAlgo();
        blockSwapAlgo.leftRotate(arr, 3, arr.length);
        //Arrays.stream(arr).forEach(i -> System.out.print(i+ " "));
    }

    void leftRotate(int arr[], int d, int n) {
        if (d == 0 || d == n)
            return;
        int i = d;
        int j = n - d;
        while (i != j) {
            if (i < j) {
                swap(arr, d - i, d + j - i, i);
                j -= i;
            } else {
                swap(arr, d - i, d, j);
                i -= j;
            }
        }
        /*Finally, block swap A and B*/
        swap(arr, d - i, d, i);
    }

    /*This function swaps d elements starting at index fi
  with d elements starting at index si */
    void swap(int arr[], int fi, int si, int d) {
        int i, temp;
        System.out.println("fi :: " + fi + " si :: " + si + " d :: " + d);
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        System.out.println("");
    }


}
