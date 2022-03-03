package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    @Test
    public void test3(){
/*
    https://restful-booker.herokuapp.com/booking/7 url'ine
GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'i
ve lastname'i
ve checkin date'i
ve checkout date'i test edin
     */
String url = "https://restful-booker.herokuapp.com/booking/7";

        Response rs = given().when().get(url);

rs.prettyPrint();

rs.then().contentType(ContentType.JSON).statusCode(200);  //assertThat'siz calisti     //contentType= "application/json"

rs.then().assertThat().body("firstname" ,equalTo("Mary"),
                            "lastname", equalTo("Brown"),
                            "bookingdates.checkin", equalTo("2020-03-27"),
                            "bookingdates.checkout", equalTo("2020-08-19"));

    }
}
