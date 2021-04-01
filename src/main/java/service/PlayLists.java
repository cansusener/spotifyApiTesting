package service;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import spec.RequestSpec;
import spec.ResponseSpec;
import helper.Helper;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PlayLists extends RequestSpec {


    public PlayLists(String endPoint) {
        super(endPoint);
    }

    public PlayLists() {
        super("/v1/playlists");
    }

    public int getPlaylistSize(String playlistId){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get("/{playlist_id}/tracks",playlistId)
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK))
                        .extract()
                        .response();
        List<Object> trackList =  response.jsonPath().getList("items");
        System.out.println("Listedeki şarkı sayısı : "+trackList.size());
        return trackList.size();
    }

    public void addTracks(List<String> tracks, String playlistId){

        for(String track : tracks){

            given()
                    .spec(super.getRequestSpecification())
                    .queryParam("uris",track)
                    .post("/{playlist_id}/tracks",playlistId)
                    .then()
                    .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_CREATED));
            System.out.println(track+" : şarkısı eklendi");
        }

    }

    public void deleteTrack(String trackUri, String playlistId){
        JSONObject deleteBody = Helper.readJsonFile("deleteTrackBody");
        deleteBody.getJSONArray("tracks").getJSONObject(0).put("uri",trackUri);

        given()
                .spec(super.getRequestSpecification())
                .body(deleteBody.toString())
                .delete("/{playlist_id}/tracks",playlistId)
                .then()
                .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK));
        System.out.println(trackUri+" : şarkısı listeden silindi");
    }

    public String getPlaylistName(String playlistId){
        Response response =
                given()
                        .spec(super.getRequestSpecification())
                        .get("/{playlist_id}",playlistId)
                        .then()
                        .spec(ResponseSpec.checkStatusCode(HttpStatus.SC_OK))
                        .extract()
                        .response();

        String playlistName = response.jsonPath().getString("name");
        return playlistName;
    }

}
