package get_http_request;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest09 extends DummyBaseUrl {

/*
http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/

    @Test
    public void test9(){

        spec02.pathParams("par1","api","par2","v1","par3","employee","par4","12");

        Response rs = given().spec(spec02).when().get("/{par1}/{par2}/{par3}/{par4}");
rs.prettyPrint();
     //Matcher class ile
rs.then().assertThat().contentType(ContentType.JSON).statusCode(200);
rs.then().body("data.id",equalTo(12),"data.employee_name",equalTo("Quinn Flynn"),
        "data.employee_salary", equalTo( 342000),"data.employee_age",equalTo(22));

     //jsonpath ile
        JsonPath json = rs.jsonPath();
        assertEquals(12,json.getInt("data.id"));
        assertEquals("Quinn Flynn",json.getString("data.employee_name"));
        assertEquals(342000,json.getInt("data.employee_salary"));
        assertEquals(22,json.getInt("data.employee_age"));






    }
}
