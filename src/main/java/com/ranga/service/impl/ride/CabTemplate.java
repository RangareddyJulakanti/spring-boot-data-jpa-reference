package com.ranga.service.impl.ride;

import com.ranga.domain.entity.EUser;
import com.ranga.domain.repository.BaseRepository;
import com.ranga.model.Cab;
import com.ranga.model.TrackDetails;
import com.ranga.service.operations.ride.CabOperations;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Created by jabbars on 2/25/2017.
 */
public abstract class CabTemplate<C extends Cab, E extends EUser, ID extends Serializable>
        extends RideTemplate<C, E, ID> implements CabOperations<C, ID> {

    public CabTemplate(BaseRepository<E, ID> baseRepositorys) {
        super(baseRepositorys);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TrackDetails track(ID cabID) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TrackDetails distanceCovered(ID cabID, ZonedDateTime start, ZonedDateTime end) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Double totalAmountEarned(ID cabID, ZonedDateTime from, ZonedDateTime to) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long noOfRides(ID cabID, ZonedDateTime from, ZonedDateTime to) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean stopService(ID cabID, ZonedDateTime from, ZonedDateTime to) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean resumeService(ID cabID, ZonedDateTime from, ZonedDateTime to) {
        return null;
    }
}
