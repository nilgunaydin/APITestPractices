package get_http_request.day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PutRequest01 extends JsonPlaceHolderBaseUrl {
    /*
https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde

{
"userId": 21,
"title": "Wash the dishes",
"completed": false
}
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"userId": 21,
"title": "Wash the dishes",
"completed": false,
"id": 198
}
*/
@Test
    public void test(){
specJson.pathParams("bir","todos","iki","198");
    JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
    Response rs = given().contentType(ContentType.JSON).spec(specJson).when().body(obj.setUpPutData().toString()).put("/{bir}/{iki}");
rs.prettyPrint();

//jsonPath
    JsonPath json = rs.jsonPath();
assertEquals(200,rs.statusCode());
assertEquals(obj.setUpPutData().get("completed"),json.get("completed"));
assertEquals(obj.setUpPutData().get("id"),json.get("id"));
assertEquals(obj.setUpPutData().get("title"),json.get("title"));
assertEquals(obj.setUpPutData().get("userId"),json.get("userId"));



}
}
