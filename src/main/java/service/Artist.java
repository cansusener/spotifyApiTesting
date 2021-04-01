package service;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Artist extends RequestSpec {

    public Artist() {
        super("/v1/artists");
    }


    public List<String>  getTopTracks(String artistId){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("market","TR")
                        .get("/{id}/top-tracks",artistId)
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK))
                        .extract()
                        .response();
        List<String> tracks  = ((RestAssuredResponseImpl) response).response().path("tracks.uri");
        return tracks;
    }


}
