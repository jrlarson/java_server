package com.veloracer.search.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.veloracer.search.service.SearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SearchController.class, secure = false)
public class SearchControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private SearchService searchService;

  String mockResponse = new String("{"
    + "'resultCount':4,"
    + "'results': ["
    + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Brooks de Wetter-Smith', 'artistLinkUrl':'https://itunes.apple.com/us/artist/brooks-de-wetter-smith/id166008982?uo=4', 'artistId':166008982, 'amgArtistId':1290411, 'primaryGenreName':'Classical', 'primaryGenreId':5}," 
    + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/wetter/id405254940?uo=4', 'artistId':405254940, 'amgArtistId':3337309, 'primaryGenreName':'K-Pop', 'primaryGenreId':51}, "
    + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Edvin Diskin Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/edvin-diskin-wetter/id1091652097?uo=4', 'artistId':1091652097, 'primaryGenreName':'Contemporary Folk', 'primaryGenreId':1063}," 
    + "{'wrapperType':'artist', 'artistType':'Artist', 'artistName':'Carl Wetter', 'artistLinkUrl':'https://itunes.apple.com/us/artist/carl-wetter/id1015112731?uo=4', 'artistId':1015112731, 'primaryGenreName':'Rock', 'primaryGenreId':21}]"
    + "}");

  @Test
  public void searchForMusicArtist() throws Exception {

    Mockito.when(
        searchService.getData(Mockito.anyString())).thenReturn(mockResponse);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
        "/data").param("search", "weter").accept(
        MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = mockResponse;

    JSONAssert.assertEquals(expected, result.getResponse()
        .getContentAsString(), false);
  }

}