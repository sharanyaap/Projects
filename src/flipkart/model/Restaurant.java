package flipkart.model;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class Restaurant {

    private String name;

    private Menu menu;

    private int capacity;

    public Restaurant(String name, Menu menu, int capacity){
        this.menu = menu;
        this.capacity = capacity;
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
