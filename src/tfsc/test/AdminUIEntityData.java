package tfsc.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anshal.shukla on 1/3/2015.
 */
public class AdminUIEntityData {
    private EntityBaseData entityBaseData;
    private HashMap<String,String> entityAttributes;

    public EntityBaseData getEntityBaseData() {
        return entityBaseData;
    }

    public void setEntityBaseData(EntityBaseData entityBaseData) {
        this.entityBaseData = entityBaseData;
    }

    public Map<String, String> getEntityAttributes() {
        return entityAttributes;
    }

    public void setEntityAttributes(HashMap<String, String> entityAttributes) {
        this.entityAttributes = entityAttributes;
    }

    @Override
    public boolean equals(Object data) {
        if(data instanceof AdminUIEntityData) {
            AdminUIEntityData adminData = (AdminUIEntityData)data;
            return adminData.getEntityBaseData().getEntityId().equals(entityBaseData.getEntityId()) ;
        }
        return false;
    }

    @Override
    public int hashCode() {
       return  entityBaseData.getEntityId().hashCode();
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer("");
        buffer.append("[");
        buffer.append("entityBaseData -> "+entityBaseData);
        buffer.append("[entityAttributes-> "+entityAttributes+" ]");
        buffer.append("]");
        return buffer.toString();
    }
}