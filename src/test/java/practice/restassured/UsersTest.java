package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import practice.restassured.models.users.UsersResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test(description = "6. Get all users. Verify HTTP response status code. Verify the 5 th user geo coordinates.")
    public void albumTest2() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/users";

        UsersResponse[] response = given().expect().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(UsersResponse[].class);

        System.out.println(Arrays.asList(response).get(4).getAddress().getGeo());
    }
}
