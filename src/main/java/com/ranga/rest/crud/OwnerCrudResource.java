package com.ranga.rest.crud;

import com.ranga.model.Owner;
import com.ranga.service.operations.crud.OwnerCrudOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.UUID;

/**
 * Created by jabbars on 2/26/2017.
 */
@RestController("OwnerCrudResource")
@RequestMapping(value = "v1/api/owner")
public class OwnerCrudResource extends BaseResource<Owner,UUID> {


    OwnerCrudOperation ownerCrudOperation;

    @Inject
    public OwnerCrudResource(OwnerCrudOperation ownerCrudOperation) {
        super(ownerCrudOperation);
        this.ownerCrudOperation = ownerCrudOperation;
    }
}
