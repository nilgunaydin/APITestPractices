package get_http_request.day13;

import base_url.DummyBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestPojo01 extends DummyBaseUrl {
    /*
GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
                           Status code is 200
{
 "status": "success",
 "data": {
   "id": 1,
   "employee_name": "Tiger Nixon",
   "employee_salary": 320800,
   "employee_age": 61,
   "profile_image": ""
   },
 "message": "Successfully! Record has been fetched."
 }
*/
@Test
    public void test(){
    //1) URL OLUSTUR
    spec02.pathParams("bir", "api", "iki", "v1", "uc", "employee", "dort", 1);

    //2) EXPECTED DATA
    DummyDataPojo data = new DummyDataPojo(1, "Tiger Nixon", 320800,61,"");
    System.out.println("data = " + data);

    DummyPojo expexted = new DummyPojo("success","Successfully! Record has been fetched." , data);
    System.out.println("expexted = " + expexted);

    //3) REQUEST ve RESPONSE
    Response response = given().contentType(ContentType.JSON).spec(spec02)
            .when()
            .get("/{bir}/{iki}/{uc}/{dort}");

    response.prettyPrint();

    //4) DOĞRULAMA
    DummyPojo actual=response.as(DummyPojo.class);
   assertEquals(expexted.getStatus(),actual.getStatus());
   assertEquals(expexted.getData().getId(),actual.getData().getId());
   assertEquals(expexted.getData().getEmployee_name(),actual.getData().getEmployee_name());
   assertEquals(expexted.getData().getEmployee_salary(),actual.getData().getEmployee_salary());
   assertEquals(expexted.getData().getEmployee_age(),actual.getData().getEmployee_age());
   assertEquals(expexted.getData().getProfile_image(),actual.getData().getProfile_image());
   assertEquals(expexted.getMessage(),actual.getMessage());



    Gson gson = new Gson();
    String jsonFromJava = gson.toJson(actual);
    System.err.println("jsonFromJava = " + jsonFromJava);
    //jsonFromJava = {
    // "status":"success",
    // "data":{"id":1,
    // "employee_name":"Tiger Nixon",
    // "employee_salary":320800,
    // "employee_age":61,
    // "profile_image":""},
    // "message":"Successfully! Record has been fetched."

}
}
