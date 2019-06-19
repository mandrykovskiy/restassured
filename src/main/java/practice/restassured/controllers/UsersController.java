package practice.restassured.controllers;

import io.restassured.http.ContentType;
import practice.restassured.models.users.UsersRequest;
import practice.restassured.models.users.UsersResponse;

import static io.restassured.RestAssured.given;

public class UsersController extends Client {

    public UsersResponse[] usersGet() {
        return given().spec(requestSpecification)
                .basePath("/users")
                .get()
                .then()
                .assertThat().statusCode(200).log().all()
                .assertThat().contentType(ContentType.JSON)
                .extract().as(UsersResponse[].class);
    }

    public UsersResponse[] usersGet(String id) {
        return given().spec(requestSpecification)
                .basePath(String.format("/users/%s", id))
                .get()
                .then()
                .assertThat().statusCode(200).log().all()
                .assertThat().contentType(ContentType.JSON)
                .extract().as(UsersResponse[].class);
    }

    public UsersResponse usersPost(UsersRequest request) {
        return given().auth().basic("olivier@mail.com","bestPassw0rd").spec(requestSpecification)
                .basePath("/users")
                .body(request)
                .log().all()
                .post()
                .then()
                .log().all()
//                .assertThat().statusCode(200).log().all()
                .extract().as(UsersResponse.class);
    }

    public UsersResponse usersPut(int id, UsersRequest request) {
        return given().spec(requestSpecification)
                .basePath(String.format("/users/%s", id))
                .body(request)
                .put()
                .then()
                .assertThat().statusCode(200).log().all()
                .and()
                .extract().as(UsersResponse.class);
    }

    public UsersResponse usersDelete(UsersRequest request) {
        return given().spec(requestSpecification)
                .basePath("/users")
                .body(request)
                .delete()
                .then()
                .assertThat().statusCode(204).log().all()
                .and()
                .extract().as(UsersResponse.class);
    }

}
