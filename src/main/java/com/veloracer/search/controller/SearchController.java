package com.veloracer.search.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veloracer.search.service.SearchService;

@RestController
public class SearchController {
	
	private static final Log log = LogFactory.getLog(SearchController.class);
	
	public static final String SEARCH_PATH = "/data";

	@Autowired
	private SearchService searchService;
	
	/**
	 * This method will return all results for the given search term.
	 * If no results are found, an empty list will be returned.
	 * 
	 * @param searchTerm The value used to search on
	 *  
	 * @return {@link java.lang.String}&lt;
	 * @throws IOException 
	 * @throws RuntimeException 
	 * @throws MalformedURLException 
	 *         
	 */
	@ResponseBody
	@RequestMapping(value = SEARCH_PATH, method = RequestMethod.GET, produces = { "application/json" })
	public String data(@RequestParam String search) throws MalformedURLException, RuntimeException, IOException {
		
		String response = searchService.getData(search);
		log.debug(response);
		
		return response;
	}

}
	