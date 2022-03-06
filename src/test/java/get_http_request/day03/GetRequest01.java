package get_http_request.day03;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01(){
        String url = "https://restful-booker.herokuapp.com/booking";
      Response rs =   given().when().get(url);
rs.prettyPrint();

Assert.assertEquals(200,rs.statusCode());


rs.then().assertThat().statusCode(200);
    }
}
