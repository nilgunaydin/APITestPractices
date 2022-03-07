package get_http_request.day07;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest18 extends Authentication {
/*
http://www.gmibank.com/api/tp-customers/43703

"firstName": "Alda",
"lastName": "Monahan",
"middleInitial": "Nichelle Hermann Kohler",
"email": "com.github.javafaker.Name@7c011174@gmail.com",
"mobilePhoneNumber": "909-162-8114",
"city": "St Louis",
"ssn": "108-53-6655"

1) MATCHERS CLASS
2) JSON PATH
3) De-Serialization
 */

    @Test
            public void test18(){

    specGMI.pathParams("one","tp-customers","two",43703);
Response rs = given().spec(specGMI).header("Authorization","Bearer "+generateToken()).when().get("/{one}/{two}");

rs.prettyPrint();

//Matcher class ile

rs.then().body("firstName",equalTo("Alda"),
        "lastName",equalTo("Monahan"),
        "middleInitial",equalTo("Nichelle Hermann Kohler"),
        "email",equalTo("com.github.javafaker.Name@7c011174@gmail.com"),
        "mobilePhoneNumber",equalTo("909-162-8114"),
        "city",equalTo("St Louis"),
        "ssn",equalTo("108-53-6655"));


//jsonpath ile

        JsonPath json = rs.jsonPath();

        assertEquals("Alda",json.getString("firstName"));
        assertEquals("Monahan",json.getString("lastName"));
        assertEquals("Nichelle Hermann Kohler",json.getString("middleInitial"));
        assertEquals("com.github.javafaker.Name@7c011174@gmail.com",json.getString("email"));
        assertEquals("909-162-8114",json.getString("mobilePhoneNumber"));
        assertEquals("St Louis",json.getString("city"));
        assertEquals("108-53-6655",json.getString("ssn"));


//de-serialization ile

Map<String,Object> expected = new HashMap<>();
expected.put("firstName","Alda");
expected.put("lastName","Monahan");
expected.put("middleInitial","Nichelle Hermann Kohler");
expected.put("email","com.github.javafaker.Name@7c011174@gmail.com");
expected.put( "mobilePhoneNumber","909-162-8114");
expected.put( "city","St Louis");
expected.put("ssn","108-53-6655");

Map<String,Object> actual = rs.as(HashMap.class);
        System.out.println(actual);
       assertEquals(expected.get("firstName"), actual.get("firstName"));
       assertEquals(expected.get("lastName"), actual.get("lastName"));
       assertEquals(expected.get("middleInitial"), actual.get("middleInitial"));
       assertEquals(expected.get("email"), actual.get("email"));
       assertEquals(expected.get("mobilePhoneNumber"), actual.get("mobilePhoneNumber"));
       assertEquals(expected.get("city"), actual.get("city"));
       assertEquals(expected.get("ssn"), actual.get("ssn"));
    }
}
