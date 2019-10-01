package com.ranga.rest.crud;

import com.ranga.service.operations.crud.BaseCrudOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by RANGA on 1/23/2017.
 */
public abstract class BaseResource<L, ID extends Serializable> {

    protected BaseCrudOperations<L,ID> userOperations;


    public BaseResource(BaseCrudOperations<L, ID> userOperations) {
        this.userOperations = userOperations;
    }

    /**
     * Create
     *
     * @param request
     * @return
     */
    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public L create(@RequestBody L request) {
        return userOperations.create(request);
    }

    /**
     * Update
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public L update(@PathVariable(value = "id") ID id,
                    @RequestBody L request) {
        return userOperations.update(id, request);
    }

    /**
     * Find All
     *
     * @return
     */
    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<L> findAll() {
        return userOperations.findAll();
    }

    /**
     * Find One record
     *
     * @param id
     * @return
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public L find(@PathVariable("id") ID id) {
        return userOperations.find(id);
    }

    /**
     * Delete data
     *
     * @param id
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") ID id) {
        userOperations.delete(id);
    }

}
