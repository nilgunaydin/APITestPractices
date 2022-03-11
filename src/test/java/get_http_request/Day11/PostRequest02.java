package get_http_request.Day11;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostRequest02 extends DummyBaseUrl {
/*
http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
{
    "name":"Ali Can",
    "salary":"2000",
    "age":"40",
}
gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin,

{
    "status": "success",
    "data": {
    "id":…
},
    "message": "Successfully! Record has been added."
}

olduğunu test edin
 */


    @Test
    public void test25(){

        spec02.pathParams("1","api","2","v1","3","create");

        DummyTestData obj = new DummyTestData();

        Map<String,Object> requestBodyMap = obj.PostVeri();
        Map<String,Object> expectedBody = obj.expected();


        Response rs = given().spec(spec02).when().body(requestBodyMap).post("/{1}/{2}/{3}");

        //dogrulama
        //de serilization
        HashMap<String, Object> actualDataMap = rs.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(expectedBody.get("statusCode"), rs.getStatusCode());
        assertEquals(expectedBody.get("status"), actualDataMap.get("status"));
        assertEquals(expectedBody.get("message"), actualDataMap.get("message"));

        //JSON Path
        JsonPath json = rs.jsonPath();
        assertEquals(expectedBody.get("statusCode"), rs.statusCode());
        assertEquals(expectedBody.get("status"), json.getString("status"));
        assertEquals(expectedBody.get("message"), json.getString("message"));

    }
}
