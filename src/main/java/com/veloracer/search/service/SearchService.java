package com.veloracer.search.service;

import java.io.IOException;
import java.net.MalformedURLException;

public interface SearchService {

  String getData(String searchTerm) throws MalformedURLException, RuntimeException, IOException;

}
