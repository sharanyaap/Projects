package example;

/**
 * Created by sharanya.p on 8/1/2017.
 */
public class KeysKeyboard {
    public static void main(String[] args) {
        KeysKeyboard keyboard = new KeysKeyboard();
        System.out.println(keyboard.solve(10));
    }

    public int solve(int input) {
        int output = 0;
        int j = input / 2;
        if (input <= j) {
            output = input;
        } else {
            output = j;
            input = input - j;
            int prev = 1;
            while (input > 0) {
                if (input > (j - 1)) {
                    input -= 3;
                    prev = output;
                    output += output;
                } else {
                    input -= 1;
                    output += prev;
                }
                System.out.println("input :: " + input);
                System.out.println("output :: " + output);
            }
        }
        return output;
    }
}
