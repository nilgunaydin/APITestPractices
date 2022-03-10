package get_http_request.day10;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;
import java.util.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest23 extends DummyBaseUrl {
    @Test
    public void test23(){
        /*
http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
14. Çalışan isminin "Haley Kennedy" olduğunu,
Çalışan sayısının 24 olduğunu,
Sondan 3. çalışanın maaşının 675000 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi

{
        "id": 10,
        "employee_name": "Sonya Frost",
        "employee_salary": 103600,
        "employee_age": 23,
        "profile_image": ""
 }

  olduğunu test edin.
*/
        spec02.pathParams("1","api","2","v1","3","employees");

        DummyTestData object = new DummyTestData();

        HashMap<String,Object> expectedTestData = object.setupTestData();
       // System.out.println(expectedTestData);
        Response rs = given().spec(spec02).when().get("/{1}/{2}/{3}");
        rs.prettyPrint();

        HashMap<String,Object> actual = rs.as(HashMap.class);
        System.out.println("actual = " + actual);
        assertEquals(expectedTestData.get("statusCode"), rs.statusCode());
        //14. Çalışan isminin "Haley Kennedy" olduğunu,

        assertEquals(expectedTestData.get("14.calisan"),((java.util.Map)( (List) actual.get("data")).get(13)).get("employee_name"));
        //Çalışan sayısının 24 olduğunu,

        assertEquals(expectedTestData.get("calisanSayisi"),((List)actual.get("data")).size());
        //Sondan 3. çalışanın maaşının 675000 olduğunu


assertEquals(expectedTestData.get("sondan3.CalisaninMaasi"),
                ((Map)((List)actual.get("data")).get(((List)actual.get("data")).size()-3)).get("employee_salary"));

        /** 40,21 ve 19 yaslarında çalışanlar olup olmadığını


       List<Integer> yas = (List)((Map) actual.get("data")).get("employee_age");
        System.out.println(yas);

         assertTrue(((List)((Map) actual.get("data")).get("employee_age")).
         containsAll((List)expectedTestData.get("arananYaslar")));

        */




        //40,21 ve 19 yaslarında çalışanlar olup olmadığını

        //1. Yol
        List<Integer> actualYasListesi = new ArrayList<>();

        for(int i =0; i<24; i++){
            actualYasListesi.add(((Integer) ((Map)((List<?>) actual.get("data")).get(i)).get("employee_age")));
        }
        assertTrue(actualYasListesi.containsAll((Collection<?>) expectedTestData.get("arananYaslar")));

        //2. Yol
        List<Integer> employee_age = new ArrayList<>();
        for(int i=0 ; i < ((List)actual.get("data")).size() ; i++){
            employee_age.add((Integer) ((Map)((List)actual.get("data")).get(i)).get("employee_age"));
            Assert.assertTrue(actualYasListesi.containsAll((Collection<?>) expectedTestData.get("arananyaslar")));


        //10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi




    }
}}
