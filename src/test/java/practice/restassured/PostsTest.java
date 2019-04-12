package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostsTest {

//    @Test
//    public void getAllPostsTest1() {
//        given()
//                .baseUri("http://localhost:3000/")
//                .basePath("/posts")
//                .contentType(ContentType.JSON)
//                .when()
//                .get()
//                .then()
//                .assertThat().contentType(ContentType.JSON)
//                .statusCode(200).log().all();
//    }

    @Test(description = "1. Get all posts. Verify HTTP response status code and content type.")
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

//    @Test
//    public void postsPostTest() {
//        UsersRequest request = UsersRequest.builder()
//                .id(RandomUtils.nextInt(0, 9000))
//                .body("PostBody")
//                .title("PostTilte")
//                .userId(RandomUtils.nextInt(0, 100))
//                .build();
//        UsersResponse response = new PostsController().postsPost(request);
//        UsersResponse[] response2 = new PostsController().postsGet();
//
//        Assert.assertTrue(Arrays.asList(response2).contains(response));
//    }
//
//    @Test
//    public void postsBodyPutTest() {
//        int postId = RandomUtils.nextInt(0, 9000);
//        String postBody = RandomStringUtils.randomAlphabetic(5);
//        String newPostBody = RandomStringUtils.randomAlphabetic(5);
//        UsersRequest createPostRequest = UsersRequest.builder()
//                .id(postId)
//                .body(postBody)
//                .title("PostTitle")
//                .userId(RandomUtils.nextInt(0, 100))
//                .build();
//        UsersResponse response = new PostsController().postsPost(createPostRequest);
//        UsersRequest putRequest = UsersRequest.builder()
//                .body(newPostBody)
//                .build();
//        UsersResponse putResponse = new PostsController().postsPut(postId, putRequest);
//
//        Assert.assertEquals(newPostBody, putResponse.getBody());
//    }
}
