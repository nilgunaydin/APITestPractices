package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14 extends DummyBaseUrl {
    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.

    @Test
    public void test(){

        spec02.pathParams("1","api","2","v1","3","employees");
        Response rs = given().spec(spec02).when().get("/{1}/{2}/{3}");
rs.prettyPrint();
        DummyTestData obj = new DummyTestData();
        Map<String, Object> expected = obj.setupTestData2();
        Map<String, Object> actual = rs.as(Map.class);

        //Status kodun 200 olduğunu,
        assertEquals(expected.get("statusCode"),rs.getStatusCode());
        //En yüksek maaşın 725000 olduğunu,
        List<Integer>maasList = new ArrayList();
        for (int i = 0; i < ((List)actual.get("data")).size() ; i++) {
          maasList.add((int)((Map)((List)actual.get("data")).get(i)).get("employee_salary"));
        }
        Collections.sort(maasList);
        assertEquals(expected.get("enYuksekMaas"),maasList.get(maasList.size()-1));
        //En kucuk yasin 19 olduğunu,
        List<Integer>ageList = new ArrayList();
        for (int i = 0; i <((List)actual.get("data")).size() ; i++) {
            ageList.add((int)((Map)((List)actual.get("data")).get(i)).get("employee_age"));
        }
        Collections.sort(ageList);
        assertEquals(expected.get("enKucukYas"),ageList.get(0));

        //ikinci en yüksek maasin 675000
        assertEquals(expected.get("2.yuksekMaas"),maasList.get(maasList.size()-2));

}}
