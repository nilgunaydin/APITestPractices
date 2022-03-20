package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C09 extends DummyBaseUrl {
    //http://dummy.restapiexample.com/api/v1/employees
    //
    //url ine bir istek gönderildiğinde,
    //status kodun 200,
    //gelen body de,
    //5. çalışanın isminin "Airi Satou" olduğunu ,
    //6. çalışanın maaşının "372000" olduğunu ,
    //Toplam 24 tane çalışan olduğunu,
    //"Rhona Davidson" ın employee lerden biri olduğunu
    //"21", "23", "61" yaşlarında employeeler olduğunu test edin


    @Test
    public void test(){

        spec02.pathParams("bir","api","iki","v1","uc","employees");

        Response rs = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");
        rs.prettyPrint();
        JsonPath json = rs.jsonPath();

        //status kodun 200,
        rs.then().assertThat().statusCode(200);

        //5. çalışanın isminin "Airi Satou" olduğunu ,

        assertEquals("Airi Satou",json.getString("data.employee_name[4]"));

        //6. çalışanın maaşının "372000" olduğunu ,

        assertEquals(372000,json.getInt("data.employee_salary[5]"));

        //"Rhona Davidson" ın employee lerden biri olduğunu

        assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));

        //Toplam 24 tane çalışan olduğunu

        assertEquals(24,json.getList("data.id").size());

        //"21", "23", "61" yaşlarında employeeler olduğunu test edin
        assertTrue(json.getList("data.employee_age").containsAll(Arrays.asList(21,23,61)));

    }
}
