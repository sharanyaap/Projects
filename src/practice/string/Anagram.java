package practice.string;

/**
 * Created by sharanya.p on 6/22/2018.
 */
public class Anagram {
    public static void main(String[] args) {
        //System.out.println(isAnagram("test", "etta"));
        System.out.println(myAnagram("test", "etts"));
    }

    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        int[] temp = new int[Character.MAX_VALUE];
        //sry, too lazy to calculate ASCII idx of a-z rel. i :)

        int summ = 0;

        for (int i = 0; i < a.length(); i++) {
            summ += ++temp[a.charAt(i)] <= 0 ? -1 : 1;
            summ += --temp[b.charAt(i)] >= 0 ? -1 : 1;
        }

        return summ == 0;
    }

    static boolean myAnagram(String a, String b) {
        int[] arr = new int[Character.MAX_VALUE];
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        for (int i = 0; i < ac.length; i++) {
            arr[ac[i]] = arr[ac[i]] + 1;
            arr[bc[i]] = arr[bc[i]] - 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

}
