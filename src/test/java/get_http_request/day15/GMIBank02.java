package get_http_request.day15;

import base_url.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import utilities.WriteToText;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class GMIBank02 extends GMIBankBaseUrl {
     /*
http://www.gmibank.com/api/tp-customers end point'ine get
request gönderin
 1) Tüm Customer bilgilerini ekrana yazdırırn.

 2) Tüm Customer emaillerini ekrana yazdırın.

 3) Tüm Customer emaillerini text dosyası olarak kaydedin

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
    }
}
