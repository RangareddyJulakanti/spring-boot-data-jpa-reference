package com.ranga.service.impl.ride;

import com.ranga.domain.entity.ECaptain;
import com.ranga.domain.repository.BaseRepository;
import com.ranga.domain.repository.CaptainRepository;
import com.ranga.model.Captain;
import com.ranga.model.TrackDetails;
import com.ranga.service.operations.ride.CaptainOperations;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.UUID;

/**
 * Created by jabbars on 2/25/2017.
 */
@Named("CaptainTemplate")
public class CaptainTemplate extends CabTemplate<Captain, ECaptain, UUID> implements CaptainOperations {

    private CaptainRepository captainRepository;

    public CaptainTemplate(BaseRepository<ECaptain, UUID> baseRepositorys, CaptainRepository captainRepository) {
        super(baseRepositorys);
        this.captainRepository = captainRepository;
    }

    // Validations can be performed with User Data, for Correctness

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void sendData(UUID id, TrackDetails trackDetails) {
        // 1. Call Google API to Get Geo Location
        Object data = googleOperations.searchPlace();
        // 2.Collect the Data
        // 3.Send data to Cloud/InMemory Database like Hazlecast
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void acceptRide(UUID id) {

    }
}
