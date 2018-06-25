package interviewbit;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sharanya.p on 2/13/2018.
 */
public class TrieProb {

    static final int MAX = 256;

    // Maximum length of an input word
    static final int MAX_WORD_LEN = 500;

    // Trie Node.
    static class TrieNode {
        TrieNode[] child = new TrieNode[MAX];
        int freq;  // To store frequency

        TrieNode() {
            freq = 1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }

    static TrieNode root;

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        int n = arr.length;
        findPrefixes(arr, n);


        prefixEfficient(Arrays.asList(arr));
    }

    // Method to insert a new string into Trie
    static void insert(String str) {
        // Length of the URL
        int len = str.length();
        TrieNode pCrawl = root;

        // Traversing over the length of given str.
        for (int level = 0; level < len; level++) {
            // Get index of child node from current character
            // in str.
            int index = str.charAt(level);

            // Create a new child if not exist already
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;

            // Move to the child
            pCrawl = pCrawl.child[index];
        }
    }

    // This function prints unique prefix for every word stored
    // in Trie. Prefixes one by one are stored in prefix[].
    // 'ind' is current index of prefix[]
    static void findPrefixesUtil(TrieNode root, char[] prefix,
                                 int ind) {
        // Corner case
        if (root == null)
            return;

        // Base case
        if (root.freq == 1) {
            prefix[ind] = '\0';
            int i = 0;
            while (prefix[i] != '\0')
                System.out.print(prefix[i++]);
            System.out.print("  ");
            return;
        }

        for (int i = 0; i < MAX; i++) {
            if (root.child[i] != null) {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind + 1);
            }
        }
    }

    // Function to print all prefixes that uniquely
    // represent all words in arr[0..n-1]
    static void findPrefixes(String arr[], int n) {
        // Construct a Trie of all words
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i < n; i++)
            insert(arr[i]);

        // Create an array to store all prefixes
        char[] prefix = new char[MAX_WORD_LEN];

        // Print all prefixes using Trie Traversal
        findPrefixesUtil(root, prefix, 0);
    }

    public static ArrayList<String> prefixEfficient(List<String> a) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, String> validSubs = new HashMap<String, String>();
        HashSet<String> usedSubs = new HashSet<String>();

        for (String option : a) {
            for (int i = 0; i <= option.length(); i++) {
                String sub = option.substring(0, i);
                if (usedSubs.contains(sub)) {
                    validSubs.remove(sub);
                } else {
                    validSubs.put(sub, option);
                    usedSubs.add(sub);
                }
            }
        }

        SortedSet<String> keys = new TreeSet<>(validSubs.keySet());
        Iterator ite = keys.iterator();
        String prev = "";
        while (ite.hasNext()) {
            String str = (String) ite.next();
            String value = validSubs.get(str);
            if (value.equals(prev)) {
                validSubs.remove(str);
            }
            prev = value;
        }
        for (String st :
                a) {
            if (validSubs.containsValue(st)) {
                result.add(getKeyByValue(validSubs, st));
            }
        }

        return result;
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}


