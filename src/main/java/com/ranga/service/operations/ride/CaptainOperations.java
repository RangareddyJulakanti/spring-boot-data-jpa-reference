package com.ranga.service.operations.ride;

import com.ranga.model.Captain;
import com.ranga.model.TrackDetails;

import java.util.UUID;

/**
 * Created by RANGA on 1/10/2019.
 */
public interface CaptainOperations extends CabOperations<Captain, UUID> {

    void sendData(UUID id, TrackDetails trackDetails);

    void acceptRide(UUID id);
}
