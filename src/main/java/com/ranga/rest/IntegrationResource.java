package com.ranga.rest;

import com.ranga.integration.google.GoogleOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * This Resource is Used to Communicate with Other Services
 * EX. Google Maps, Location
 * <p>
 * Created by jabbars on 2/21/2017.
 */
@RestController("IntegrationResource")
@RequestMapping(value = "v1/api/integration")
public class IntegrationResource {

    @Inject
    @Named("GoogleAPi")
    protected GoogleOperations googleOperations;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Object findAll() {
        return googleOperations.searchPlace();
    }
}
