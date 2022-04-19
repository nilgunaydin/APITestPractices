package apiPractice.Niluferhoca;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C16 extends HerOkuAppBaseUrl {


    //https://restful-booker.herokuapp.com/booking url ine, Request Body olarak
    //{ "firstname": "Selim",
    //"lastname": "Ak",
    //"totalprice": 11111,
    //"depositpaid": true,
    //"bookingdates": {
    //"checkin": "2020-09-09",
    //"checkout": "2020-09-21"  }
    //}gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
    //"booking": {
    //"firstname": " Selim ",
    //"lastname": " Ak ",
    //"totalprice": 11111,
    //"depositpaid": true,
    //"bookingdates": {
    //"checkin": "2020-09-01",
    //"checkout": " 2020-09-21” }   }
    //olduğunu test edin


@Test
    public void test(){
    Map<String,Object> bookingDates = new HashMap();
    Map<String,Object> postBody = new HashMap();
   bookingDates.put("checkin","2020-09-09");
   bookingDates.put("checkout","2020-09-21");

    postBody.put("firstname","Selim");
    postBody.put("lastname","Ak");
    postBody.put("totalprice","11111");
    postBody.put("depositpaid",true);
    postBody.put("bookingdates",bookingDates);

 spec05.pathParam("param","booking");
    Response rs = given().accept(ContentType.JSON).spec(spec05).when().body(postBody).post("/{param}");

}
}