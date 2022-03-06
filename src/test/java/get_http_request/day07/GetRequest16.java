package get_http_request.day07;


import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequest16  extends JsonPlaceHolderBaseUrl {

  /*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */
@Test
    public void test16(){
    specJson.pathParams("first","todos","sec",7);

//expected data olustur
    Map<String, Object> expectedData = new HashMap<>();
    expectedData.put("userId", 1);
    expectedData.put("id", 7);
    expectedData.put("title", "illo expedita consequatur quia in");
    expectedData.put("completed", false);

    System.out.println("EXPECTED DATA: " + expectedData);

Response rs = given().spec(specJson).when().get("/{first}/{sec}");

//rs.prettyPrint();

    //DATAYI JSON FORMATI -> JAVA'YA: De-Serialization
    //DATAYI JAVA'DAN -> JSON'A: Serialization

    Map<String, Object> actualData = rs.as(HashMap.class);    //De-Serialization YAPTIK

    System.out.println("ACTUAL DATA: "+ actualData);
    assertEquals(expectedData,actualData);

}
}
