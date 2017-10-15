package com.veloracer.search.api.client;

import java.io.IOException;
import java.net.MalformedURLException;

public interface SearchAPIClient {

  String search(String searchParam) throws RuntimeException, MalformedURLException, IOException;

}
