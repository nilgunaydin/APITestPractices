package get_http_request.Day11;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PostRequest03 extends JsonPlaceHolderBaseUrl {
    /*
   https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
    {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false
  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
  {
    "userId": 55,
    "title": "Tidy your room",
    "completed": false,
    "id": …
   }
*/
@Test
public void test26(){
    specJson.pathParams("1","todos");
    JsonPlaceHolderTestData object = new JsonPlaceHolderTestData();
    JSONObject postData = object.data();
    System.out.println("postData = " + postData);

    Response rs = given().spec(specJson).contentType(ContentType.JSON).body(postData.toString()).when().post("/{1}");

rs.prettyPrint();
rs.then().assertThat().statusCode(postData.getInt("statusCode")).and()
        .body("userId",equalTo(postData.get("userId")),
        "title",equalTo(postData.get("title")),
        "completed",equalTo(postData.get("completed")),
        "id",equalTo(postData.get("id")));

    JsonPath json = rs.jsonPath();
    assertEquals(postData.getInt("userId"),json.getInt("userId"));
    assertEquals(postData.getString("title"),json.getString("title"));
    assertEquals(postData.getBoolean("completed"),json.getBoolean("completed"));
    assertEquals(postData.getInt("id"),json.getInt("id"));
    assertEquals(postData.getInt("statusCode"),rs.statusCode());


}
}
