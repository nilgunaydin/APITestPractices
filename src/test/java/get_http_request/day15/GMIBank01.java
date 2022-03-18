package get_http_request.day15;

import base_url.GMIBankBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.WriteToText;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class GMIBank01 extends GMIBankBaseUrl {
    /*
    http://www.gmibank.com/api/tp-customers end point'ine
    request gönderin

     2) Tüm Customer SSN lerini ekrana yazdırın.

     3) Tüm Customer SSN lerini text dosyası olarak kaydedin

     4) Olusturduğunuz text dosyasından  SSNleri okuyarak
        "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın
     */
    @Test
    public void test() throws JsonProcessingException {
        Customer [] customers;


specGMI.pathParams("par1","tp-customers");

        Response response=given().headers("Authorization","Bearer "+generateToken())
                .when().spec(specGMI).get("/{par1}").then().contentType(ContentType.JSON).extract().response();

      //  response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        customers = obj.readValue(response.asString(),Customer[].class);
     //   System.out.println("customers = " + customers[2]);


/**     1) Tüm Customer bilgilerini ekrana yazdırırn. */
        for (int i = 0; i < customers.length ; i++) {
           System.out.println(i+1 + ". "+customers[i]);
        }

        /**      1) Tüm Customer bilgilerini ekrana yazdırırn. */
        for (int i = 0; i < customers.length ; i++) {
            System.out.println(i+1 + ". Customer SSN: "+customers[i].getSsn());
        }
        /**      3) Tüm Customer SSN lerini text dosyası olarak kaydedin */

String fileName= "src/test/java/get_http_request/day15/GMIBankTextData/SNNList.txt";
        WriteToText.saveSSNData(fileName,customers);

        /** 4) Olusturduğunuz text dosyasından  SSNleri okuyarak
         "531-95-8437", "049-43-2360", "123-34-3434" SSNlerinin olduğunu doğrulayın */



         }
}
