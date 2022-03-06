package get_http_request.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {
    @Test
    public void test04(){
        /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
 GET request'i yolladigimda gelen response'un
 status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 1, ve 23 degerlerinden birinin oldugunu test edin.
 */
        String url = "http://dummy.restapiexample.com/api/v1/employees";

       Response rs = given().when().get(url);
        rs.prettyPrint();

rs.then().assertThat().contentType(ContentType.JSON).statusCode(200);
rs.then().body("data", Matchers.hasSize(24),
        "data.employee_name",Matchers.hasItem("Ashton Cox"),
        "data.employee_age",Matchers.hasItems(21,23,61));


    }
}
