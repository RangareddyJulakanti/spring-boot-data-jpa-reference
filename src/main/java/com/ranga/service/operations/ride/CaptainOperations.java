package com.ranga.service.operations.ride;

import com.ranga.model.Captain;
import com.ranga.model.TrackDetails;

import java.util.UUID;

/**
 * Created by jabbars on 2/25/2017.
 */
public interface CaptainOperations extends CabOperations<Captain, UUID> {

    void sendData(UUID id, TrackDetails trackDetails);

    void acceptRide(UUID id);
}
