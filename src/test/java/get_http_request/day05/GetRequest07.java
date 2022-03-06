package get_http_request.day05;

import base_url.ReqresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest07 extends ReqresinBaseUrl {

        /*
https://reqres.in/api/users URL request olustur.
body icerisindeki idsi 5 olan datayi
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/


        @Test
        public void test07(){
    spec01.pathParams("par1","api","par2","users");

            Response rs = given().spec(spec01).when().get("/{par1}/{par2}");

rs.prettyPrint();

//matchers Class
    rs.then().assertThat().
            body("data[4].email", equalTo("charles.morris@reqres.in"),
                    "data[4].first_name",equalTo("Charles"),
                    "data[4].last_name",equalTo("Morris"));

//JSON path ile

            JsonPath json = rs.jsonPath();
            System.out.println(json.getList("data.email"));
            System.out.println(json.getString("data.first_name"));
            System.out.println(json.getString("data.last_name"));

            Assert.assertEquals("emma.wong@reqres.in",json.getString("data[2].email"));
            Assert.assertEquals("Emma",json.getString("data[2].first_name"));
            Assert.assertEquals("Wong",json.getString("data[2].last_name"));

        }
}
