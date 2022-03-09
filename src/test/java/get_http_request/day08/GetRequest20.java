package get_http_request.day08;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest20 extends JsonPlaceHolderBaseUrl {

//https://jsonplaceholder.typicode.com/todos/2
//1) Status kodunun 200,
//2) respose body'de,
//         "completed": değerinin false
//         "title": değerinin "quis ut nam facilis et officia qui"
//         "userId" sinin 1 ve
//    header değerlerinden
//         "via" değerinin "1.1 vegur" ve
//         "Server" değerinin "cloudflare" olduğunu test edin…
@Test
    public void test20(){
    specJson.pathParams("bir","todos","iki",2);
    Response rs = given().spec(specJson).when().get("/{bir}/{iki}");

    Map<String, Object>expected = new HashMap<>();
    expected.put("completed",false);
    expected.put("statusCode",200);
    expected.put( "title","quis ut nam facilis et officia qui");
    expected.put( "userId",1 );
    expected.put( "via", "1.1 vegur");
    expected.put("Server", "cloudflare");

    JsonPath json = rs.jsonPath();
//matchers class ile

    rs.then().statusCode( (int) expected.get("statusCode"));
    rs.then().body("completed", equalTo(expected.get("completed")),"title",equalTo(expected.get("title")),
            "userId",equalTo(expected.get("userId"))).
            and().headers("via",expected.get("via"),"Server",expected.get("Server"));


//jsonpath ile

    assertEquals(false,json.getBoolean("completed"));
    assertEquals(200,rs.getStatusCode());
    assertEquals("quis ut nam facilis et officia qui",json.getString("title"));
    assertEquals(1,json.getInt("userId"));
    assertEquals("1.1 vegur",rs.getHeader("via"));
    assertEquals("cloudflare",rs.getHeader("Server"));

    Map<String, Object>actual = rs.as(HashMap.class);
    assertEquals(expected.get("userId"),actual.get("userId"));
    assertEquals(expected.get("completed"),actual.get("completed"));
    assertEquals(expected.get("title"),actual.get("title"));
}
}
