package practice.restassured.controllers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.apache.http.client.methods.RequestBuilder;
import practice.restassured.models.PetModel;

import static io.restassured.RestAssured.given;

public class PetController {

    public PetController(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key","1qa2ws3ed4rfvcxz")
                .setBaseUri("https://petstore.swagger.io/")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public PetModel addNewPet(PetModel pet) {
        return given()
                .body(pet)
                .when()
                .post()
                .then()
                .extract()
                .response()
                .as(PetModel.class);
    }
}
