package tests;

import forApi.dataForApi.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import forApi.dataForApi.specification.Specification;
import forApi.dataForApi.stepsForApi.CheckJson;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void getTest() {
        CheckJson checkJson = new CheckJson();
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec200());
        Data listUser = given()
                .when()
                .get("users?page=2")
                .then()
                .extract().as(Data.class);
        checkJson.checkJsonFieldsNotNull(listUser);
    }

    @Test
    public void postTest() {
        CheckJson checkJson = new CheckJson();
        Human postRequestData = new Human("morpheus", "leader");
        Specification.installSpec(Specification.requestSpec(), Specification.responseSpec201());
        Response response = given()
                .body(postRequestData)
                .when()
                .post("users")
                .then()
                .log().all()
                .extract().response();
        JsonPath jsonResponse = response.jsonPath();
        checkJson.checkEqualsPeople(jsonResponse, postRequestData);
    }
}