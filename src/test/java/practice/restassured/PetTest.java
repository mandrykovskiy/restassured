package practice.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PetTest {

    @Test
    public void petTest1() {
        String idTestValue = RandomStringUtils.randomNumeric(5);
        RestAssured.given()
                .baseUri("https://petstore.swagger.io/")
                .basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key", "1qa2ws3ed4rfvcxz")
                .body("{\n" +
                        "  \"id\": " + idTestValue + ",\n" +
                        "  \"name\": \"dsfgsdfgs\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .when().post()
                .then()
                .body("id", Matchers.equalTo(Integer.valueOf(idTestValue)));
    }
}
