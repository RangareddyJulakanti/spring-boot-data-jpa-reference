package com.ranga.rest.crud;

import com.ranga.model.Rider;
import com.ranga.service.operations.crud.RiderCrudOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by RANGA on 2/26/2017.
 */
@RestController("RiderCrudResource")
@RequestMapping(value = "v1/api/rider")
public class RiderCrudResource extends BaseResource<Rider,UUID> {


   RiderCrudOperations riderCrudOperations;

    public RiderCrudResource(RiderCrudOperations riderCrudOperations) {
        super(riderCrudOperations);
        this.riderCrudOperations = riderCrudOperations;
    }
}
