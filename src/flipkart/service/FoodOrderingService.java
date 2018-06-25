package flipkart.service;

import flipkart.api.FoodOrder;
import flipkart.exception.UserException;
import flipkart.model.*;

import javax.jws.soap.SOAPBinding;
import java.util.*;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class FoodOrderingService implements FoodOrder {

    Set<Restaurant> restaurants = new HashSet<>();

    List<ProcessedRequest> requests = new ArrayList<>();

    @Override
    public Set<Restaurant> onBoardRestaurant(String name, int capacity, Menu menu) {
        Restaurant restaurant = new Restaurant(name, menu, capacity);
        restaurants.add(restaurant);
        return restaurants;
    }

    public Restaurant selectRestaurant(List<String> items) throws UserException {
        Restaurant restaurant = null;
        List<SelectedRestaurant> selectedRestaurants = new ArrayList<>();
        for (Restaurant restaurant1 : restaurants) {
            SelectedRestaurant selectedRestaurant = findRestaurantForItems(items, restaurant1);
            if (selectedRestaurant != null)
                selectedRestaurants.add(selectedRestaurant);
        }
        if (selectedRestaurants.isEmpty()) {
            throw new UserException("None of restaurants have the selected items");
        }
        Integer minPrice = 9999999;
        for (SelectedRestaurant selectedRestaurant : selectedRestaurants) {
            if (selectedRestaurant.getTotalPrice() < minPrice) {
                minPrice = selectedRestaurant.getTotalPrice();
                restaurant = selectedRestaurant.getRestaurant();
            }
        }
        ProcessedRequest processedRequest = new ProcessedRequest(restaurant.getName(), items);
        requests.add(processedRequest);
        return restaurant;
    }

    public SelectedRestaurant findRestaurantForItems(List<String> items, Restaurant restaurant) throws UserException {
        SelectedRestaurant selectedRestaurant = null;
        Integer totalPrice = 0;

        if (items.size() > restaurant.getCapacity()) {
            // System.out.println("Items exceeded capacity");
            throw new UserException("Items exceeded capacity");
        }

        for (String itemName : items) {
            boolean findCurrentItem = false;
            for (Item item1 : restaurant.getMenu().getItems()) {
                if (item1.getItemName().equals(itemName)) {
                    findCurrentItem = true;
                    totalPrice += item1.getPrice();
                    break;
                }
            }
            if (!findCurrentItem) {
                // System.out.println("Current rest does not contain all the items selected by User");
                return null;
            }
        }
        selectedRestaurant = new SelectedRestaurant();
        selectedRestaurant.setRestaurant(restaurant);
        selectedRestaurant.setTotalPrice(totalPrice);
        return selectedRestaurant;
    }

    public Restaurant changeRestaurantMenu(Menu menu, String restName) {
        Restaurant updateRestaurant = null;
        for (Restaurant restaurant :
                restaurants) {
            if (restaurant.getName().equals(restName)) {
                updateRestaurant = restaurant;
            }
        }
        updateRestaurant.setMenu(menu);
        return updateRestaurant;
    }

    public Restaurant changePriceOfItem(String restName, String itemName, Integer newPrice) throws UserException {
        Restaurant restaurant = null;
        for (Restaurant restaurant1 : restaurants) {
            if (restaurant1.getName().equalsIgnoreCase(restName)) {
                restaurant = restaurant1;
            }
        }
        if (restaurant == null)
            throw new UserException("Could not find matching restaurant");
        Item updateItem = null;
        for (Item item : restaurant.getMenu().getItems()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                updateItem = item;
                updateItem.setPrice(newPrice);
            }
        }
        if (updateItem == null) {
            throw new UserException("Could not find matching Item");
        }
        return restaurant;
    }

    public void printStats() {
        for (ProcessedRequest processedRequest : requests) {
            System.out.println("Prepared and dispatched :: " + processedRequest.getRestuarantName() + " for items :: " + processedRequest.getItems().toString());
        }
    }
}
