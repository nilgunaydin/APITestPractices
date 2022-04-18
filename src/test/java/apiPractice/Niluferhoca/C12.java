package apiPractice.Niluferhoca;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12 extends HerOkuAppBaseUrl {
//https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
//dönen response body nin
//{
//"firstname": "Eric",
//"lastname": "Smith",
//"totalprice": 555,
//"depositpaid": false,
//"bookingdates": {
//"checkin": "2016-09-09",
//"checkout": "2017-09-21"
//}
//} gibi olduğunu test edin.

    @Test
    public void test(){
spec05.pathParams("1","booking","2",1);
        Response rs = given().spec(spec05).when().get("/{1}/{2}");
        rs.prettyPrint();

        HerOkuAppTestData obj = new HerOkuAppTestData();
        Map<String, Object> expected = obj.setUpTestData();
        Map<String, Object> actual = rs.as(Map.class);

assertEquals(expected,actual);
}}
