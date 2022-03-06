package get_http_request.day06;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest13 extends Authentication {
    //http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
//    “firstName”: “Della”,
//    “lastName”: “Heaney”,
//    “mobilePhoneNumber”: “123-456-7893”,
//    “address”: “75164 McClure Stream”,
//    “country” : “USA”
//    “state”: “New York43"
//    “CREDIT_CARD”,hesabında 69700$ ,
//    “CHECKING” hesabında 11190$
    
   @Test
   public void test13(){
       specGMI.pathParams("par1","tp-customers","par2","114351");
       Response rs = given().spec(specGMI).when().
               header("Authorization","Bearer " + generateToken()).get("/{par1}/{par2}");
       rs.then().body("firstName",equalTo("Della"));

       JsonPath json = rs.jsonPath();

       Assert.assertEquals("Heaney",json.getString("lastName"));

   }
}
