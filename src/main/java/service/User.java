package service;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import spec.RequestSpec;
import spec.ResponseSpec;

import static io.restassured.RestAssured.given;

public class User extends RequestSpec {
    public User() {
        super("/v1/me");
    }

    public String getUserId(){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get()
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK))
                        .extract()
                        .response();

        String userId  = response.jsonPath().getString("id");
        System.out.println("User ID : " +userId);
        return userId;

    }

}
