package com.ranga.rest.ride;

import com.ranga.model.Cab;
import com.ranga.model.TrackDetails;
import com.ranga.service.operations.ride.CabOperations;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * This Resource Handles Requests from Captain and Owner.
 * All apis will give Basic info of the CAB
 * <p>
 * Created by jabbars on 2/26/2017.
 */
public class CabResource<C extends Cab, ID extends Serializable> extends BaseRideResource<C, ID> {

    private CabOperations<C, ID> cabOperations;

    public CabResource(CabOperations<C, ID> cabOperations) {
        super(cabOperations);
        this.cabOperations = cabOperations;
    }

    /**
     * Gives Live Tracking Information of a Cab
     *
     * @param cabId for a given cabID
     * @return Tracking Details
     */
    @RequestMapping(
            value = "/{cabId}/track",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public TrackDetails viewTrackingDetailsOfCab(@PathVariable(value = "cabId") ID cabId) {
        return cabOperations.track(cabId);
    }

    /**
     * Distance covered By Cab
     * <p>
     * IF USer Provided Time
     * Return Distance covered in given Time Range
     * ELSE
     * Return from Start Date to Current DATE
     *
     * @param cabId
     * @return distance covered by the CAB
     */
    @RequestMapping(
            value = "/{cabId}/distance",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public TrackDetails distanceCovered(@PathVariable(value = "cabId") ID cabId,
                                        @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime startTime,
                                        @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime endTime) {
        return cabOperations.distanceCovered(cabId, startTime, endTime);
    }

    /**
     * No.Of Rides taken in a Given time
     * <p>
     * IF USer Provided Time
     * Return No.Of rides taken in given Time Range
     * ELSE
     * Return from Start Date to Current DATE
     *
     * @param cabId
     * @param startTime
     * @param endTime
     * @return No.Of rides taken by the CAB
     */
    @RequestMapping(
            value = "/{cabId}/rides",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Long noOfRides(@PathVariable(value = "cabId") ID cabId,
                          @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                  startTime,
                          @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                  endTime) {
        return cabOperations.noOfRides(cabId, startTime, endTime);
    }

    /**
     * If Captain/Owner want's to Stop the Service.
     * They Can stop for a specified time/ If they don't know how much time they need
     * they can stop without Time.
     * <>
     * IF user Provided Time
     * It will be available for a new Ride After given Time If User providea a Time Interval
     * ELSE
     * will be available for new Ride Until user Resumes it
     *
     * @param cabId
     * @param startTime
     * @param endTime
     */
    @RequestMapping(
            value = "/{cabId}/stop/service",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void StopService(@PathVariable(value = "cabId") ID cabId,
                            @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                    startTime,
                            @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                    endTime) {
        cabOperations.stopService(cabId, startTime, endTime);
    }

    /**
     * Resume service, to accept new Rides
     *
     * @param cabId
     * @param startTime
     * @param endTime
     */
    @RequestMapping(
            value = "/{cabId}/resume/service",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void resumeService(@PathVariable(value = "cabId") ID cabId,
                              @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                      startTime,
                              @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                      endTime) {
        cabOperations.resumeService(cabId, startTime, endTime);
    }

    /**
     * IF User wanted to know Money he earned
     * <p>
     * IF USer Provided Time
     * Return calculated amount in the given Time Range
     * ELSE
     * Return from Start Date to Current DATE
     *
     * @param cabId     Id of the CAB
     * @param startTime Date-time from which user want't to know
     * @param endTime   end date-time, upto when he want's to know
     * @return Calculate money from given Dates and Return the amount
     */
    @RequestMapping(
            value = "/{cabId}/amount",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public Double moneyEarned(@PathVariable(value = "cabId") ID cabId,
                              @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                      startTime,
                              @RequestParam(value = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime
                                      endTime) {
        return cabOperations.totalAmountEarned(cabId, startTime, endTime);
    }
}
