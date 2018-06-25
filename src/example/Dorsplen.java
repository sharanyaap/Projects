package example;

/**
 * Created by sharanya.p on 7/31/2017.
 */
public class Dorsplen {

    public static void main(String[] args) {
        Dorsplen dorsplen = new Dorsplen();
        int[] in = {4, 5, 8};
        dorsplen.solve(in);
    }

    public int solve(int[] in) {
        int o = in[0];
        for (int i = 1; i < in.length; i++) {
            int x = in[i] - o;
            if (!(i == in.length - 1)) {
                o = o + x;
            } else {
                while (x > 0) {
                    o += 1;
                    x -= 2;
                }
            }
        }
        System.out.println(o);
        return o;
    }

}
