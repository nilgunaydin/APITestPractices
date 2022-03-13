package get_http_request.day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequestPojo01 extends JsonPlaceHolderBaseUrl {
       /*
   https://jsonplaceholder.typicode.com/todos url 'ine bir request gönderildiğinde
Request body{
"userId": 21,
"id": 201,
"title": "Tidy your room",
"completed": false
}
Status kodun 201, response body 'nin ise

{
"userId": 21,
"id": 201,
"title": "Tidy your room",
"completed": false
}
*/
@Test
public void test(){
    specJson.pathParams("1","todos");

JsonPlaceHolderPojo requestExpected = new JsonPlaceHolderPojo(21,201,"Tidy your room",false);

    System.out.println(requestExpected);


    Response response = given().spec(specJson).when().body(requestExpected).post("/{1}");

//dogrulama
    //DE-serialization
    JsonPlaceHolderPojo requestActual = response.as(JsonPlaceHolderPojo.class);
    assertEquals(201, response.getStatusCode());
    assertEquals(requestExpected.getId(),requestActual.getId());
    assertEquals(requestExpected.getUserId(), requestActual.getUserId());
    assertEquals(requestExpected.getTitle(), requestActual.getTitle());
    assertEquals(requestExpected.isCompleted(), requestActual.isCompleted());
}
}
