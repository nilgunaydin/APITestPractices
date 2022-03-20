package apiPractice.Niluferhoca;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class C08 extends DummyBaseUrl {
    //http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
    //1) Butun calisanlarin isimlerini consola yazdıralim
    //2) 3. calisan kisinin ismini konsola yazdıralim
    //3) Ilk 5 calisanin adini konsola yazdiralim
    //4) En son calisanin adini konsola yazdiralim
@Test
    public void test(){

    spec02.pathParams("bir","api","iki","v1","uc","employees");

    Response rs = given().spec(spec02).when().get("/{bir}/{iki}/{uc}");
    //rs.prettyPrint();

    JsonPath json = rs.jsonPath();
    List<String> ilk5 = json.getList("data.findAll{it.id<6}.employee_name");
    System.out.println("ilk5 = " + ilk5);





}}
