package com.ranga.service.impl.crud;

import com.ranga.domain.entity.EOwner;
import com.ranga.domain.repository.OwnerRepository;
import com.ranga.mapper.OwnerMapper;
import com.ranga.model.Owner;
import com.ranga.service.impl.BaseEntityValidator;
import com.ranga.service.operations.crud.OwnerCrudOperation;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

/**
 * Created by jabbars on 2/26/2017.
 */
@Named("OwnerCrudTemplate")
public class OwnerCrudTemplate extends BaseCrudTemplate<Owner, EOwner, UUID> implements OwnerCrudOperation {

    private OwnerRepository ownerRepository;

    @Inject
    public OwnerCrudTemplate(BaseEntityValidator<Owner> baseEntityValidator,
                             OwnerRepository ownerRepository) {
        super(ownerRepository, OwnerMapper.entity, OwnerMapper.model, OwnerMapper.update, baseEntityValidator);
        this.ownerRepository = ownerRepository;
    }
}
