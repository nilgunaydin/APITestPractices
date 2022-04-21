package apiPractice.Niluferhoca;

import apiPractice.Niluferhoca.pojos.C20pojo;
import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class C20 extends JsonPlaceHolderBaseUrl {
//https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
//Request body {
//"userId": 21,
//"id": 201,
//"title": "Tidy your room",
//"completed": false
//}
//Status kodun 201, response body ‘nin ise

//{
//
//"userId": 21,
//"id": 201,
//"title": "Tidy your room",
//"completed": false
//}

@Test
    public void test(){
specJson.pathParam("1","todos");

    C20pojo requestData = new C20pojo(21,201,"Tidy your room",false);

Response rs = given().spec(specJson).when().body(requestData).post("/{1}");

C20pojo actualData = rs.as(C20pojo.class);
    System.out.println(actualData);
}
}
