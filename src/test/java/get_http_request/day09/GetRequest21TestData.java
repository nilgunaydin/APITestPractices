package get_http_request.day09;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest21TestData extends JsonPlaceHolderBaseUrl {

    @Test
    public void test21(){
  /*
        https://jsonplaceholder.typicode.com/todos/2
        1) Status kodunun 200,
        2) respose body'de,
         "completed": değerinin false
         "title": değerinin "quis ut nam facilis et officia qui"
         "userId" sinin 1 ve
        header değerlerinden
         "via" değerinin "1.1 vegur" ve
         "Server" değerinin "cloudflare" olduğunu test edin…
*/
        specJson.pathParams("bir","todos","iki",2);
        Response rs = given().spec(specJson).when().get("/{bir}/{iki}");


//2. EXPECTED DATA OLURTUR

        Map<String,Object> expected = JsonPlaceHolderTestData.setUpTestData();
        HashMap<String,Object> actualData=rs.as(HashMap.class);
    rs.then().assertThat().statusCode((Integer) expected.get("statusCode")).and().body("completed", equalTo(expected.get("completed")),"title",equalTo(expected.get("title")),
            "userId",equalTo(expected.get("userId"))).
            and().headers("via",expected.get("via"),"Server",expected.get("Server"));


//jsonpath ile
        JsonPath json = rs.jsonPath();
        assertEquals(false,json.getBoolean("completed"));
        assertEquals(200,rs.getStatusCode());
        assertEquals("quis ut nam facilis et officia qui",json.getString("title"));
        assertEquals(1,json.getInt("userId"));
        assertEquals("1.1 vegur",rs.getHeader("via"));
        assertEquals("cloudflare",rs.getHeader("Server"));

        assertEquals(expected.get("userId"),actualData.get("userId"));
        assertEquals(expected.get("completed"),actualData.get("completed"));
        assertEquals(expected.get("title"),actualData.get("title"));
    }
}
