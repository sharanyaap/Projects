package example;

import java.util.Arrays;

/**
 * Created by sharanya.p on 12/12/2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int A[] = {7, 3, 5, 2, 5};
        int temp[] = new int[A.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(A, temp, 0, A.length - 1);
        for (int i : A
                ) {
            System.out.println(i);
        }
    }

    void mergeSort(int A[], int temp[], int left, int right) {
        int mid;
        if (left < right) {
            mid = (right + left) / 2;
            mergeSort(A, temp, left, mid);
            mergeSort(A, temp, mid + 1, right);
            merge(A, temp, left, mid + 1, right);
        }
    }

    void merge(int A[], int[] temp, int left, int mid, int right) {
        int leftEnd = mid - 1;
        int tempPos = 0;
        while (left <= leftEnd && mid <= right) {
            if (A[left] < A[mid]) {
                temp[tempPos++] = A[left++];
            } else {
                temp[tempPos++] = A[mid++];
            }
        }
        while (left <= leftEnd) {
            temp[tempPos++] = A[left++];
        }
        while (mid <= right) {
            temp[tempPos++] = A[mid++];
        }

    }


}
