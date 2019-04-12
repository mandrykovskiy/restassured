package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AlbumsTest {

    @Test(description = "3. Get third album (path parameter) and verify content length.")
    public void albumTest1() {
        RestAssured.baseURI = "http://localhost:3000/";
//        RestAssured.basePath = "/albums/3";

        Response response = given().contentType(ContentType.JSON)
                .pathParam("id", 3)
                .when()
                .get("/albums/{id}");

        Assert.assertTrue(response.getHeader("Content-Length").length() > 0);
        System.out.println("Content-Length = " + response.getHeader("Content-Length").length());
    }

    @Test(description = "4. Get all photos and verify that content length header is absent in response.")
    public void albumTest2() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/albums";

        Headers headers = given().expect().contentType(ContentType.JSON)
                .when()
                .get().headers();
        Assert.assertFalse(headers.hasHeaderWithName("Content-Length"));
//        for (Header h:headers) {
//            System.out.println(h.getName());
//        }
    }

    @Test(description = "5. Get non-existing album. Verify HTTP response status code.")
    public void albumTest3() {
        RestAssured.baseURI = "http://localhost:3000/";

        given().expect().contentType(ContentType.JSON)
                .when()
                .get("/albums/non-existing album")
                .then()
                .statusCode(404);
    }

}
