package com.ranga.rest.ride;

import com.ranga.model.CabRequest;
import com.ranga.model.Invoice;
import com.ranga.model.Reason;
import com.ranga.model.User;
import com.ranga.service.operations.ride.RideOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * This is a Generic Resource that Handles Requests from all Users
 *  1. Rider
 *  2. Captain
 *  3. Owner
 *
 *  All apis here are common to all
 *
 * Created by RANGA on 2/26/2017.
 */
public abstract class BaseRideResource<M extends User, ID extends Serializable> {

    protected RideOperations<M, ID> rideOperations;


    public BaseRideResource(RideOperations<M, ID> rideOperations) {
        this.rideOperations = rideOperations;
    }


    /**
     * This Functions in Three Ways
     * 1. Get All Cabs with Their of Arrival for a User
     * 2. Get All the Cab's with their Locations to rhe Owner, if he own multiple
     * 3. Customers Requesting For a Cab
     *
     * @param request
     * @return
     */
    @RequestMapping(
            value = "/view/cabs",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<M> viewAllCabsAvailable(@RequestBody CabRequest request) {
        return rideOperations.view(request);
    }


    /**
     * 1. User can Cancel a Ride
     * 2. Captain can Cancel a Ride
     *
     * @param reasonToCancel a Valid Reason Should Provide to cancel a Ride
     */
    @RequestMapping(
            value = "/cancel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Boolean cancelRide(@RequestBody Reason reasonToCancel) {
        return rideOperations.cancel(reasonToCancel);
    }

    /**
     * Gives all Rides Cancelled to
     * 1. User, 2. Captain and 3. Owner
     *
     * @param reasonToCancel
     * @return
     */
    @RequestMapping(
            value = "/view/rides/cancelled",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Integer getAllCancelledRide(@RequestBody Reason reasonToCancel) {
        return rideOperations.cancelled();
    }

    /**
     * Get all Completed Rides
     *
     * @return all Rides that completed successfully
     */
    @RequestMapping(
            value = "/view/rides/completed",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Integer getAlCompletedRides() {
        return rideOperations.completed();
    }

    /**
     * Get all Rides Inclusive Cancelled and Completed
     *
     * @return
     */
    @RequestMapping(
            value = "/view/rides",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Integer getAllRides() {
        return rideOperations.total();
    }


    /**
     * Finish a Ride
     *
     */
    @RequestMapping(
            value = "/finish",
            method = RequestMethod.PUT
    )
    @ResponseStatus(HttpStatus.OK)
    public void FinishARide() {
        rideOperations.finish();
    }


    /**
     * Get Invoice of the Ride
     *
     * @param id of the ride
     * @return
     */
    @RequestMapping(
            value = "/{id}/invoice",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Invoice directionChange(@PathVariable(value = "id")ID id) {
        return rideOperations.invoice(id);
    }


}
