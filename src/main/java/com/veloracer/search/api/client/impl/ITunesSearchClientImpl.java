package com.veloracer.search.api.client.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.veloracer.search.api.client.SearchAPIClient;

@Service
@PropertySource("classpath:application.properties")
public class ITunesSearchClientImpl implements SearchAPIClient {

  @Value("${ITunesSearchEndpoint}")
  private String searchURL;

  @Override
  public String search(String searchParam) throws RuntimeException, MalformedURLException, IOException {

    StringBuffer response = new StringBuffer("");

    try {

      URL url = new URL(searchURL.concat(searchParam));
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");

      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

      String streamInput;
      while ((streamInput = reader.readLine()) != null) {
        response.append(streamInput);
        System.out.println(streamInput);
      }
      conn.disconnect();

    } catch (MalformedURLException e) {
      throw (e);
    } catch (IOException e) {
      throw (e);
    }

    return response.toString();

  }

}
