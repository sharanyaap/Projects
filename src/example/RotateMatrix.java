package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sharanya.p on 1/15/2018.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix matrix = new RotateMatrix();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
        list.add(integers);
        integers = new ArrayList() {{
            add(4);
            add(5);
            add(6);
        }};
        list.add(integers);
        integers = new ArrayList() {{
            add(7);
            add(8);
            add(9);
        }};
        list.add(integers);
        matrix.rotate(list);
        System.out.println(list.toArray());
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = a.get(x).get(y);
                System.out.println(temp);
                a.get(x).set(y, a.get(N - y - 1).get(x));
                System.out.println(a.get(N - y - 1).get(x));
                a.get(N - y - 1).set(x, a.get(N - x - 1).get(N - y - 1));
                System.out.println(a.get(N - x - 1).get(N - y - 1));
                a.get(N - x - 1).set(N - y - 1, a.get(y).get(N - x - 1));
                System.out.println(a.get(y).get(N - x - 1));
                a.get(y).set(N - x - 1, temp);
            }
        }


    }

}
