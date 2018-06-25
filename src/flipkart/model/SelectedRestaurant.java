package flipkart.model;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class SelectedRestaurant {

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    private Restaurant restaurant;

    private Integer totalPrice;



}
