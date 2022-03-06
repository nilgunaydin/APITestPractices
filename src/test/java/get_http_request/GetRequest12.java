package get_http_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends Authentication {
    @Test
    public void test12(){

        String endPoint = "http://www.gmibank.com/api/tp-customers";
        Response rs = given().header("Authorization","Bearer " + generateToken()).
                when().get(endPoint).then().extract().response();
        rs.prettyPrint();

        rs.then().contentType(ContentType.JSON).statusCode(200);







    }
}
