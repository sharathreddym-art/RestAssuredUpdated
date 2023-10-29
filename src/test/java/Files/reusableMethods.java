package Files;

import io.restassured.path.json.JsonPath;

public class reusableMethods {
    public static JsonPath  rawToJson(String response)
    {
        JsonPath jsonPath= new JsonPath(response);
        return jsonPath;
    }
}
