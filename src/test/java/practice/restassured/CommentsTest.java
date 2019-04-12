package practice.restassured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CommentsTest {

    @Test(description = "2. Get all comments and verify response charset.")
    public void getAllCommentsTest() {
        given().baseUri("http://localhost:3000/")
                .basePath("/posts")
                .contentType(ContentType.JSON)
                .get()
                .then()
                .assertThat().statusCode(200).log().all()
                .assertThat().contentType(ContentType.JSON);
    }


}
