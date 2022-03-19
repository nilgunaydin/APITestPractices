package get_http_request.day15;

import base_url.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import utilities.WriteToText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;
import static utilities.ReadText.readCustomerEmailList;

public class GMIBank02 extends GMIBankBaseUrl {
     /*
http://www.gmibank.com/api/tp-customers end point'ine get
request gönderin

 1) Tüm Customer emaillerini ekrana yazdırın.

 2) Tüm Customer emaillerini text dosyası olarak kaydedin

 3) dönen reponse'ta winonaabernathy@gmail.com, MerrillPrice@gmail.com, LesleyKing@gmail.com
        E-maillerinin olduğunu doğrulayın
 */

    @Test
    public void test() throws IOException {

        Customer [] customers;

        specGMI.pathParams("par1","tp-customers");

        Response response=given().headers("Authorization","Bearer "+generateToken())
                .when().spec(specGMI).get("/{par1}").then().contentType(ContentType.JSON).extract().response();

        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(),Customer[].class);

        for (int i = 0; i < customers.length ; i++) {

            System.out.println(i+1+". Customer Email = " + customers[i].getEmail());
        }
        String fileName= "src/test/java/get_http_request/day15/GMIBankTextData/EmailList.txt";
        WriteToText.saveEmailData(fileName,customers);

        // 3) dönen reponse'ta winonaabernathy@gmail.com, MerrillPrice@gmail.com, LesleyKing@gmail.com
        //        E-maillerinin olduğunu doğrulayın

        List<String> expected = new ArrayList<String>(Arrays.asList("winonaabernathy@gmail.com",
                "MerrillPrice@gmail.com", "LesleyKing@gmail.com"));
        List<String> actual = readCustomerEmailList(fileName);
    assertTrue(actual.containsAll(expected));
    }
}
