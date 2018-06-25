package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sharanya.p on 5/2/2018.
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        Integer arr[] = {4, 6, 7, 1, 2, 8};
        List<Integer> res = insertionSort.sort(Arrays.asList(arr));
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    public List<Integer> sort(List<Integer> list) {
        for (int i = 1; i < list.size(); ++i) {
            int tmp = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > tmp) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, tmp);
        }
        return list;
    }
}
