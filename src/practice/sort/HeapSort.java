package practice.sort;

/**
 * Created by sharanya.p on 11/29/2018.
 */
public class HeapSort {

    int[] heap;

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.heap = new int[]{2, 5, 7, 1, 2, 9, 6, 4};
        heapSort.heapSort(heapSort.heap, heapSort.heap.length);
    }

    private void heapSort(int[] heap, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, n);
        }

        printArray(heap);

        for (int i = n - 1; i >= 0; i--) {
            int temp = heap[i];
            heap[i] = heap[0];
            heap[0] = temp;
            heapify(0, i);
        }

        printArray(heap);

    }


    /* A utility function to print array of size n */
    private void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private void heapify(int i, int n) {
        int l = getLeft(i);
        int r = getRight(i);
        //int n = heap.length;
        int large = i;
        if (l >= 0 && l < n && heap[l] > heap[large]) {
            large = l;
        }
        if (r >= 0 && r < n && heap[r] > heap[large]) {
            large = r;
        }
        if (large != i) {
            int temp = heap[large];
            heap[large] = heap[i];
            heap[i] = temp;
            heapify(large, n);
        }
    }

    public int getLeft(int i) {
        return 2 * i + 1;
    }

    public int getRight(int i) {
        return 2 * i + 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

}
