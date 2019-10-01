package com.ranga.rest.ride;

import com.ranga.model.CabRequest;
import com.ranga.model.Rider;
import com.ranga.service.operations.ride.RiderOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

/**
 * This Resource Handles the Requests from a Rider,
 * Which are specifically meant for Him
 * <p>
 * Created by RANGA on 2/26/2017.
 */
@RestController("RiderRideViewResource")
@RequestMapping(value = "v1/api/rider/ride")
public class RiderResource extends BaseRideResource<Rider, UUID> {


    protected RiderOperations riderOperations;

    @Inject
    public RiderResource(RiderOperations riderOperations) {
        super(riderOperations);
        this.riderOperations = riderOperations;
    }

    /**
     * Places a request for a New Cab
     *
     * @param id
     * @param request
     */
    @RequestMapping(
            value = "/{id}/request",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void bookACab(@PathVariable("id") String id,
                         @RequestBody CabRequest request) {
        riderOperations.request(UUID.fromString(id), request);
    }

    /**
     * (NEW)
     * When we display all available Cabs with their ETA's
     *
     * User can select in any one of them
     *  (or)
     * He can Just depend on System to Pick one for Him
     * IF he selects a CAB from the List, Just Pick and Send
     *
     * @param id
     * @param cabID
     * @param request
     */
    @RequestMapping(
            value = "/{id}/request/cab/{cabID}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void bookACab(@PathVariable("id") String id,
                         @PathVariable("cabID") String cabID,
                         @RequestBody CabRequest request) {
        riderOperations.request(UUID.fromString(id), UUID.fromString(cabID), request);
    }


    /**
     * Books cab at the requested time and Place
     *
     * @param id
     * @param request
     */
    @RequestMapping(
            value = "/{id}/request/later",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void bookCabLater(@PathVariable("id") String id,
                             @RequestBody CabRequest request) {
        riderOperations.requestLater(UUID.fromString(id), request);
    }

    /**
     * (NEW)
     * This is My Idea to Plan a Ride. The Main motivation behind this is,
     * we Have some scenarios, where we can book a Cab at the time booking some other events
     * <p>
     * Location -> Cab -> Movies/Event -> Cab -> Location
     * Location -> Cab -> Restaurant   -> Cab -> Movies/Event -> Cab -> Location
     * Location -> Cab -> Airport-> Take Flight -> Airport -> Cab -> Location (As Careem
     * <p>
     * Plan a Ride, we can achieve by adding Ticket booking feature(ECommerce).
     * By this Careem can fulfill all transportation needs of a Customer.
     * ***(CAB + TICKET_BOOKING[Movie,Flight,Event,Boat etc.,]) ***
     * <p>
     * For More details read "CareemCaseStudy.pptx"
     *
     * @param id
     * @param request
     */
    @RequestMapping(
            value = "/{id}/plan",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void planARide(@PathVariable("id") String id,
                          @RequestBody CabRequest request) {
        riderOperations.planRide(UUID.fromString(id), request);
    }


}
