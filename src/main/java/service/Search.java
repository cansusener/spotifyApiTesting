package service;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import spec.RequestSpec;
import spec.ResponseSpec;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Search  extends RequestSpec {

    public Search() {
        super("/v1/search");
    }

    public String findArtist(String artistName){

        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .queryParam("q",artistName)
                        .queryParam("type","artist")
                        .queryParam("limit","1")
                        .get()
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK))
                        .extract()
                        .response();


        List<String> item  = ((RestAssuredResponseImpl) response).response().path("artists.items.id");
        return item.get(0);

    }

}
