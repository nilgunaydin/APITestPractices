package get_http_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest11 {
  String endPoint = "http://www.gmibank.com/api/tp-customers";
  String bearerToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDQ0YXBpIiwiYXV0aCI6IlJPTEVfQ1VTVE9NRVIiLCJleHAiOjE2NDY2NDE3OTd9.KxnrBsxGavxEb8GeT_mOF17LRrTHh0syj_bJWFrJ6VTCWL4NhI4mxHXe91kJW-pgJP9gfXpWoHdLb2bDG1fS6Q";
  @Test
  public void test(){

    Response response = given()
            .header("Authorization","Bearer " + bearerToken)
            .when().get(endPoint).then().extract().response();

    response.prettyPrint();
}
}
