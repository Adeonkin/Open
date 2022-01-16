package forApi.dataForApi.specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Specification {

    public static RequestSpecification requestSpec() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in/api/")
            .setContentType("application/json")
            .build();
        return requestSpecification;
    }

    public static ResponseSpecification responseSpec200() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
        return responseSpec;
    }

    public static ResponseSpecification responseSpec201() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
        return responseSpec;
    }

    public static void installSpec (RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }
}
