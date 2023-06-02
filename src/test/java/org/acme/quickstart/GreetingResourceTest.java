package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("hello local, This is awesome! this service is up by Quarkus :D"));
    }

    @Test
    public void testWithWrongEndpoint() {
        given()
                .when().get("/halloo")
                .then()
                .statusCode(404)
                .body(is("RESTEASY003210: Could not find resource for full path: http://localhost:8081/halloo"));
    }

}