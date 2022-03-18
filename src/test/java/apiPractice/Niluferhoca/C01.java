package apiPractice.Niluferhoca;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01 {
    //https://restful-booker.herokuapp.com/booking/3 adresine bir request
    //gonderildiginde donecek cevap(response) icin

    // HTTP status kodunun 200

    // Content Type’in Json

    //Ve Status Line’in HTTP/1.1 200 OK

    //Oldugunu test edin.
@Test
    public void test(){
 String url = "https://restful-booker.herokuapp.com/booking/3";

Response rs = given().when().get(url);
rs.prettyPeek();
rs.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
}
}
