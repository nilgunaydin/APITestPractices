package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19 extends DummyBaseUrl {
//http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
//
//Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test
//edin
//{
//"status": "success",
//"data": "2",
//"message": "Successfully! Record has been deleted"
//}

@Test
    public void test(){
    spec02.pathParams("1","api","2","v1","3","delete","4","2");
    Response rs = given().spec(spec02).when().delete("/{1}/{2}/{3}/{4}");
rs.prettyPrint();

    DummyTestData td = new DummyTestData();
    JsonPath json = rs.jsonPath();
    assertEquals(rs.getStatusCode(),200);
    assertEquals(json.getString("status"),td.setUpDeleteData().get("status"));
    assertEquals(json.getString("data"),td.setUpDeleteData().get("data"));
    assertEquals(json.getString("message"),td.setUpDeleteData().get("message"));


}

}
