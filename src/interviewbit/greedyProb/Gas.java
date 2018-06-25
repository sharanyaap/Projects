package interviewbit.greedyProb;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 2/28/2018.
 */
public class Gas {

    public static int canCompleteCircuit(ArrayList<Integer> gas, ArrayList<Integer> cost) {
        if (gas.isEmpty() || cost.isEmpty() || gas.size() != cost.size()) {
            return -1;
        }
        int sumRemaining = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.size(); i++) {
            int remaining = gas.get(i) - cost.get(i);
            if (sumRemaining >= 0)
                sumRemaining += remaining;
            else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }
        if (total >= 0)
            return start;
        else return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> gas = new ArrayList<Integer>();
        gas.add(1);
        gas.add(2);
        gas.add(3);
        gas.add(4);
        gas.add(5);
        ArrayList<Integer> cost = new ArrayList<Integer>();
        cost.add(1);
        cost.add(3);
        cost.add(2);
        cost.add(4);
        cost.add(5);
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
