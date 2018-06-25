package example;

/**
 * Created by sharanya.p on 8/31/2017.
 */
public class GamingArray {

    public static void main(String[] args) {
        GamingArray gamingArray = new GamingArray();
        int[] ints = {5, 2, 6, 3, 4};
        String ans = "Bob";
        while (gamingArray.solve(ints) == 0) {
            if (ans.equals("Bob")) {
                ans = "Andy";
            } else {
                ans = "Bob";
            }
        }

        System.out.println(ans);

    }

    private int solve(int[] ints) {
        int h = 0;
        int hi = 0;
        for (int i : ints) {
            if (ints[i] > h) {
                h = ints[i];
                hi = i;
            }
        }
        return hi;
    }

}
