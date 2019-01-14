package practice.array;

/**
 * Created by sharanya.p on 11/10/2018.
 */
public class KSmallPairs {

    public static void main(String[] args) {
        int arr1[] = {1, 3, 11};
        int n1 = arr1.length;

        int arr2[] = {2, 4, 8};
        int n2 = arr2.length;

        int k = 4;
        kSmallestPair(arr1, n1, arr2, n2, k);
    }

    private static void kSmallestPair(int arr1[], int n1, int arr2[], int n2, int k) {
        int i = 0;
        int j = 0;
        int cnt = 1;
        while (i < n1 && j < n2 && cnt < k) {
            System.out.println(arr1[i] + "+" + arr2[j] + " = " + (arr1[i] + arr2[j]));
            if ((j + 1 < n2 && i + 1 < n1 && arr1[i] + arr2[j + 1] < arr1[i + 1] + arr2[j])) {
                j++;
            } else if (j + 1 < n2 && i + 1 < n1 && arr1[i] + arr2[j + 1] > arr1[i + 1] + arr2[j]) {
                i++;
            } else if (j + 1 < n2 && i + 1 < n1 && arr1[i] + arr2[j + 1] == arr1[i + 1] + arr2[j]) {
                System.out.println(arr1[i] + "+" + arr2[j + 1] + " = " + (arr1[i] + arr2[j + 1]));
                System.out.println(arr1[i + 1] + "+" + arr2[j] + " = " + (arr1[i + 1] + arr2[j]));
                cnt++;
                i++;
                j++;
            }
            cnt++;
        }

    }

}
