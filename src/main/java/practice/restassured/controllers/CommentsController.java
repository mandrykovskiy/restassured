package practice.restassured.controllers;

import io.restassured.http.ContentType;
import practice.restassured.models.comments.CommentsRequest;
import practice.restassured.models.comments.CommentsResponse;

import static io.restassured.RestAssured.given;

public class CommentsController extends Client {

    public CommentsResponse[] commentsGet() {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .get()
                .then()
                .assertThat().statusCode(200).log().all()
                .assertThat().contentType(ContentType.JSON)
                .extract().as(CommentsResponse[].class);
    }

    public CommentsResponse commentsPost(CommentsRequest request) {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .body(request)
                .log().all()
                .post()
                .then()
                .assertThat().statusCode(201).log().all()
                .extract().as(CommentsResponse.class);
    }

    public CommentsResponse commentsPut(int id, CommentsRequest request) {
        return given().spec(requestSpecification)
                .basePath(String.format("/comments/%s", id))
                .body(request)
                .put()
                .then()
                .assertThat().statusCode(200).log().all()
                .and()
                .extract().as(CommentsResponse.class);
    }

    public CommentsResponse commentsDelete(CommentsRequest request) {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .body(request)
                .delete()
                .then()
                .assertThat().statusCode(204).log().all()
                .and()
                .extract().as(CommentsResponse.class);
    }

}
