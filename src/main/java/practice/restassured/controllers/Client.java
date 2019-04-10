package practice.restassured.controllers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Client {
    public RequestSpecBuilder builder;
    public RequestSpecification requestSpecification;

    Client(){
        builder = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON);
        requestSpecification = builder.build();
    }
}
