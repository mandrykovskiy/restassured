package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.restassured.models.todos.TodosResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class TodosTest {

    @Test(description = "8. Verify HTTP status code and completion status of the 10 th task.")
    public void todosTest1() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/todos";

        TodosResponse[] response = given().expect().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().as(TodosResponse[].class);

        Assert.assertTrue(Arrays.asList(response).get(9).getCompleted());
    }
}
