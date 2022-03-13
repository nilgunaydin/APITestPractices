package get_http_request.day12;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class DeleteRequest extends DummyBaseUrl {
  /*
  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde

Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"status": "success",
"data": "2",
"message": "Successfully! Record has been deleted"
}
   */

    @Test
    public void test() {
        //1) URL OLUSTUR
        spec02.pathParams("bir", "api", "iki", "v1", "uc", "delete", "dort", 2);

        //2) EXPECTED DATA
        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteData();
        System.out.println("expectedData = " + expectedData);

        //3) REQUEST VE RESPONSE
        Response response = given().
                spec(spec02).
                when().delete("/{bir}/{iki}/{uc}/{dort}");

        response.prettyPrint();

        //4) DOGRULAMA
        //1) MATCHERS CLASS

        response.then().assertThat().body("status",equalTo(expectedData.get("status"))
                ,"data",equalTo(expectedData.get("data")),"message",equalTo(expectedData.get("message")));


        //2)JSON PATH
        JsonPath json=response.jsonPath();
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("status"),json.get("status"));
        assertEquals(expectedData.get("data"),json.get("data"));
        assertEquals(expectedData.get("message"),json.get("message"));


        //3)De-Serialization

        HashMap<String,Object> actualData=response.as(HashMap.class);

        assertEquals(expectedData.get("status"),actualData.get("status"));
        assertEquals(expectedData.get("data"),actualData.get("data"));
        assertEquals(expectedData.get("message"),actualData.get("message"));

    }}
