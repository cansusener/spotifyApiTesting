import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import spec.ResponseSpec;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ApiTesting extends BaseTest {

    @Test
        public void exampleApiTest(){

            String artistId = search.findArtist("Sezen Aksu");
            List<String> trackList = artist.getTopTracks(artistId);
            String userId = user.getUserId();
            String playlistId = createPlaylist.createPlayList(userId);
            Assert.assertEquals(playlists.getPlaylistName(playlistId),"Sezen Aksu");
            Assert.assertEquals( 0,playlists.getPlaylistSize(playlistId));

            List<String> popList = new ArrayList<String>();
            for(int i=0 ; i<3 ; i++){
                popList.add(trackList.get(i));
            }

            playlists.addTracks(popList,playlistId);
            Assert.assertEquals( playlists.getPlaylistSize(playlistId),3);

            playlists.deleteTrack(trackList.get(2),playlistId);
            Assert.assertEquals(playlists.getPlaylistSize(playlistId),2);



    }

}
