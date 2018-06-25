package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by sharanya.p on 1/30/2018.
 */
public class BackTracking {

    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<ArrayList<Integer>> result = backTracking.subsets(a);
        for (ArrayList<Integer> list : result)
            System.out.println(list);

        backTracking.letterCombinations("1");

        a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        //a.add(4);
        result = backTracking.permute(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        System.out.println(backTracking.grayCode(3));
    }

    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCode(n - 1);
        int numToAdd = 1 << (n - 1);

        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(numToAdd + result.get(i));
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < a.size(); i++) {
            //System.out.println("For i : " + i);
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    //System.out.println("For J : " +  j);
                    //System.out.println("list is: " + l);

                    l.add(j, a.get(i));
                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);
                    //System.out.println("\t current: " );
                    //for(int k = 0; k< current.size(); k++)
                    //System.out.println("\t \t" + current.get(k));

                    //System.out.println("\t Temp: " + temp);

                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

    static HashMap<Integer, String> map = new HashMap() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
        put(0, "0");
        put(1, "1");
    }};

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<String>();
        getString(A, new ArrayList<Character>(), result, map);
        return result;
    }

    public void getString(String digits, ArrayList<Character> temp, ArrayList<String> result, HashMap<Integer, String> map) {
        if (digits.length() == 0) {
            char[] arr = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            result.add(String.valueOf(arr));
            return;
        }

        Integer curr = Integer.valueOf(digits.substring(0, 1));
        String letters = map.get(curr);
        for (int i = 0; i < letters.length(); i++) {
            temp.add(letters.charAt(i));
            getString(digits.substring(1), temp, result, map);
            temp.remove(temp.size() - 1);
        }
    }


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        if (a.isEmpty())
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> list : result) {
                temp.add(new ArrayList<Integer>(list));
            }

            for (ArrayList<Integer> list : temp) {
                list.add(a.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(a.get(i));
            temp.add(single);


            result.addAll(temp);
        }
        result.add(0, new ArrayList<Integer>());
        //Collections.sort(result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        return result;
    }


}
