package apiPractice.Niluferhoca;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C11 extends JsonPlaceHolderBaseUrl {
    //https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
    //Dönen response un
    //Status kodunun 200, dönen body de,
    //"completed": değerinin false
    //"title”: değerinin “quis ut nam facilis et officia qui”
    //"userId" sinin 1 ve header değerlerinden
    //"Via" değerinin “1.1 vegur” ve
    //"Server" değerinin “cloudflare” olduğunu test edin...


    @Test
    public void test(){

specJson.pathParams("1","todos","2",2);
        Response rs = given().spec(specJson).when().get("/{1}/{2}");
Map<String, Object> expected = new HashMap();
expected.put("Status",200);
expected.put("completed",false);
expected.put("title","quis ut nam facilis et officia qui");
expected.put("Via","1.1 vegur");
expected.put("userId",1);
expected.put("Server","cloudflare");

        System.out.println("expected = " + expected);

        rs.prettyPrint();










}}
