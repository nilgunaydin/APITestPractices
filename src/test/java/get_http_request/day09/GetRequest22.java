package get_http_request.day09;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GetRequest22 extends HerOkuAppBaseUrl {
    /*
https://restful-booker.herokuapp.com/booking/47
       {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 500,
           "depositpaid": true,
           "bookingdates": {
               "checkin": "2022-02-01",
               "checkout": "2022-02-11"
          }
       }
1) JsonPhat
2) De-Serialization
*/
    @Test
public void test22(){

            //1) URL OLUSTUR
            spec05.pathParams("first", "booking", "second", 40);

            //2) EXPECTED DATA OLUSTUR
            HerOkuAppTestData expectedObje = new HerOkuAppTestData();

            HashMap<String , Object> expectedTestDataMap = expectedObje.setUpTestData();

            System.out.println("TEST DATA iCiNDEKi EXPECTED DATA: " + expectedTestDataMap);
            // {firstname=Ali,
            // bookingdates={
            //               checkin=2022-02-01,
            //               checkout=2022-02-11},
            // totalprice=500,
            // depositpaid=true,
            // lastname=Can}

        Response rs = given().spec(spec05).when().get("/{first}/{second}");
        rs.prettyPrint();
HashMap<String, Object> actualData = rs.as(HashMap.class);

    //   assertEquals(expectedTestDataMap.get("firstname"),actualData.get("firstname"));
    //   assertEquals(expectedTestDataMap.get("lastname"),actualData.get("lastname"));
    //   assertEquals(expectedTestDataMap.get("totalprice"),actualData.get("totalprice"));
    //   assertEquals(expectedTestDataMap.get("depositpaid"),actualData.get("depositpaid"));
    //   assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
    //   assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));


    //   assertEquals(expectedTestDataMap,actualData);

        assertTrue(actualData.entrySet().containsAll(expectedTestDataMap.entrySet()));

        }
    }



