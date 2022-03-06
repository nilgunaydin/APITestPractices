package get_http_request.day05;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class GetRequest10 extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees
    url ine bir istek gönderildiğinde,
    status kodun 200,
    gelen body de,
    5. çalışanın isminin "Airi Satou" olduğunu ,
    6. çalışanın maaşının "372000" olduğunu ,
    Toplam 24 tane çalışan olduğunu,
    "Rhona Davidson" ın employee lerden biri olduğunu
    "21", "23", "61" yaşlarında employeeler olduğunu test edin
    JSONPATH KULLARAK
*/
@Test
public void test10(){
    spec02.pathParams("par1","api","par2","v1","par3","employees");

    Response rs = given().spec(spec02).when().get("/{par1}/{par2}/{par3}");
    rs.prettyPrint();

    rs.then().assertThat().statusCode(200);
    JsonPath json = rs.jsonPath();


assertEquals("Airi Satou",json.getString("data.employee_name[4]"));
assertEquals(372000,json.getInt("data.employee_salary[5]"));
assertEquals(24,json.getList("data.employee_name").size());
assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));
assertTrue(json.getList("data.employee_age").contains(21) && json.getList("data.employee_age").contains(23)
       && json.getList("data.employee_age").contains(61));


}


}
