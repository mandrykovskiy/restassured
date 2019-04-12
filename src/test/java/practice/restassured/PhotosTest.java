package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PhotosTest {

    @Test(description = "5. Verify response time for photos endpoint is less than 10 seconds.")
    public void albumTest2() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/photos";

        given().expect().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .time(lessThan(10000L));
    }
}
