package practice.array;

/**
 * Created by sharanya.p on 11/25/2018.
 */
public class LargeSumContiquous {

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        new LargeSumContiquous().solve(arr);
    }

    private void solve(int[] arr) {
        int curr_max = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr_max = Math.max(arr[i], arr[i]+ curr_max);
            max=Math.max(curr_max, max);
        }
        System.out.println(max);
    }

}
