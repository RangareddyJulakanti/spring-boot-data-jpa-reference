package com.ranga.service.operations.ride;

import com.ranga.model.CabRequest;
import com.ranga.model.Directions;
import com.ranga.model.Invoice;
import com.ranga.model.Reason;

import java.util.List;

/**
 * This Interface Provides all Information regarding Rides
 * This Operations are common for a Rider and CabDriver
 * <p>
 * <p>
 * Created by jabbars on 2/25/2017.
 */
public interface RideOperations<M, ID> {

    Integer completed();

    Integer cancelled();

    Integer total();

    Boolean cancel(Reason reason);

    Boolean finish();

    Boolean changeDirection(Directions directions);

    Invoice invoice(ID rideId);

    List<M> view(CabRequest request);
}
