package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {
    public RequestSpecification spec02;

    @Before
    public void setup(){

        spec02 = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();

    }
}
