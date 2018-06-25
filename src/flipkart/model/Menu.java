package flipkart.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class Menu {

    List<Item> items = new ArrayList<>();

    public Menu(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
