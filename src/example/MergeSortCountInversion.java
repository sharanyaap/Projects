package example;

/**
 * Created by sharanya.p on 1/7/2018.
 */
public class MergeSortCountInversion {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 20, 6, 4, 5};
        int[] temp = new int[arr.length];
        System.out.println("count " + mergeSort(arr, temp, 0, 4));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int mergeSort(int[] inp, int[] temp, int low, int high) {
        int count = 0;
        if (high > low) {
            int mid = (high + low) / 2;
            count += mergeSort(inp, temp, low, mid);
            count += mergeSort(inp, temp, mid + 1, high);
            count += merge(inp, temp, low, mid + 1, high);
        }
        return count;
    }

    private static int merge(int[] inp, int[] temp, int low, int mid, int high) {
        int i, j, k;
        i = low;
        j = mid;
        k = low;
        int count = 0;
        while (i <= mid - 1 && j <= high) {
            if (inp[i] < inp[j]) {
                temp[k++] = inp[i++];
            } else {
                temp[k++] = inp[j++];
                count = count + mid - 1;
            }
        }
        while (i <= mid - 1) {
            temp[k++] = inp[i++];
        }
        while (j <= high) {
            temp[k++] = inp[j++];
        }
        for (i = low; i <= high; i++) {
            inp[i] = temp[i];
        }
        return count;
    }

}
