package flipkart.model;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class Item {

    private String itemName;

    private Integer price;

    private Long timeInMinutes;

    public Item(String itemName, Integer price, Long timeInMinutes){
        this.itemName = itemName;
        this.price = price;
        this.timeInMinutes = timeInMinutes;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(Long timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

}
