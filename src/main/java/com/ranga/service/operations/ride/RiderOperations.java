package com.ranga.service.operations.ride;

import com.ranga.model.CabRequest;
import com.ranga.model.Captain;
import com.ranga.model.Rider;

import java.util.UUID;

/**
 * Created by jabbars on 2/25/2017.
 */
public interface RiderOperations extends RideOperations<Rider, UUID> {

    Captain request(UUID userId, CabRequest request);

    Captain request(UUID userId, UUID cabId, CabRequest request);

    Boolean requestLater(UUID userId, CabRequest request);

    Boolean planRide(UUID userId, CabRequest request);
}
