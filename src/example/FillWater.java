package example;

/**
 * Created by sharanya.p on 1/9/2018.
 */
public class FillWater {

    static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    // Driver method to test the above function
    public static void main(String[] args) {

        System.out.println("Maximum water that can be accumulated is " +
                findWater(arr.length));
    }

    // Method for maximum amount of water
    static int findWater(int n) {
        int water = 0;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        for (int j = 1; j < n; j++) {
            left[j] = Math.max(left[j - 1], arr[j]);
        }
        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }

}
