package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.restassured.controllers.PostsConroller;
import practice.restassured.models.posts.PostsRequest;
import practice.restassured.models.posts.PostsResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class PostsTest {

    @Test
    public void getAllPostsTest1() {
        given()
                .baseUri("http://localhost:3000/")
                .basePath("/posts")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat().contentType(ContentType.JSON)
                .statusCode(200).log().all();
    }

    @Test
    public void getAllPostTest() {
        RestAssured.baseURI = "http://localhost:3000/";
        RestAssured.basePath = "/posts";

        given().contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat().contentType(ContentType.JSON)
                .statusCode(200).log().all();
    }

    @Test
    public void postsPostTest() {
        PostsRequest request = PostsRequest.builder()
                .id(RandomUtils.nextInt(0, 9000))
                .body("PostBody")
                .title("PostTilte")
                .userId(RandomUtils.nextInt(0, 100))
                .build();
        PostsResponse response = new PostsConroller().postsPost(request);
        PostsResponse[] response2 = new PostsConroller().postsGet();

        Assert.assertTrue(Arrays.asList(response2).contains(response));
    }

    @Test
    public void postsBodyPutTest() {
        int postId = RandomUtils.nextInt(0, 9000);
        String postBody = RandomStringUtils.randomAlphabetic(5);
        String newPostBody = RandomStringUtils.randomAlphabetic(5);
        PostsRequest createPostRequest = PostsRequest.builder()
                .id(postId)
                .body(postBody)
                .title("PostTitle")
                .userId(RandomUtils.nextInt(0, 100))
                .build();
        PostsResponse response = new PostsConroller().postsPost(createPostRequest);
        PostsRequest putRequest = PostsRequest.builder()
                .body(newPostBody)
                .build();
        PostsResponse putResponse = new PostsConroller().postsPut(postId, putRequest);

        Assert.assertEquals(newPostBody, putResponse.getBody());
    }


}
