package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.Test;
import practice.restassured.models.users.UsersResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test(description = "6. Get all users. Verify HTTP response status code. Verify the 5 th user geo coordinates.")
    public void usersTest1() {
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

    @Test(description = "9. Get user by street name. Verify HTTP status code. Verify street field of returned user\n" +
            "record.")
    public void usersTest2() {
//        RestAssured.baseURI = "http://localhost:3000/";
//        RestAssured.basePath = "/users";
        //todo get access token
//        UsersResponse usersRequest = new UsersController().usersPost(UsersRequest.builder()
//                .id(20)
//                .name("John")
//                .username("Smith")
//                .email("jsmith@zero.com")
//                .address(Address.builder()
//                        .street("Himichna")
//                        .suite("Apt. 556")
//                        .city("Lviv")
//                        .zipcode("79000")
//                        .geo(Geo.builder()
//                                .lat("-37.3159")
//                                .lng("81.1496")
//                                .build())
//                        .build())
//                .phone("+38099562155")
//                .website("jsmith.com")
//                .company(Company.builder()
//                        .name("DataArt")
//                        .catchPhrase("Multi-layered client-server neural-net")
//                        .bs("harness real-time e-markets")
//                        .build())
//                .build());
//
//        UsersResponse response = given().expect().contentType(ContentType.JSON)
//                .when()
//                .get(usersRequest.getId().toString())
//                .then()
//                .statusCode(200)
//                .extract().as(UsersResponse.class);
//
//        Assert.assertEquals(response.getAddress().getStreet(),usersRequest.getAddress().getCity());
        RestAssured.baseURI = "http://localhost:3000/";
//        RestAssured.basePath = "/users";
        UsersResponse[] response = given().expect().contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract().as(UsersResponse[].class);

        String streetName = Arrays.asList(response).get(RandomUtils.nextInt(0, response.length - 1)).getAddress().getStreet();
        System.out.println(Arrays.stream(response).filter(p -> p.getAddress().getStreet().equals(streetName)).findFirst().get().getName() + " lives on " + streetName + " street");
    }
}
