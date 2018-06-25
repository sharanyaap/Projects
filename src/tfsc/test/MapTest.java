package tfsc.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sharanya.p on 4/6/2018.
 */
public class MapTest {

    private Map<String, Set<Integer>> emailUsersMap= new HashMap<>();

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.test();
        mapTest.test();
    }


    private void test() {
        if (null != emailUsersMap.get("test")) {
            Set<Integer> users = emailUsersMap.get("test");
            users.add(new Integer(3));
            emailUsersMap.put("test", users);
        } else {
            Set<Integer> users = new HashSet<>();
            users.add(new Integer(3));
            emailUsersMap.put("test", users);
        }
    }
}
