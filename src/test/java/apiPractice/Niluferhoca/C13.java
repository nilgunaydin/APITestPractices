package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C13 extends DummyBaseUrl {
    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //5. Çalışan isminin "Airi Satou" olduğunu ,
    // çalışan sayısının 24 olduğunu,
    //Sondan 2. çalışanın maaşının 106450 olduğunu
    //40,21 ve 19 yaslarında çalışanlar olup olmadığını
    //11. Çalışan bilgilerinin
    //{
    //“id”:”11”
    //"employee_name": "Jena Gaines",
    //"employee_salary": "90560",
    //"employee_age": "30",
    //"profile_image": "" }
    //} gibi olduğunu test edin.

    @Test
    public void test(){
        spec02.pathParams("1","api","2","v1","3","employees");
        Response rs = given().spec(spec02).when().get("/{1}/{2}/{3}");
        rs.prettyPrint();
        DummyTestData obj = new DummyTestData();
        Map<String,Object> expected = obj.setupTestData();
        Map<String,Object> actual = rs.as(Map.class);
        rs.then().assertThat().statusCode(200);
        assertEquals(expected.get("5.calisan"),((Map)((List) actual.get("data")).get(4)).get("employee_name"));
        assertEquals(expected.get("calisanSayisi"),((List)actual.get("data")).size());
        assertEquals(expected.get("sondan2.CalisaninMaasi"),((Map)((List)actual.get("data")).get(((List)actual.get("data")).size()-2)).get("employee_salary"));
        JsonPath json= rs.jsonPath(); //bu islemler yerine for loopla da cozebilirsin
        List <Integer> actualYaslar = json.getList("data.employee_age");
        assertTrue(actualYaslar.containsAll((List) expected.get("arananYaslar")));
        assertEquals(expected.get("onBirinci"),((List) actual.get("data")).get(10));


    //matcher

        rs.then().assertThat().body( "data[4].employee_name",equalTo(expected.get("5.calisan")));
//ve benzeri

            //JsonPath


        assertEquals(expected.get("5.calisan"),json.get("data[4].employee_name"));
        assertEquals(expected.get("calisanSayisi"),json.getList("data").size());
        assertEquals(expected.get("sondan2.CalisaninMaasi"),json.get("data[-2].employee_salary"));
}
}
