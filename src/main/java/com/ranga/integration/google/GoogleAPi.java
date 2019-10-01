package com.ranga.integration.google;

import com.ranga.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import java.util.Collections;

/**
 * Created by jabbars on 2/21/2017.
 */
@Service
@Named("GoogleAPi")
public class GoogleAPi implements GoogleOperations{

    private static final Logger logger = LoggerFactory.getLogger(GoogleAPi.class);
    private String googleApi;
    private String googleKey;

    public GoogleAPi( @Value("${integration.google.api}") String googleApi,
                      @Value("${integration.google.key}") String googleKey) {
        this.googleApi = googleApi;
        this.googleKey = googleKey;
    }


    public String searchPlace() {
        StringBuilder uri = new StringBuilder(googleApi);
        uri.append("/json?location=-33.8670522,151.1957362");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("key",googleKey);
        try {
            uri = uri.append("&key=").append(googleKey);
            responseEntity = restTemplate.getForEntity(uri.toString(),String.class);
        } catch (HttpClientErrorException he) {
            logger.error("Gateway Request Failed: {}", he.getLocalizedMessage());
            logger.error(he.getResponseBodyAsString());
            throw new BaseException(he.getLocalizedMessage());
        }
        assert responseEntity != null;
        return responseEntity.getBody();
    }
}
