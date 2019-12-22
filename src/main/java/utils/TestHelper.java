package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;

public class TestHelper {

    public  static String getJsonString(Object o){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return  objectMapper.writeValueAsString(o);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
    public static JsonPath getJsonString(Response response) {
        String responseString = response.asString();
        JsonPath jsonPath = new JsonPath(responseString);
        return  jsonPath;
    }
}
