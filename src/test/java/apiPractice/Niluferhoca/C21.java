package apiPractice.Niluferhoca;


import apiPractice.Niluferhoca.pojos.BookingPojo;
import apiPractice.Niluferhoca.pojos.C21Pojo;
import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21 extends HerOkuAppBaseUrl {
    //https://restful-booker.herokuapp.com/booking

    //"firstname": "Selim",
    //"lastname": "Ak",
    //"totalprice": 15000,
    //"depositpaid": true,
    //"bookingdates": {
    //"checkin": "2020-09-09",
    //"checkout": "2020-09-21"

    //Status kodun 200 ve dönen response ‘un

    //"bookingid": 11,
    //"booking": {
    //"firstname": "Selim",
    //"lastname": "Ak",
    //"totalprice": 15000,
    //"depositpaid": true,
    //"bookingdates": {
    //"checkin": "2020-09-09",
    //"checkout": "2020-09-21"


    @Test
    public void testC21(){
spec05.pathParam("param","booking");
        BookingDatesPojo bookingdates = new BookingDatesPojo("2020-09-09","2020-09-21");
        BookingPojo requestData = new BookingPojo("Selim","Ak",15000,true,bookingdates);
        System.out.println(requestData);
    Response response = given().accept(ContentType.JSON).spec(spec05).auth().basic("admin","password123").when().body(requestData).post("/{param}");
    response.prettyPeek();
    C21Pojo actualData = response.as(C21Pojo.class);

    assertEquals(requestData.getFirstname(),actualData.getBooking().getFirstname());
    assertEquals(requestData.getLastname(),actualData.getBooking().getLastname());
    assertEquals(requestData.getTotalprice(),actualData.getBooking().getTotalprice());
    assertEquals(requestData.isDepositpaid(),actualData.getBooking().isDepositpaid());
    assertEquals(requestData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
    assertEquals(requestData.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
    }
}
