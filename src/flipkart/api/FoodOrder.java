package flipkart.api;

import flipkart.exception.UserException;
import flipkart.model.Item;
import flipkart.model.Menu;
import flipkart.model.Restaurant;

import java.util.List;
import java.util.Set;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public interface FoodOrder {

    public Set<Restaurant> onBoardRestaurant(String name, int capacity, Menu menu);

    public Restaurant selectRestaurant(List<String> items) throws UserException;

    public Restaurant changeRestaurantMenu(Menu menu, String restName);

    public Restaurant changePriceOfItem(String restName, String itemName, Integer newPrice) throws UserException;

    public void printStats();


}
