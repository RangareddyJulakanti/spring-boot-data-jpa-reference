package com.ranga.service.operations.ride;

import com.ranga.model.Cab;
import com.ranga.model.TrackDetails;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by jabbars on 2/25/2017.
 */
public interface CabOperations<C extends Cab, ID extends Serializable> extends RideOperations<C,ID> {

    TrackDetails track(ID cabId);
    TrackDetails distanceCovered(ID cabId,ZonedDateTime start,ZonedDateTime end);
    Double totalAmountEarned(ID cabID,ZonedDateTime from, ZonedDateTime to);
    Long noOfRides(ID cabID,ZonedDateTime from, ZonedDateTime to);
    Boolean stopService(ID cabID,ZonedDateTime from, ZonedDateTime to);
    Boolean resumeService(ID cabID,ZonedDateTime from, ZonedDateTime to);


}
