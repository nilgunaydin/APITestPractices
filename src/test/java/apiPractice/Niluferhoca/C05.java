package apiPractice.Niluferhoca;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C05 {
    //http://dummy.restapiexample.com/api/v1/employees url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response'un
    //status kodunun 200
    //
    //ve content type'inin "application/json"
    //
    //ve employees sayisinin 24
    //ve employee'lerden birinin "Ashton Cox"
    //ve gelen icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin


    @Test
    public void testC05(){
        String url="http://dummy.restapiexample.com/api/v1/employees";
        Response rs = given().accept(ContentType.JSON).when().get(url);

        rs.then().assertThat().body("data.id", hasSize(24),"data.employee_name",
                hasItem("Ashton Cox"),"data.employee_age",hasItems(21,23,61));
    }
}
