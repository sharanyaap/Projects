package example;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sharanya.p on 1/12/2018.
 */
public class Merge2LinkedList {

    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        a.add(5);
        a.add(10);
        a.add(15);
        b.add(2);
        b.add(3);
        b.add(20);
        Merge2LinkedList linkedList = new Merge2LinkedList();
        linkedList.solve(a,b);

    }

    List<Integer> solve(List<Integer> a, List<Integer> b) {
        List<Integer> temp = new LinkedList<>();
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        int i = 0, j = 0;
        while (i < a.size() && j <b.size() ) {
            if (a.get(i) < b.get(j)) {
                temp.add(a.get(i));
                i++;
            }
            if (a.get(i) > b.get(j)) {
                temp.add(b.get(j));
                j++;
            }
        }
        return temp;
    }

}
