package flipkart.model;

import java.util.List;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class ProcessedRequest {

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    String restuarantName;

    List<String> items;

    public ProcessedRequest(String restuarantName, List<String> items) {
        this.restuarantName = restuarantName;
        this.items = items;
    }

}
