package com.veloracer.search.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import com.veloracer.search.api.client.SearchAPIClient;
import com.veloracer.search.service.impl.SearchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

  String mockResponse = new String("{"
      + "'resultCount':4,"
      + "'results': ["
      + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Brooks de Wetter-Smith', 'artistLinkUrl':'https://itunes.apple.com/us/artist/brooks-de-wetter-smith/id166008982?uo=4', 'artistId':166008982, 'amgArtistId':1290411, 'primaryGenreName':'Classical', 'primaryGenreId':5}," 
      + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/wetter/id405254940?uo=4', 'artistId':405254940, 'amgArtistId':3337309, 'primaryGenreName':'K-Pop', 'primaryGenreId':51}, "
      + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Edvin Diskin Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/edvin-diskin-wetter/id1091652097?uo=4', 'artistId':1091652097, 'primaryGenreName':'Contemporary Folk', 'primaryGenreId':1063}," 
      + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Carl Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/carl-wetter/id1015112731?uo=4', 'artistId':1015112731, 'primaryGenreName':'Rock', 'primaryGenreId':21}]"
      + "}");

  @Mock
  private SearchAPIClient searchAPIClient;

  @InjectMocks
  private SearchServiceImpl searchService = new SearchServiceImpl();

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
   
  @Test
  public void searchForMusicArtist() throws Exception {
    
    Mockito.when(
        searchAPIClient.search("weter")).thenReturn(mockResponse);

    String result = searchService.getData("weter");

    String expected = mockResponse;

    JSONAssert.assertEquals(expected, result, false);

}
  
};
