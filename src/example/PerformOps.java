package example;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 1/14/2018.
 */
public class PerformOps {

    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(5);
        a2.add(6);
        a2.add(7);
        a2.add(8);
        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(9);
        a3.add(10);
        a3.add(11);
        a3.add(12);
        A.add(a1);
        A.add(a2);
        A.add(a3);
        ArrayList<ArrayList<Integer>> B = performOps(A);
        /*for (int i = 0; i < B.size(); i++) {
            for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
            }
        }*/


        ArrayList<Integer> A2 = new ArrayList<>();
            A2.add(5);
        A2.add(10);
        A2.add(2);
        A2.add(1);
        ArrayList<Integer> B2 = performOps2(A2);
        for (int i = 0; i < B2.size(); i++) {
            System.out.print(B2.get(i) + " ");
        }

    }

    static ArrayList<Integer> performOps2(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }
}
