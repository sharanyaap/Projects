package practice.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 10/23/2018.
 */
public class TwoArray {

    public static void main(String[] args) {
        int[] a1 = {2,5,5,6,7};
        int[] a2 = {3,5,7,9};
        TwoArray twoArray = new TwoArray();
        twoArray.findSum(a1,a2, 10);
    }

    List<List<Integer>> findSum(int[] a1, int[] a2, int sum){
        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        int n = a1.length-1;
        int j = a2.length -1;
        int m = a2.length - 1;
        int su = 0;
        while (i <= n && j >=0){
            su = a1[i] + a2[j];
            if (su == sum){
                System.out.println(a1[i] + " "+ a2[j]);
                i++;
            }
            else if (su < sum){
                i++;
            }else if (su > sum){
                j--;
            }
        }

        return result;
    }

}
