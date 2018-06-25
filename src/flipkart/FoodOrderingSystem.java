package flipkart;

import flipkart.api.FoodOrder;
import flipkart.exception.UserException;
import flipkart.model.Item;
import flipkart.model.Menu;
import flipkart.model.Restaurant;
import flipkart.service.FoodOrderingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class FoodOrderingSystem {

    public static void main(String[] args) {
        FoodOrder foodOrder = new FoodOrderingService();
        // Onboard Rest1
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("item1", 200, 30l);
        Item item2 = new Item("item2", 601, 25l);
        Item item3 = new Item("item3", 500, 15l);
        Item item4 = new Item("item4", 800, 5l);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        Menu menu = new Menu(items);
        foodOrder.onBoardRestaurant("rest1", 2, menu);

        // Onboard Rest2
        items = new ArrayList<>();
        item1 = new Item("item1", 200, 30l);
        item2 = new Item("item2", 600, 25l);
        item3 = new Item("item5", 500, 15l);
        item4 = new Item("item6", 800, 5l);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        menu = new Menu(items);
        foodOrder.onBoardRestaurant("rest2", 2, menu);

        // Onboard Rest3
        items = new ArrayList<>();
        item1 = new Item("item7", 1200, 30l);
        item2 = new Item("item8", 130, 25l);
        item3 = new Item("item9", 80, 15l);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        menu = new Menu(items);
        foodOrder.onBoardRestaurant("rest3", 3, menu);

        // Test 1, same items select lowest price Restaurant
        String[] arr = new String[]{"item1", "item2"};
        List<String> customerItems = Arrays.asList(arr);
        try {
            System.out.println(foodOrder.selectRestaurant(customerItems).getName());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }


        // Test 2, select 3 items
        arr = new String[]{"item7", "item8"};
        customerItems = Arrays.asList(arr);
        try {
            System.out.println(foodOrder.selectRestaurant(customerItems).getName());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }

        // Test 3, update price of Resaurant Item
        try {
            foodOrder.changePriceOfItem("rest1", "item2", 234);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }


        // Test 4, select 20 items
        arr = new String[]{"item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8"};
        customerItems = Arrays.asList(arr);
        try {
            System.out.println(foodOrder.selectRestaurant(customerItems).getName());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }


        // Print stats so far
        foodOrder.printStats();

    }

}
