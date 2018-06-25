package example;

/**
 * Created by sharanya.p on 10/21/2017.
 */
public class TowerofHanoi {

    public static void main(String[] args){
        TowerofHanoi towerofHanoi = new TowerofHanoi();
        towerofHanoi.toh(4, 'A','C','B');

    }

    private void toh(int n, char start, char end, char auxillary){
        if (n == 1) {
            System.out.println("Moving rod 1 from " + start + " to " + end);
            return;
        }
        toh(n-1, start, auxillary, end);
        System.out.println("Moving rod "+ n + " from " + start + " to " + end);
        toh(n-1, auxillary, end, start);

    }
}
