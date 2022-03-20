package apiPractice.Niluferhoca;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06 extends JsonPlaceHolderBaseUrl {
    //https://jsonplaceholder.typicode.com/todos/123 url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response’un
    //
    //status kodunun 200
    //
    //ve content type'inin "application/json"
    //ve Headers'daki "Server" in "cloudflare"
    //ve response body'deki "userId"'nin 7
    //ve "title" in "esse et quis iste est earum aut impedit"
    //ve "completed" bolumunun false oldugunu test edin

    @Test
    public void testC05(){
       // String url="https://jsonplaceholder.typicode.com/todos/123";
        specJson.pathParams("1","todos","2",123);

        Response rs = given().spec(specJson).accept(ContentType.JSON).when().get("/{1}/{2}");

        rs.then().assertThat().body("id", equalTo(123),"title",
                equalTo("esse et quis iste est earum aut impedit"),"userId",equalTo(7),"completed",equalTo(false));
    }}
