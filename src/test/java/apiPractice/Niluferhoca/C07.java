package apiPractice.Niluferhoca;

import base_url.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C07 extends HerOkuAppBaseUrl {
    //https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
    //HTTP Status Code’unun 200
    //ve response content type’inin “application/JSON” oldugunu
    //ve response body’sinin asagidaki gibi oldugunu test edin
    //{"firstname": Sally,
    //
    //"lastname": "Smith",
    //"totalprice": 789,
    //"depositpaid": false,
    //"bookingdates": { "checkin": "2017-12-11",
    //"checkout":"2020-02-20" }
    //}
    @Test
    public void test(){
        spec05.pathParams("1","booking","2",5);

        Response rs = given().spec(spec05).when().get("/{1}/{2}");
    rs.prettyPrint();
        JsonPath json= rs.jsonPath();
        assertEquals("Mary",json.get("firstname"));
        assertEquals("Ericsson",json.get("lastname"));
        assertEquals(388,json.getInt("totalprice"));
        assertEquals(false,json.get("depositpaid"));
        assertEquals("2021-05-12",json.get("bookingdates.checkin"));
        assertEquals("2022-03-21",json.get("bookingdates.checkout"));


    }

}
