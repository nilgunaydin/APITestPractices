package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C10 extends DummyBaseUrl {
//http://dummy.restapiexample.com/api/v1/employees
//url ine bir istek gönderildiğinde
//Dönen response un
//Status kodunun 200,
//1)10’dan büyük tüm id’leri ekrana yazdırın ve
//10’dan büyük 14 id olduğunu,
//2)30’dan küçük tüm yaşları ekrana yazdırın ve
//bu yaşların içerisinde en büyük yaşın 23 olduğunu
//3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
//bunların içerisinde “Charde Marshall” olduğunu test edin

    @Test
    public void test(){
        spec02.pathParams("bir","api","iki","v1","uc","employees");

        Response rs = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");
        rs.prettyPrint();
        rs.then().statusCode(200);
        JsonPath json = rs.jsonPath();

        //1)10’dan büyük tüm id’leri ekrana yazdırın

        System.out.println(json.getList("data.id.findAll{it>10}"));

        //10’dan büyük 14 id olduğunu,
        assertEquals(14,json.getList("data.id.findAll{it>10}").size());


        //2)30’dan küçük tüm yaşları ekrana yazdırın ve
        //bu yaşların içerisinde en büyük yaşın 23 olduğunu
List<Integer> ages = json.getList("data.employee_age.findAll{it<30}");
        System.out.println(json.getList("data.employee_age.findAll{it<30}"));
      //  assertEquals(23,json.getList("data.employee_age.findAll{it<30}").stream().forEachOrdered(Comparator.<Object>reverseOrder()));
    //List<Integer> min = (List<Integer>) ages.stream().sorted(Comparator.reverseOrder()).limit(1);
   // assertEquals(Optional.of(23),min.get(0));
        Collections.sort(ages);
        assertEquals(23, (int) ages.get(ages.size()-1));
    }
}
