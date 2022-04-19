package apiPractice.Niluferhoca;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class C17 extends JsonPlaceHolderBaseUrl {
//https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
//}
//"userId": 55,
//"title": "Tidy your room",
//"completed": false
//}
//Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu
//test edin
//{
//"userId": 55,
//"title": "Tidy your room",
//"completed": false,
//"id": ...
//}
@Test
public void test(){
    specJson.pathParam("param","todos");
    JSONObject Expected = JsonPlaceHolderTestData.NuluExpected();
    Response response = given().accept(ContentType.JSON).spec(specJson).when().body(Expected.toString()).post("{param}");

response.prettyPrint();
}

}
