package example;

/**
 * Created by sharanya.p on 7/27/2017.
 */
public class WiggleProblem {

    private int[] nums = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        WiggleProblem problem = new WiggleProblem();
        problem.solve();
    }

    public int solve() {
        int[] output= new int[nums.length];
        int i = 1, j = 0;
        int sum = 0;
        int prevSum = nums[0] - nums[1];
        boolean pos = prevSum > 0 ? true : false;
        System.out.println(nums[0]);
        j++;
        while (i <= nums.length - 2) {
            sum = nums[i] - nums[i + 1];
            if (pos && sum < 0) {
                output[j++] = nums[i];
                pos = false;
                System.out.println(nums[i]);
            } else if (!pos && sum > 0) {
                output[j++] = nums[i];
                pos = true;
                System.out.println(nums[i]);
            }
            i++;
        }
        System.out.println(nums[nums.length-1]);
        j++;
        System.out.println("Output :: " + j++);
        return j;
    }

}
