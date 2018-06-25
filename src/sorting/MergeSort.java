package sorting;

/**
 * Created by sharanya.p on 5/13/2018.
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public void sort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, h);
            // Merge the sorted halves
            merge(arr, l, mid, h);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int tempMergArr[] = new int[arr.length];
        for (int i = low; i <= high; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempMergArr[i] < tempMergArr[j]) {
                arr[k++] = tempMergArr[i++];
            } else {
                arr[k++] = tempMergArr[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = tempMergArr[i++];
        }
        while (j <= high) {
            arr[k++] = tempMergArr[j++];
        }
    }

}
