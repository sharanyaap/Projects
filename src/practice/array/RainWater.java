package practice.array;

/**
 * Created by sharanya.p on 10/23/2018.
 */
public class RainWater {

    public static void main(String[] args) {
        int[] in = {3,0,0,2,0,4};
        RainWater rainWater = new RainWater();
        System.out.println(rainWater.solve(in));
    }

    int solve(int[] in){
        int[] left = new int[in.length];
        int[] right = new int[in.length];
        left[0] = in[0];
        for (int i =1; i<in.length;i++){
            if (left[i-1] > in[i]){
                left[i] = left[i-1];
            }else {
                left[i] = in[i];
            }
        }
        right[in.length-1] = in[in.length-1];
        for (int i =in.length -2; i>=0;i--){
            if (right[i+1] > in[i]){
                right[i] = right[i+1];
            }else {
                right[i] = in[i];
            }
        }
        int res = 0;
        for (int i =0 ;i<in.length-1;i++){
            res += (Math.min(left[i], right[i]) - in[i]);
        }
        return res;

    }



}
