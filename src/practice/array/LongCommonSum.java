package practice.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharanya.p on 11/10/2018.
 */
public class LongCommonSum {

    public static void main(String[] args) {
        int arr1[] = {0, 1, 0, 1, 1, 1, 1};
        int arr2[] = {1, 1, 1, 1, 1, 0, 1};
        int n = arr1.length;
        System.out.println(longestCommonSum(arr1, arr2, n));
    }

    public static int longestCommonSum(int[] arr1, int[] arr2, int n) {
        int res = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = arr1[i] - arr2[i];
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0)
                max_len = i + 1;
            map.put(sum, i);
        }
        return max_len;
    }

}
