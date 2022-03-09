package get_http_request.day08;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest19 extends DummyBaseUrl {
/*
http://dummy.restapiexample.com/api/v1/employees
*/
@Test
public void test19(){
    spec02.pathParams("bir","api","iki","v1","uc","employees");
   // 1) Status kodunun 200
    Response rs = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");
    rs.then().statusCode(200);

//2) 10’dan büyük tüm id'leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu
    JsonPath json = rs.jsonPath();
    List<Integer> idList = json.getList("data.id.findAll{it>10}");
    System.out.println(idList);

    assertEquals(idList.size(),14);

    //3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu

    List<Integer> yasList = json.getList("data.employee_age.findAll{it<30}");
    System.out.println(yasList);
  //  assertEquals( yasList.stream().reduce((t, u) -> t > u ? t : u),23);
        Collections.sort(yasList);
       // assertEquals(23, (int) yasList.get(yasList.size()-1));
        assertEquals((Integer) 23,yasList.get(yasList.size()-1));


    //4) Maası 350000 den büyük olan tüm employee name'leri ekrana yazdırın
    //     ve bunların içerisinde "Charde Marshall" olduğunu test edin

    List<String> salaryList = json.getList("data.findAll{it.employee_salary>350000}.employee_name");
assertTrue(salaryList.contains("Charde Marshall"));
}

}
