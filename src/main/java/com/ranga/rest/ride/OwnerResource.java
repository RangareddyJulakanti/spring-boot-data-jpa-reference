package com.ranga.rest.ride;

import com.ranga.model.Owner;
import com.ranga.service.operations.ride.OwnerOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

/**
 * This Resource Handles the Requests from a Owner,
 * Which are specifically meant for Him
 * <p>
 * Created by RANGA on 2/26/2017.
 */
@RestController("OwnerRideViewResource")
@RequestMapping(value = "v1/api/owner/ride")
public class OwnerResource extends CabResource<Owner, UUID> {

    protected OwnerOperations ownerOperations;

    @Inject
    public OwnerResource(OwnerOperations ownerOperations) {
        super(ownerOperations);
        this.ownerOperations = ownerOperations;
    }
}
