package interviewbit;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by sharanya.p on 1/18/2018.
 */
public class StringProb {

    public static void main(String[] args) {
        StringProb stringProb = new StringProb();
        stringProb.countAndSay(6);
        stringProb.reverseWords("blue is sky the");
        stringProb.reverseWords("");

        /*System.out.println(stringProb.longestPalindrome("cacaccbabcabbbaacbbbbcaaaccaacbabcaccbccaacccaacbbaaabbbabcaaabc").toString());
        // System.out.println(stringProb.longestPalindromeSolution("cacaccbabcabbbaacbbbbcaaaccaacbabcaccbccaacccaacbbaaabbbabcaaabc").toString());
        System.out.println(stringProb.longestPalindrome("aaaabaaa").toString());
        System.out.println(stringProb.longestPalindrome("abbcccbbbcaaccbababcbcabca").toString());

        System.out.println(stringProb.romanToInt("XX"));

        String str = "banana";
        System.out.println(
                findMinInsertionsDP(str));

        System.out.println(stringProb.solve("banana"));*/

        String s = "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
        //{\"bar\":[\"baz\",null,1.0,2]}]";
        ArrayList<String> result = stringProb.prettyJSON(s);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));

        s = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        result = stringProb.prettyJSON(s);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));

        s = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        result = stringProb.prettyJSON(s);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    public ArrayList<String> prettyJSON(String A) {

        //System.out.println("Entering function");
        ArrayList<String> result = new ArrayList<String>();
        char[] arr = A.toCharArray();
        int indentation = 0;
        StringBuilder tempStr = new StringBuilder();
        boolean notindent = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ')
                continue;
            if (arr[i] == '[' || arr[i] == '{') {
                if (tempStr.length() > 0) {
                    result.add(buildString(tempStr, indentation));
                    tempStr = new StringBuilder();
                    if (!notindent) {
                        indentation++;
                        notindent = false;
                    }
                }
                result.add(buildString(arr[i], indentation));
                indentation++;
            } else if (arr[i] == ']' || arr[i] == '}') {
                if (tempStr.length() > 0) {
                    result.add(buildString(tempStr, indentation));
                    //tempStr = new StringBuilder();
                    //indentation--;
                }
                if (i + 1 < A.length() && arr[i + 1] == ',') {
                    indentation--;
                    tempStr = new StringBuilder(String.valueOf(arr[i])).append(",");
                    i++;
                    result.add(buildString(tempStr, indentation));
                } else {
                    indentation--;
                    result.add(buildString(arr[i], indentation));
                }
                tempStr = new StringBuilder();
                //indentation--;
            } else if (arr[i] == ',') {
                if (tempStr.length() > 0) {
                    result.add(buildString(tempStr.append(arr[i]), indentation));
                    tempStr = new StringBuilder();
                } else {
                    result.add(buildString(arr[i], indentation));
                }
            } else {
                // System.out.print(arr[i]);
                tempStr.append(arr[i]);
                if (arr[i] == ':' && (arr[i + 1] == '{' || arr[i + 1] == '[')) {
                    notindent = true;
                }
            }
        }
        return result;

    }

    private String buildString(char c, int indentation) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < indentation) {
            stringBuilder.append("\t");
            i++;
        }
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    private String buildString(StringBuilder str, int indentation) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < indentation) {
            stringBuilder.append("\t");
            i++;
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    Vector<Integer> computeLPSArray(String str) {
        int M = str.length();
        Vector<Integer> lps = new Vector<>(M);
        int len = 0;
        lps.add(0, 0); // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < M) {
            if (str.toCharArray()[i] == str.toCharArray()[len]) {
                len++;
                lps.add(i, len);
                i++;
            } else // (str[i] != str[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps.get(len - 1);

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps.add(i, 0);
                    i++;
                }
            }
        }
        return lps;
    }


    public int solve(String A) {
        StringBuilder revStr = new StringBuilder(A);
        revStr = revStr.reverse();

        // Get concatenation of string, special character
        // and reverse string
        String concat = A + "$" + revStr;

        //  Get LPS array of this concatenated string
        Vector<Integer> lps = computeLPSArray(concat);

        // By subtracting last entry of lps vector from
        // string length, we will get our result
        return (A.length() - lps.lastElement());
    }

    static int findMinInsertionsDP(String A) {
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        char arr[] = A.toCharArray();
        int n = A.length();
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (arr[l] == arr[h]) ?
                        table[l + 1][h - 1] :
                        (Integer.min(table[l][h - 1],
                                table[l + 1][h]) + 1);

        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n - 1];
    }


    private int c2n(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    public int romanToInt(String A) {
        int res = 0;
        char[] arr = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            char c = arr[i];
            // Getting value of symbol s[i]
            int s1 = c2n(c);
            if (i + 1 < A.length()) {
                int s2 = c2n(arr[i + 1]);
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }

    //From Solution
    public String longestPalindromeSolution(String A) {
        int n = A.length();
        if (n <= 1)
            return A;
        int start = 0;
        int maxLen = 0;
        int j;
        int k;
        for (int i = 1; i < n; i++) {
            j = i - 1;
            k = i + 1;
            while (k < n && A.charAt(k) == A.charAt(i))
                k++;
            while (j >= 0 && A.charAt(j) == A.charAt(i))
                j--;
            while (j >= 0 && k < n && A.charAt(j) == A.charAt(k)) {
                j--;
                k++;
            }
            if (k - j - 1 > maxLen) {
                maxLen = k - j - 1;
                start = j + 1;
            }
        }
        if (maxLen == 1)
            return A.substring(0, 1);
        return A.substring(start, start + maxLen);
    }

    public String longestPalindrome(String A) {
        if (A == null || A.length() == 0) {
            return null;
        }
        int l = 0;
        int h = 0;
        int low = 0;
        int high = A.length() - 1;
        char[] arr = A.toCharArray();
        int i = 0;

        int max = 0;
        int start = 0;
        while (i < high) {
            boolean found = false;
            if (arr[i] == arr[i + 1]) {
                l = i;
                h = i + 1;
            }
            while (l >= low && h <= high && arr[l] == arr[h]) {
                l--;
                h++;
                found = true;
            }
            if (found && ((h - 1) - (l + 1)) > max) {
                start = l + 1;
                max = (h - 1) - (l + 1);
                // System.out.println(A.substring(start, start + max + 1));
            }

            if (i > 0 && arr[i - 1] == arr[i + 1]) {
                l = i - 1;
                h = i + 1;
            }
            while (l >= low && h <= high && arr[l] == arr[h]) {
                l--;
                h++;
                found = true;
            }
            if (found && ((h - 1) - (l + 1)) > max) {
                start = l + 1;
                max = (h - 1) - (l + 1);
                // System.out.println(A.substring(start, start + max + 1));
            }

            i++;
        }

        return A.substring(start, start + max + 1);

    }

    public String reverseWords(String a) {
        if (a == null || a.length() == 0)
            return "";
        String[] reverse = a.split(" ");
        StringBuilder str = new StringBuilder();
        for (int i = reverse.length - 1; i >= 0; i--) {
            str.append(reverse[i]).append(" ");
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));
        return str.toString();

    }

    public String countAndSay(int A) {
        if (A == 0)
            return null;
        String result = "1";

        int i = 1;

        while (i < A) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1))
                    count++;
                else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }

            }
            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
            //System.out.println(result);
        }
        System.out.println(result);
        return result;
    }


    public static ArrayList<String> prettyOldJSON(String a) {
        System.out.println("Entering function");
        ArrayList<String> result = new ArrayList<String>();
        int indentation = 0;
        String temp = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            System.out.println("c : " + c);
            if (c == ' ')
                continue;
            else if (c == '[' || c == '{') {
                temp += c;
                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
                indentation++;
                System.out.println("indentation : " + indentation);
            } else if (c == ']' || c == '}') {
                if (i < a.length() - 1 && a.charAt(i + 1) == ',') {
                    temp += c;
                    temp += a.charAt(++i);
                    indentation--;
                    System.out.println("indentation : " + indentation);
                    for (int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = "";
                } else {
                    temp += c;
                    indentation--;
                    System.out.println("indentation : " + indentation);
                    for (int j = indentation; j > 0; j--)
                        temp = "\t" + temp;
                    System.out.println("temp : " + temp);
                    result.add(temp);
                    temp = "";
                }
            } else if (c == ':' && (a.charAt(i + 1) == '{' || a.charAt(i + 1) == '[')) {
                temp = temp + c;
                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            } else if (c == ':' && (a.charAt(i + 1) != '{' || a.charAt(i + 1) != '['))
                temp = temp + c;

            else if (c == ',' || c == ':' || a.charAt(i + 1) == '}' || a.charAt(i + 1) == ']' || a.charAt(i + 1) == '{' || a.charAt(i + 1) == '[') {
                temp = temp + c;
                System.out.println("indentation : " + indentation);
                for (int j = indentation; j > 0; j--)
                    temp = "\t" + temp;
                System.out.println("temp : " + temp);
                result.add(temp);
                temp = "";
            } else {
                temp = temp + c;
            }
        }
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
        return result;
    }

}
