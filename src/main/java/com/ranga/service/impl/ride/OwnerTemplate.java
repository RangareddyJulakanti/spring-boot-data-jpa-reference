package com.ranga.service.impl.ride;

import com.ranga.domain.entity.EOwner;
import com.ranga.domain.repository.OwnerRepository;
import com.ranga.model.Directions;
import com.ranga.model.Invoice;
import com.ranga.model.Owner;
import com.ranga.service.operations.ride.OwnerOperations;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import java.util.UUID;

/**
 * Created by jabbars on 2/25/2017.
 */
@Named("hcOwnerTemplate")
public class OwnerTemplate extends CabTemplate<Owner, EOwner, UUID> implements OwnerOperations {

    private OwnerRepository ownerRepository;

    public OwnerTemplate(OwnerRepository ownerRepository) {
        super(ownerRepository);
        this.ownerRepository = ownerRepository;
    }

    // Here Validations can be performed for the User


    /**
     * OverRiding RideOperations which are not valid for Owner and Throw NotSupported Exception
     *
     * @return
     */

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean finish() {
        throw new UnsupportedOperationException("Operation not supported for Owner");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Boolean changeDirection(Directions directions) {
        throw new UnsupportedOperationException("Operation not supported for Owner");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Invoice invoice(UUID rideId) {
        throw new UnsupportedOperationException("Operation not supported for Owner");
    }

}
