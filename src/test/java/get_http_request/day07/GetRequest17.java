package get_http_request.day07;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest17 extends Authentication {
      /*
   http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın

{
   "firstName": "Della",
   "lastName": "Heaney",
   "email": "ricardo.larkin@yahoo.com",
   "mobilePhoneNumber": "123-456-7893",
}
    */

    @Test
    public  void test17(){
        Map<String,Object> expected = new HashMap<>();
        expected.put("firstName","Della");
        expected.put("lastName","Heaney");
        expected.put("email","ricardo.larkin@yahoo.com");
        expected.put("mobilePhoneNumber","123-456-7893");

        specGMI.pathParams("1","tp-customers","2",114351);
        Response rs = given().spec(specGMI).header("Authorization","Bearer "+ generateToken()).when().get("/{1}/{2}");
        rs.prettyPrint();
        Map<String,Object> actual = rs.as(HashMap.class);

        Assert.assertEquals(expected.get("firstName"),actual.get("firstName"));
        Assert.assertEquals(expected.get("lastName"),actual.get("lastName"));
        Assert.assertEquals(expected.get("email"),actual.get("email"));
        Assert.assertEquals(expected.get("mobilePhoneNumber"),actual.get("mobilePhoneNumber"));


    }
}
