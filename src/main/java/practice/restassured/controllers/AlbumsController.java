package practice.restassured.controllers;

import io.restassured.http.ContentType;
import practice.restassured.models.albums.AlbumsRequest;
import practice.restassured.models.albums.AlbumsResponse;

import static io.restassured.RestAssured.given;

public class AlbumsController extends Client {

    public AlbumsResponse[] albumsGet() {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .get()
                .then()
                .assertThat().statusCode(200).log().all()
                .assertThat().contentType(ContentType.JSON)
                .extract().as(AlbumsResponse[].class);
    }

    public AlbumsResponse albumsPost(AlbumsRequest request) {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .body(request)
                .log().all()
                .post()
                .then()
                .assertThat().statusCode(201).log().all()
                .extract().as(AlbumsResponse.class);
    }

    public AlbumsResponse albumsPut(int id, AlbumsRequest request) {
        return given().spec(requestSpecification)
                .basePath(String.format("/comments/%s", id))
                .body(request)
                .put()
                .then()
                .assertThat().statusCode(200).log().all()
                .and()
                .extract().as(AlbumsResponse.class);
    }

    public AlbumsResponse albumsDelete(AlbumsRequest request) {
        return given().spec(requestSpecification)
                .basePath("/comments")
                .body(request)
                .delete()
                .then()
                .assertThat().statusCode(204).log().all()
                .and()
                .extract().as(AlbumsResponse.class);
    }
}
