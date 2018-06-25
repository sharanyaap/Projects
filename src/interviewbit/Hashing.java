package interviewbit;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by sharanya.p on 2/1/2018.
 */
public class Hashing {
    public static void main(String[] args) {
        Hashing hashing = new Hashing();

        List<String> as = new ArrayList<String>();
        as.add("cat");
        as.add("dog");
        as.add("god");
        as.add("atc");
        ArrayList<ArrayList<Integer>> result = hashing.anagrams(as);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            for (int j : result.get(i))
                System.out.print((j) + " ");
            System.out.println("]");
        }

        System.out.println(hashing.fractionToDecimal(2, 3));
        System.out.println(hashing.fractionToDecimal(-2147483648, -1));

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(6);
        a.add(5);
        a.add(-18);
        a.add(2);
        a.add(5);
        a.add(-2);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(-17);
        b.add(-16);
        b.add(-17);
        b.add(-4);
        b.add(-13);
        b.add(20);

        System.out.println(hashing.maxPoints(a, b));

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> sb = new ArrayList<String>();
        sb.add("aaa");
        sb.add("aaa");
        sb.add("aaa");
        sb.add("aaa");
        sb.add("aaa");

        ArrayList<Integer> res = hashing.findSubstring(s, sb);
        for (int i : res)
            System.out.print(i + " ");

        s = "barfoothefoobarman";
        sb = new ArrayList<String>();
        sb.add("foo");
        sb.add("bar");
        System.out.println("");
        res = hashing.findSubstring(s, sb);
        for (int i : res)
            System.out.print(i + " ");

        System.out.println("");
        String st = "abcabcbb";
        System.out.println(hashing.lengthOfLongestSubstring(st));

        st = "bbbbbb";
        System.out.println(hashing.lengthOfLongestSubstring(st));

        st = "dadbc";
        System.out.println(hashing.lengthOfLongestSubstring(st));

        //Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV
        st = "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV";
        System.out.println(hashing.lengthOfLongestSubstring(st));
    }

    public int lengthOfLongestSubstring(String A) {
        int max = 0;
        char[] cs = A.toCharArray();
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; ) {
            if (map.get(cs[i]) == null) {
                map.put(cs[i], i);
                count++;
                i++;
            } else {
                count = 0;
                i = map.get(cs[i]) + 1;
                map.clear();
            }
            if (max < count)
                max = count;
        }
        return max;
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> res = new ArrayList<>();
        List<String> list = null;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //int num = b.size() * b.get(0).length();
        //int strLength = b.get(0).length();
        for (int i = 0; i < b.size(); i++) {
            if (map.containsKey(b.get(i)))
                map.put(b.get(i), map.get(b.get(i)) + 1);
            else
                map.put(b.get(i), 1);
        }
        char[] ac = a.toCharArray();
        for (int i = 0; i < ac.length; i++) {
            int si = i;
            int k = i;
            HashMap<String, Integer> tempMap = (HashMap<String, Integer>) map.clone();
            do {

                boolean found = false;
                for (int j = 0; j < b.size(); j++) {
                    if (tempMap.get(b.get(j)) == 0) {
                        continue;
                    }
                    // System.out.println("i + j * strLength, i + (j + 1) * strLength : " + (i + j * strLength) + " " + (i + (j + 1) * strLength));
                    char[] subc = b.get(j).toCharArray();
                    if (k < ac.length && ac[k] == subc[0] && k + b.get(j).length() <= ac.length) {
                        String substr = a.substring(k, k + b.get(j).length());
                        if (substr.equalsIgnoreCase(b.get(j))) {
                            //System.out.println("Found substr " + substr);
                            Integer val = tempMap.get(substr);
                            tempMap.put(substr, val - 1);
                            //System.out.println("Map with " + substr + " has value " + tempMap.get(substr));
                            k += b.get(j).length();
                            found = true;
                        }
                    }
                }
                list = helperMtd(tempMap);
                if (!found) {
                    k++;
                    break;
                }
            } while (!list.isEmpty() && k < ac.length);
            if (list.isEmpty()) {
                res.add(si);
            }
        }
        return res;
    }

    private List<String> helperMtd(HashMap<String, Integer> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getValue() > 0)
                list.add(en.getKey());
        }
        return list;
    }

    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        int maxPoints = 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        if (a.size() != b.size() || a.size() == 0 || a == null || b.size() == 0 || b == null)
            return maxPoints;
        if (a.size() == 1 && b.size() == 1)
            return 1;
        for (int i = 0; i < a.size(); i++) {
            int duplicate = 1;
            int vertical = 0;
            int xi = a.get(i);
            int yi = b.get(i);
            for (int j = i + 1; j < a.size(); j++) {
                int xj = a.get(j);
                int yj = b.get(j);
                if (xi == xj) {
                    if (yi == yj) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
                    double slope = 0.0;
                    if (yj - yi == 0)
                        slope = 0.0;
                    else if (xj - xi == 0)
                        slope = Double.MAX_VALUE;
                    else
                        slope = (double) (yj - yi) / (double) (xj - xi);

                    //System.out.println("Slope : " + slope);
                    if (map.containsKey(slope))
                        map.put(slope, map.get(slope) + 1);
                    else
                        map.put(slope, 1);
                }
            }
            for (int sl : map.values())
                if (maxPoints < sl + duplicate)
                    maxPoints = sl + duplicate;

            maxPoints = Math.max(vertical + duplicate, maxPoints);
            map.clear();
        }
        return maxPoints;
    }

    public String fractionToDecimal(int A, int B) {
        /*String result = "";
        double res = (double) A / (double) B;
        result += res;
        return result;*/

        if (A == 0)
            return "0";
        if (B == 0)
            return "";
        String result = "";
        if ((A < 0) && (B > 0) || (A > 0) && (B < 0)) {
            result += "-";
        }
        long num = A;
        long den = B;
        num = Math.abs(num);
        den = Math.abs(den);
        long res = num / den;
        result += String.valueOf(res);
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        result += '.';
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            char[] c = A.get(i).toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if (map.get(t) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                map.put(t, list);
            } else {
                map.get(t).add(i + 1);
            }
        }

        for (ArrayList<Integer> l : map.values()) {
            // if(l.size() > 1) {
            result.add(l);
            //}
        }

        return result;
    }

    public int colorful(int a) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        while (a > 0) {
            int remainder = a % 10;
            //System.out.println("remainder : "+ remainder);
            list.add(remainder);
            a = a / 10;
            //System.out.println("a : "+ a);
        }

        int i = 0;
        while (i < list.size()) {
            int j = i + 1;
            //System.out.printf("For i = %d and j = %d \n ", i ,  j);
            if (set.contains(list.get(i)))
                return 0;
            //System.out.println("\t digit = " + list.get(i));
            set.add(list.get(i));
            int result = list.get(i);
            //System.out.println("Result before j loop:" +result);
            while (j < list.size() && i != list.size() - 1) {
                result = result * list.get(j);
                if (set.contains(result))
                    return 0;
                set.add(result);
                j++;
            }
            i++;
        }

        return res;
    }
}
