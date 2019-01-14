package tfsc.test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


/**
 * Created by p.divya on 12/5/2014.
 */
public class JsonUtils {
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static <T> T convertFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException,
            IOException {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        if (clazz != null)
            return OBJECT_MAPPER.readValue(json, clazz);
        return null;
    }

    public static <T> List<T> convertFromJsonToList(String json, Class<T> clazz) throws JsonParseException,
            JsonMappingException, IOException {
        if (clazz != null) {
            //OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            JavaType type = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, clazz);
            return OBJECT_MAPPER.readValue(json, type);
        }
        return null;
    }

    public static String convertToJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        String json = null;
        json = OBJECT_MAPPER.writeValueAsString(obj);
        return json;
    }

}
