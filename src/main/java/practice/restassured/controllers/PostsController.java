package practice.restassured.controllers;

import practice.restassured.models.posts.PostsRequest;
import practice.restassured.models.posts.PostsResponse;

import static io.restassured.RestAssured.given;

public class PostsController extends Client {

    public PostsResponse[] postsGet() {
        return given().spec(requestSpecification)
                .basePath("/posts")
                .get()
                .then()
                .assertThat().statusCode(200)
                .extract().as(PostsResponse[].class);
    }

    public PostsResponse postsPost(PostsRequest postRequest) {
        return given().spec(requestSpecification)
                .basePath("/posts")
                .body(postRequest)
                .log().all()
                .post()
                .then()
                .assertThat().statusCode(201).log().all()
                .extract().as(PostsResponse.class);
    }

    public PostsResponse postsPut(int id, PostsRequest postRequest) {
        return given().spec(requestSpecification)
                .basePath(String.format("/posts/%s", id))
                .body(postRequest)
                .put()
                .then()
                .assertThat().statusCode(200).log().all()
                .and()
                .extract().as(PostsResponse.class);
    }

    public PostsResponse postsDelete(PostsRequest postRequest) {
        return given().spec(requestSpecification)
                .basePath("/posts")
                .body(postRequest)
                .delete()
                .then()
                .assertThat().statusCode(204).log().all()
                .and()
                .extract().as(PostsResponse.class);
    }

}
