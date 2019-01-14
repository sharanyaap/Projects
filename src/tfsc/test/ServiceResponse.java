package tfsc.test;

import java.util.Map;

/**
 * Created by anshal.shukla on 2/8/2015.
 */
public class ServiceResponse {
    private String status;
    private String errorMessage;
    private String errorDescription;
    private Map<String,String> data;

    public static final String ENTITY_ID_KEY = "entityId";
    public static final String ENTITY_LIST_KEY = "list";
    public static final String ENTITY_KEY = "entity";


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
