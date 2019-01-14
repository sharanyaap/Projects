package tfsc.test;

/**
 * Created by anshal.shukla on 1/3/2015.
 */
public class EntityBaseData {
    private String entityDisplayName;
    private String entityId;
    private String accountId;
    private String clientId;
    private String entityType;

    public String getEntityDisplayName() {
        return entityDisplayName;
    }

    public void setEntityDisplayName(String entityDisplayName) {
        this.entityDisplayName = entityDisplayName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer("");
        buffer.append("[");
        buffer.append("entityDisplayName -> "+entityDisplayName);
        buffer.append(" entityId -> "+entityId);
        buffer.append(" accountId -> "+accountId);
        buffer.append(" clientId -> "+clientId);
        buffer.append(" entityType -> "+entityType);
        buffer.append("]");
        return buffer.toString();
    }
}
