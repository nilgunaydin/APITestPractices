package get_http_request;

import base_url.DummyBaseUrl;
import base_url.ReqresinBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyBaseUrl {
    /*
   http://dummy.restapiexample.com/api/v1/employees url'inde bulunan

  1) Butun calisanlarin isimlerini consola yazdıralim
  2) 3. calisan kisinin ismini konsola yazdıralim
  3) Ilk 5 calisanin adini konsola yazdiralim
  4) En son calisanin adini konsola yazdiralim
*/
@Test
    public void test8(){
spec02.pathParams("par1","api","par2","v1","par3","employees");

    Response rs = given().spec(spec02).when().get("/{par1}/{par2}/{par3}");
    rs.prettyPrint();
    //1) Butun calisanlarin isimlerini consola yazdıralim
    JsonPath json = rs.jsonPath();
    System.out.println(json.getString("data.employee_name"));

    //  2) 3. calisan kisinin ismini konsola yazdıralim
    System.out.println(json.getString("data.employee_name[2]"));

    //  3) Ilk 5 calisanin adini konsola yazdiralim
    System.out.println("**************** ilk 5 calisan 1.yol *****************");

json.getList("data.employee_name").stream().limit(5).forEach(System.out::println);
    System.out.println("**************** ilk 5 calisan 2.yol *****************");
    System.out.println(json.getString("data.employee_name[0,1,2,3,4]"));
    //  4) En son calisanin adini konsola yazdiralim
  //  System.out.println(json.getList("data.employee_name").get(json.getList("data.employee_name").size() - 1));
    System.out.println(json.getString("data.employee_name[-1]"));
}
}
