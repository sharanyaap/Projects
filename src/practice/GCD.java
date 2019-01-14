package practice;

/**
 * Created by sharanya.p on 10/23/2018.
 */
public class GCD {

    public int generalizedGCD(int num, int[] arr) {
        // WRITE YOUR CODE HERE

        int result = 1;
        for (int i = 1; i < arr[num - 1]; i++) {
            boolean divisible = true;
            for (int j = 0; j < num; j++) {
                if (arr[j] % i != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                result = i;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int arr[] = {2, 4, 6, 8, 10};
        System.out.println(gcd.generalizedGCD(arr.length, arr));
    }
}
