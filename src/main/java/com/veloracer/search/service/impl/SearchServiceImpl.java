package com.veloracer.search.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veloracer.search.api.client.SearchAPIClient;
import com.veloracer.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchAPIClient searchClient;

	@Override
	public String getData(String searchTerm) throws MalformedURLException, RuntimeException, IOException {
		
		// Just in case 
		return searchClient.artistSearch(searchTerm);
		
	}

}



