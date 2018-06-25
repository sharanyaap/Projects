package example;

/**
 * Created by sharanya.p on 1/11/2018.
 */
public class Reco {

    int one = 0, zero = 0;

    public static void main(String[] args) {
        Reco reco = new Reco();
        reco.reco(5);
    }

    private void reco(int n)

    {

        if (n <= 0) zero++;

        if (n == 1) one++;

        else

        {

            reco(n - 1);

            reco(n - 2);

            reco(n - 3);

        }

    }

}
