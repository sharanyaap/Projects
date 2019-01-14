package practice.dp;

/**
 * Created by sharanya.p on 11/10/2018.
 */
public class MaxSumIncSubSeq {

    public static void main(String[] args) {
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(new MaxSumIncSubSeq().solve(arr));
    }

    private int solve(int[] arr) {
        int result = 0;
        int temp[] = new int[arr.length];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                temp[i] = temp[i - 1] + arr[i];
            } else {
                temp[i] = arr[i];
            }
            if (temp[i] > result) {
                result = temp[i];
            }
        }
        return result;
    }


}
