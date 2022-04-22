package apiPractice.Niluferhoca;

import apiPractice.Niluferhoca.pojos.C23Pojo;
import apiPractice.Niluferhoca.pojos.DataPojo;
import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23 extends DummyBaseUrl {

    //http://dummy.restapiexample.com/api/v1/employee/1 url ‘ine bir get request
    //gönderildiğinde , dönen response ‘un,
    //Status kodunun 200 ve response body’nin
    //{
    //"status": "success",
    //"data": {"Tiger Nixon",
    //"employee_salary": 320800,
    //"employee_age": 61,},
    //"message": "Successfully! Record has been fetched."
    //}
    //Olduğunu test edin

    @Test
    public void test(){
        spec02.pathParams("1","api","2","v1","3","employee","4",1);

        DataPojo data = new DataPojo(1,"Tiger Nixon",320800,61,"");
        C23Pojo expected = new C23Pojo("success",data,"Successfully! Record has been fetched.");
        Response rs = given().spec(spec02).when().get("/{1}/{2}/{3}/{4}");
        C23Pojo actual = rs.as(C23Pojo.class);
      


    }
}
