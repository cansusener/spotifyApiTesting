package service;

import helper.Helper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;

import static io.restassured.RestAssured.given;

public class CreatePlayList extends RequestSpec {
    public CreatePlayList() {
        super("/v1/users");
    }
    public String createPlayList(String userId){

        JSONObject body = Helper.readJsonFile("playListBody");

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .body(body.toString())
                        .post("/{userId}/playlists",userId)
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_CREATED))
                        .extract()
                        .response();

        String playlistId =  response.jsonPath().getString("id");
        System.out.println("Oluşturulan playlist ID : "+playlistId);
        return playlistId;
    }


}
