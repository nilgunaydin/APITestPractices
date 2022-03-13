package get_http_request.day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {
 /*
   https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
  {

     "title": "Batch44"

    }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"userId": 10,
"title": "Batch44"
"completed": true,
"id": 198
}
    */

    @Test
    public void test(){
        //1) URL OLUSTUR
        specJson.pathParams("first", "todos", "second", 198);

        //2) EXPECTED DATA
        JsonPlaceHolderTestData testData = new JsonPlaceHolderTestData();
        JSONObject requestData = testData.setUpPatchData();
        System.out.println("requestData = " + requestData);

        JSONObject expectedData = testData.setUpPatchExpectedData();
        System.out.println("expectedData = " + expectedData);

        //3) REQUEST VE RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(specJson)
                .body(requestData.toString())
                .when()
                .patch("/{first}/{second}");

        response.prettyPrint();

        //4) DOGRULAMA
        // 1) JSonPath
        JsonPath json = response.jsonPath();
        assertEquals(expectedData.get("userId"), json.getInt("userId"));
        assertEquals(expectedData.get("title"), json.getString("title"));
        assertEquals(expectedData.get("completed"), json.getBoolean("completed"));
        assertEquals(expectedData.get("id"), json.getInt("id"));

        //Matcher
        response.then().statusCode(200);
        response.then().body("title", equalTo(expectedData.getString("title"))
                ,"completed",equalTo(expectedData.getBoolean("completed"))
                ,"userId",equalTo(expectedData.getInt("userId"))
                ,"id",equalTo(expectedData.getInt("id")));

        // 3) De-Serialization
        HashMap<String, Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("id"), actualData.get("id"));

    }
}
