package get_http_request.day06;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest14 extends Authentication {
       /*
http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın

"firstName": "Melva",
"lastName": "Bernhard",
"email": "chas.kuhlman@yahoo.com"
"zipCode": "40207"
"country" "name": "San jose
"login": "delilah.metz"
 */

    @Test
    public void test14(){
        specGMI.pathParams("first","tp-customers","second","110472");
        Response rs = given().spec(specGMI).header("Authorization","Bearer " + generateToken())
                .when().get("/{first}/{second}");
rs.prettyPrint();
        rs.then().assertThat().body("firstName",equalTo("Melva"),"lastName",equalTo("Bernhard"),
                "email",equalTo("chas.kuhlman@yahoo.com"),"zipCode",equalTo("40207"),"country.name",equalTo("San Jose")
        ,"user.login",equalTo("delilah.metz"));
    }
}
