package apiPractice.Niluferhoca;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C04 {
    //https://restful-booker.herokuapp.com/booking/5 url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response'un
    //status kodunun 200
    //ve content type'inin "application/json"
    //ve firstname'in “Jim"
    //ve totalprice’in 600
    //ve checkin date'in 2015-06-12"oldugunu test edin
@Test
    public void test01(){

    String url = "https://restful-booker.herokuapp.com/booking/5";
    Response response = given().when().get(url);

    response.prettyPrint();

   response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
            body("firstname",equalTo("Jim"),
                   "bookingdates.checkin",equalTo("2015-05-06"));




}





}
