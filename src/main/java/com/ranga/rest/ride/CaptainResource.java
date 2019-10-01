package com.ranga.rest.ride;

import com.ranga.model.Captain;
import com.ranga.model.TrackDetails;
import com.ranga.service.operations.ride.CaptainOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.UUID;

/**
 * This Resource Handles the Requests from a Captain,
 * Which are specifically meant for Him
 * <p>
 * Created by RANGA on 2/26/2017.
 */
@RestController("CaptainRideViewResource")
@RequestMapping(value = "v1/api/captain/ride")
public class CaptainResource extends CabResource<Captain, UUID> {

    protected CaptainOperations captainOperations;

    @Inject
    public CaptainResource(CaptainOperations captainOperations) {
        super(captainOperations);
        this.captainOperations = captainOperations;
    }

    /**
     * This API sends data of the cab. The details we required is
     * Speed, Location,Ride Status(isAvailable for a new Ride Request)
     * <p>
     * It will Help at the time Booking a New Ride for a USER, to Calculate
     * effective ETA
     *
     * @param id
     * @param details
     */
    @RequestMapping(
            value = "/{id}/send/location",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void sendData(@PathVariable("id") String id,
                         @RequestBody TrackDetails details) {
        captainOperations.sendData(UUID.fromString(id), details);
    }

    /**
     * Captain Accepts a incoming ride Request.
     * To Reject we have cancel Method
     *
     * @param id
     */
    @RequestMapping(
            value = "/{id}/accept",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void acceptRide(@PathVariable("id") String id) {
        captainOperations.acceptRide(UUID.fromString(id));
    }

}
