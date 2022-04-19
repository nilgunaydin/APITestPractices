package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C15 extends DummyBaseUrl {
//PostRequest01:
//http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
//{
//"name":"Ahmet Aksoy",
//"salary":"1000",
//"age":"18",
//"profile_image": ""
//}
//gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
//{
//"status": "success",
//"data": {
//“id”:...
//},
//"message": "Successfully! Record has been added."
// }
//olduğunu test edin

@Test
    public void test(){

    spec02.pathParams("1","api","2","v1","3","create");

    Map<String, Object> postBody = new HashMap();
    postBody.put("name","Nilgun Aydin");
    postBody.put("salary",15000);
    postBody.put("age",26);
    postBody.put("profile_image","");

    Response rs = given().accept(ContentType.JSON).spec(spec02).when().auth().basic("admin","password123").body(postBody).post("/{1}/{2}/{3}");
rs.prettyPrint();
//authentication -> bir kullaniciya verilen erisim izni/kimlik/vpn
//authorization  ->    bu erisim izniyle neler yapabilirsin >>> post / get / put / patch  benim yetkilerimin siniri

}
}
