package example;

/**
 * Created by sharanya.p on 1/7/2018.
 */
public class PrintWords {

    public static String[] hashTable = {"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        int[] number = {2, 3, 4};
        printWords(number, number.length);
    }

    private static void printWords(int[] number, int n) {
        char result[] = new char[n];
        printWordsUtil(number, 0, result, n);
    }

    private static void printWordsUtil(int number[], int curr_digit, char output[], int n) {
        if (curr_digit == n) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i < hashTable[number[curr_digit]].length(); i++) {
            output[curr_digit] = hashTable[number[curr_digit]].toCharArray()[i];
            printWordsUtil(number, curr_digit + 1, output, n);
            if (number[curr_digit] == 0 || number[curr_digit] == 1)
                return;
        }
    }

}
