package interviewbit.dynamicProg;

/**
 * Created by sharanya.p on 2/20/2018.
 */
public class UniqueBinTrees {

    public static void main(String[] args) {
        //args[0] = "3";
        int a = Integer.parseInt("3");
        System.out.println(numTrees(a));
    }

    public static int numTrees(int a) {
        if (a < 0)
            return 0;
        int[] count = new int[a + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= a; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.println("j is " + j + " and count[j] is " + count[j]);
                System.out.println("i is " + i + " ,j is " + j + " ,(i - j - 1) is " + (i - j - 1) + " and count[i - j - 1] is " + count[i - j - 1]);
                count[i] += count[j] * count[i - j - 1];
            }

        }
        return count[a];
    }
}
