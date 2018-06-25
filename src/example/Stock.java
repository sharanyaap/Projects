package example;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 1/11/2018.
 */
public class Stock {

    public static void main(String args[]) {
        Stock stock = new Stock();

        // stock prices on consecutive days
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        // fucntion call
        stock.stockBuySell(price, n);
    }

    private void stockBuySell(int price[], int n) {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;

        // solution array
        ArrayList<StockInterval> sol = new ArrayList<StockInterval>();

        // Traverse through given price array
        int i = 0;

        while (i < n - 1) {
            while (i < n - 1 && price[i + 1] <= price[i]) {
                i++;
            }
            if (i == n - 1)
                break;
            StockInterval e = new StockInterval();
            e.buy = i++;
            // Store the index of minima
            while (i < n && price[i] >= price[i - 1]) {
                i++;
            }
            e.sell = i - 1;
            sol.add(e);
            count++;
        }
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        +"        " + "Sell on day : " + sol.get(j).sell);

        return;
    }
}

// Solution structure
class StockInterval {
    int buy, sell;
}