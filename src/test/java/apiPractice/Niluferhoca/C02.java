package apiPractice.Niluferhoca;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C02 {
    //https://restful-booker.herokuapp.com/booking url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response'un
    //status kodunun 200
    //content type'inin "application/json" oldugunu test edin

    @Test
    public void Test1(){
        String url = "https://restful-booker.herokuapp.com/booking";
        Response rs = given().accept("application/json").when().get(url);
        rs.then().assertThat().contentType(ContentType.JSON).statusCode(200);

    }
    //https://restful-booker.herokuapp.com/booking/1001 url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response'un
    //status kodunun 404 oldugunu
    //ve Response body'sinin "Not Found" icerdigini
    //ve Response body'sinin "API" icermedigini test edin
    @Test
    public void Test2(){
        String url = "https://restful-booker.herokuapp.com/booking/1001";
        Response rs = given().when().get(url);
        rs.then().assertThat().statusCode(404);
        assertTrue(rs.getBody().asString().contains("Not Found"));
        assertFalse(rs.getBody().asString().contains("API"));
    }}
