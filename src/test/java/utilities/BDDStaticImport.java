package utilities;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.junit.Test;

public class BDDStaticImport {
    @Test
    public void test01(){

        // Given
        given()
                .baseUri("http://dummy.restapiexample.com/api/v1")
                // When
                .when()
                .get("/employees")
                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                // To verify number of employees
                .body("data.id", hasSize(24))
                // To verify first employee's age
                .body("data[0].employee_age", equalTo(61));
    }
}