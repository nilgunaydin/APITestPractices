package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseUrl {
    public RequestSpecification specGMI;

    @Before
    public void setup(){

        specGMI = new RequestSpecBuilder().setBaseUri("http://www.gmibank.com/api").build();


    }


}
