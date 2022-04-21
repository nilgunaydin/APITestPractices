package apiPractice.Niluferhoca;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class C18 extends JsonPlaceHolderBaseUrl {
//https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
//{
//
//"title": "API calismaliyim"
//
//}
//Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test
//edin
//{
//"userId": 10,
//"title": "API calismaliyim"
//"completed": true,
//"id": 198
//}

 @Test
 public void test(){
     specJson.pathParams("1","todos","2",198);
     JsonPlaceHolderTestData td = new JsonPlaceHolderTestData();
             Response rs = given().accept("application/json").spec(specJson).auth().basic("admin","password123").body(td.requestData().toString()).when().patch("/{1}/{2}");
     rs.prettyPeek();


/** guncellenmiyor*/

 }

}
