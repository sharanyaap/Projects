package example;

/**
 * Created by sharanya.p on 12/13/2017.
 */
public class CountingSort {

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] A = {3, 2, 6, 1, 8, 5, 4, 7, 9, 4};
        countingSort.countingSort(A, A.length, new int[A.length], 10);
    }

    void countingSort(int A[], int n, int B[], int k) {
        int[] C = new int[k];
        int i, j;

        // For each value in array, put count in C[index]
        for (j = 0; j < n; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        // For each value in C , add with previous number
        for (i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        // For each alue in C, put number in output array by finding index in C array and decrement index in C array for that number in A
        for (j = n - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

    }
}
