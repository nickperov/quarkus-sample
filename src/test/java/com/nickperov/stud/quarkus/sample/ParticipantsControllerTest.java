package com.nickperov.stud.quarkus.sample;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.instanceOf;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class ParticipantsControllerTest {

    @Test
    public void testGetParticipantEndpoint() {
        given()
                .when().get("/participants?id=1")
                .then()
                .statusCode(200)
                .body(instanceOf(String.class));
    }

}