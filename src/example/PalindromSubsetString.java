package example;

/**
 * Created by sharanya.p on 7/27/2017.
 */
public class PalindromSubsetString {

    public static void main(String[] args) {
        PalindromSubsetString subsetString = new PalindromSubsetString();
        subsetString.palidromSubset("abaaabb");
    }

    public void palidromSubset(String str) {
        char[] ch = str.toCharArray();
        int i = 0;
        int output = 0;
        while (i < ch.length) {
            if (i == 0) {
                output += ch.length;
            } else if (i == 1) {
                output += ch.length - 1;
            }else {
                for (int j = i + 1; j < ch.length; j++) {
                    //check palindrom and increase count
                }
            }
            i++;
        }
    }

}
