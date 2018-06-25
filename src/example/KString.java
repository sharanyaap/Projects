package example;

/**
 * Created by sharanya.p on 10/21/2017.
 */
public class KString {

    private int[] A = new int[4];

    public static void main(String[] args) {
        KString kString = new KString();
        kString.kstring(4,4);
    }

    private void kstring(int n, int k){
        if (n < 1){
            System.out.println(A[0] + " " + A[1] + " " + A[2] + " " + A[3]);
        }else{
            for (int j = 0; j < k ; j ++){
                A[n-1] = j;
                kstring(n-1, k);
            }
        }
    }

}
