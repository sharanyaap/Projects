package tfsc.test;

import org.json.JSONObject;

/**
 * Created by sharanya.p on 6/27/2018.
 */
public class JSONTest {
    public static void main(String[] args) {
        JSONObject jso = new JSONObject("{\"data\":null,\"status\":\"failure\",\"message\":\"EXCEPTION_CODE_USER_ALREADY_EXISTS\",\"code\":\"EXCEPTION_CODE_USER_ALREADY_EXISTS\"}");
        String status = jso.get("status").toString();

        String data = jso.get("data").toString();

        jso = new JSONObject(data);
    }


}
